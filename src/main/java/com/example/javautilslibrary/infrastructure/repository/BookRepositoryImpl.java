package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.mapper.BookMapper;
import com.example.javautilslibrary.common.utils.Constance;
import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.domain.object.value.BookStatus;
import com.example.javautilslibrary.domain.repository.BookRepository;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.BookEntityMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.BookEntityDynamicSqlSupport.bookEntity;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.update;
import static org.mybatis.dynamic.sql.render.RenderingStrategies.MYBATIS3;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private BookEntityMapper mybatis;

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Book> fetchAll(Integer limit) {
        var options = select(bookEntity.allColumns())
                .from(bookEntity)
                .limit(Objects.nonNull(limit) ? limit : Constance.DEFAULT_FETCH_LIMIT)
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectMany(options);
        return CollectionUtils.isNotEmpty(result) ? mapper.toDomainList(result) : Collections.EMPTY_LIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book fetchById(String id) {
        var result = mybatis.selectByPrimaryKey(id);
        return result.map(e -> mapper.toDomain(e)).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book save(BookEntity book) {
        book.setStatus(BookStatus.BE.getStatus());
        try {
            mybatis.insertSelective(book);
        } catch (Exception e) {
            throw new ClientException("failure to create book, already registry");
        }
        return mapper.toDomain(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book updateBook(String id, BookEntity book) {
        var options = update(bookEntity)
                .set(bookEntity.status).equalToWhenPresent(book.getStatus())
                .set(bookEntity.author).equalToWhenPresent(book.getAuthor())
                .set(bookEntity.title).equalToWhenPresent(book.getTitle())
                .set(bookEntity.description).equalToWhenPresent(book.getDescription())
                .set(bookEntity.imageUrl).equalToWhenPresent(book.getImageUrl())
                .set(bookEntity.publisher).equalToWhenPresent(book.getPublisher())
                .set(bookEntity.publishDate).equalToWhenPresent(book.getPublishDate())
                .where(bookEntity.bookId, isEqualTo(id))
                .build()
                .render(MYBATIS3);
        mybatis.update(options);
        var result = mybatis.selectByPrimaryKey(id);
        return result.map(e -> mapper.toDomain(e)).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteBook(String id) {
        return mybatis.deleteByPrimaryKey(id) > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book bookRental(String id) {
        var options = update(bookEntity)
                .set(bookEntity.status).equalTo(BookStatus.RENTAL.getStatus())
                .where(bookEntity.bookId, isEqualTo(id))
                .build().render(MYBATIS3);
        mybatis.update(options);
        var result = mybatis.selectByPrimaryKey(id);
        return result.map(e -> mapper.toDomain(e)).orElse(null);
    }
}

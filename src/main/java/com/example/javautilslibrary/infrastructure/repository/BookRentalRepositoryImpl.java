package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.domain.object.value.BookStatus;
import com.example.javautilslibrary.domain.repository.BookRentalRepository;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookRentalEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.BookRentalEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.BookEntityDynamicSqlSupport.bookEntity;
import static com.example.javautilslibrary.infrastructure.repository.mybatis.BookRentalEntityDynamicSqlSupport.bookRentalEntity;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;
import static org.mybatis.dynamic.sql.render.RenderingStrategies.MYBATIS3;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

@Repository
public class BookRentalRepositoryImpl implements BookRentalRepository {

    @Autowired
    private BookRentalEntityMapper mybatis;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean create(BookRentalEntity entity) {
        try {
            mybatis.insert(entity);
            return true;
        } catch (Exception e) {
            throw new ClientException("failure to create book rental history", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countBorrowedBook(Long memberId) {
        var options = select(bookRentalEntity.bookRentalId)
                .from(bookRentalEntity)
                .join(bookEntity).on(bookEntity.bookId, equalTo(bookRentalEntity.bookId))
                .where(bookRentalEntity.memberId, isEqualTo(memberId))
                .where(bookEntity.status, isIn(BookStatus.RENTAL.getStatus(), BookStatus.RESERVING.getStatus()))
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectMany(options);
        return result.size();
    }
}

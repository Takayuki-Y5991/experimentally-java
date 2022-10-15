package com.example.javautilslibrary.common.mapper;

import com.example.javautilslibrary.common.config.ConfigMapper;
import com.example.javautilslibrary.common.mapper.common.EnumConverter;
import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.domain.object.entity.Tag;
import com.example.javautilslibrary.domain.object.entity.aggregate.BookAggregate;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapi.example.model.BookListResponseBooksInner;
import org.openapi.example.model.BookRequest;
import org.openapi.example.model.BookResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = EnumConverter.class, config = ConfigMapper.class)
public interface BookMapper {
    @Mapping(target = "status", qualifiedByName = {"EnumConverter", "toBookStatus"})
    Book toDomain(BookEntity entity);

    @Mapping(target = "status", source = "book.status", qualifiedByName = {"EnumConverter", "toBookStatus"})
    Book toDomain(BookRequest request);

    @Mapping(target = "status", qualifiedByName = {"EnumConverter", "fromBookStatus"})
    BookEntity toEntity(Book book);

    @Mapping(target = "status", qualifiedByName = {"EnumConverter", "fromBookStatus"})
    org.openapi.example.model.Book toModel(Book book);

    org.openapi.example.model.Tag toModel(Tag tag);

    @Mapping(target = "book", source = "book")
    @Mapping(target = "book.status", qualifiedByName = {"EnumConverter", "fromBookStatus"})
    @Mapping(target = "tags", source = "tags")
    BookListResponseBooksInner toModel(BookAggregate source);

    default List<org.openapi.example.model.Tag> toModelList(List<Tag> source) {
        return source.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    default BookResponse toBookResponse(BookAggregate source) {
        var response = new BookResponse();
        response.setBook(this.toModel(source.getBook()));
        response.setTags(new ArrayList<>(this.toModelList(source.getTags())));
        return response;
    }

    default List<Book> toDomainList(List<BookEntity> entities) {
        return entities.stream().map(this::toDomain).collect(Collectors.toList());
    }

    default List<BookListResponseBooksInner> toBookResponse(List<BookAggregate> source) {
        return source.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

package com.example.javautilslibrary.domain.object.entity.aggregate;

import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.domain.object.entity.Tag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Book aggregate class
 */
@Data
@Builder(access = AccessLevel.PRIVATE)
public class BookAggregate {

    private Book book;
    private List<Tag> tags;

    public static BookAggregate build(Book book, List<Tag> tags) {
        return BookAggregate.builder()
                .book(book)
                .tags(tags)
                .build();
    }
}

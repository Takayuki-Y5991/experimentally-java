package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import com.example.javautilslibrary.domain.object.value.BookStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends Domain<Book> {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private String description;
    private String imageUrl;
    private BookStatus status;
}

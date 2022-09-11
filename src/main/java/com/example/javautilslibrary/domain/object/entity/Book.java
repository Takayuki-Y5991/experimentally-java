package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import com.example.javautilslibrary.domain.object.value.BookStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private List<Tag> tag;
}

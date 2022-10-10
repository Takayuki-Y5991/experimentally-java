package com.example.javautilslibrary.domain.repository;

import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookEntity;

import java.util.List;
import java.util.UUID;

/**
 * Book repository
 */
public interface BookRepository {

    /**
     * Fetch All Books
     *
     * @param book  book, select options
     * @param limit fetch count
     * @return books
     */
    List<Book> fetchAll(BookEntity book, Integer limit);

    /**
     * Fetch Books
     *
     * @param id book_id
     * @return book
     */
    Book fetchById(UUID id);

    /**
     * Save Book
     *
     * @param book book
     * @return book
     */
    Book save(BookEntity book);

    /**
     * Book update status
     *
     * @param id     book_id
     * @param status status (1: Be, 2: rental, 3: reserving)
     * @return book
     */
    Book updateBook(UUID id, Integer status);

    /**
     * Book delete
     *
     * @param id book_id
     */
    void deleteBook(UUID id);

}

package com.example.javautilslibrary.domain.repository;

import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookEntity;

import java.util.List;

/**
 * Book repository
 */
public interface BookRepository {

    /**
     * Fetch All Books
     *
     * @param limit fetch count
     * @return books
     */
    List<Book> fetchAll(Integer limit);

    /**
     * Fetch Books
     *
     * @param id book_id
     * @return book
     */
    Book fetchById(String id);

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
     * @param id   book_id
     * @param book book
     * @return book
     */
    Book updateBook(String id, BookEntity book);

    /**
     * Book delete
     *
     * @param id book_id
     * @return true: successful delete, false: failed delete
     */
    boolean deleteBook(String id);

}

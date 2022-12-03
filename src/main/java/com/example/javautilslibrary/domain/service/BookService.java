package com.example.javautilslibrary.domain.service;

import org.openapi.example.model.BookListResponse;
import org.openapi.example.model.BookRequest;
import org.openapi.example.model.BookResponse;

import java.util.List;

/**
 * Book Service implementation
 */
public interface BookService {
    /**
     * create book
     *
     * @param request request
     */
    void createBook(BookRequest request);

    /**
     * delete book by book id
     *
     * @param bookId Book ID
     */
    void deleteBook(String bookId);

    /**
     * update book by book id
     *
     * @param bookId  Book ID
     * @param request request
     */
    void updateBook(String bookId, BookRequest request);

    /**
     * fetch book by book id
     *
     * @param bookId Book ID
     * @return Book Information
     */
    BookResponse findById(String bookId);

    /**
     * fetch all books
     *
     * @param limit number of books fetch count
     */
    BookListResponse findAll(Integer limit);

    /**
     * Borrow books
     *
     * @param bookId        Book ID
     * @param authorization token
     * @return loading complete books
     */
    BookListResponse borrowBooks(List<String> bookId, String authorization);
}

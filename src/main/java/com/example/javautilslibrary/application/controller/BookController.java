package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.converter.CommonResponseConverter;
import com.example.javautilslibrary.common.config.anotation.Authorize;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.BookService;
import org.openapi.example.api.BookApi;
import org.openapi.example.api.BooksApi;
import org.openapi.example.model.BookListResponse;
import org.openapi.example.model.BookRentalRequest;
import org.openapi.example.model.BookRequest;
import org.openapi.example.model.BookResponse;
import org.openapi.example.model.CreatedResponse;
import org.openapi.example.model.DeletedResponse;
import org.openapi.example.model.NoContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class BookController implements BookApi, BooksApi {

    @Autowired
    private BookService service;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return BookApi.super.getRequest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonAuthorize
    public ResponseEntity<BookListResponse> getAllBookInformation(Integer count) {
        var result = service.findAll(count);
        return ResponseEntity.ok(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<CreatedResponse> createBook(String authorization, BookRequest bookRequest) {
        service.createBook(bookRequest);
        return ResponseEntity.ok(CommonResponseConverter.buildCreated(("Book")));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<DeletedResponse> deleteBook(String bookId, String authorization) {
        service.deleteBook(bookId);
        return ResponseEntity.ok(CommonResponseConverter.buildDeleted(String.format("Book id: %s", bookId)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<BookResponse> getBookInformation(String bookId) {
        var result = service.findById(bookId);
        return ResponseEntity.ok(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<NoContentResponse> updateBook(String bookId, String authorization, BookRequest bookRequest) {
        service.updateBook(bookId, bookRequest);
        return ResponseEntity.ok(CommonResponseConverter.buildUpdated(String.format("Book id: %s", bookId)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<BookListResponse> borrowBooks(String authorization, BookRentalRequest bookRentalRequest) {
        var result = service.borrowBooks(bookRentalRequest.getBookId(), authorization);
        return ResponseEntity.ok(result);
    }
}

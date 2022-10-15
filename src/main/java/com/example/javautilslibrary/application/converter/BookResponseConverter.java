package com.example.javautilslibrary.application.converter;

import org.openapi.example.model.BookListResponse;
import org.openapi.example.model.BookListResponseBooksInner;

import java.util.List;

/**
 * Book response converter
 */
public class BookResponseConverter {

    public static BookListResponse buildBooKResponse(List<BookListResponseBooksInner> source) {
        var response = new BookListResponse();
        response.setCount(source.size());
        response.setBooks(source);
        return response;
    }
}

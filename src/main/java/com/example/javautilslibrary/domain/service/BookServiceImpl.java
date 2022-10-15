package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.converter.BookResponseConverter;
import com.example.javautilslibrary.common.enums.Mode;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.exception.ResourceNotFoundException;
import com.example.javautilslibrary.common.mapper.BookMapper;
import com.example.javautilslibrary.domain.object.entity.aggregate.BookAggregate;
import com.example.javautilslibrary.domain.repository.BookRepository;
import com.example.javautilslibrary.domain.repository.BookTagRepository;
import com.example.javautilslibrary.domain.repository.TagRepository;
import org.openapi.example.model.BookListResponse;
import org.openapi.example.model.BookRequest;
import org.openapi.example.model.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * {@link BookService} implementation
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BookTagRepository bookTagRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void createBook(BookRequest request) {
        var domain = mapper.toDomain(request);
        var result = bookRepository.save(mapper.toEntity(domain));
        if (Objects.isNull(result)) {
            throw new ClientException("failure to create Book");
        }
        try {
            bookTagRepository.save(result.getBookId(), request.getTags(), Mode.NEW);
        } catch (Exception e) {
            throw new ClientException("failure to register book tag related");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteBook(String bookId) {
        /* Delete Book */
        bookRepository.deleteBook(bookId);
        /* Delete Related Book - Tag */
        bookTagRepository.delete(bookId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateBook(String bookId, BookRequest request) {
        var domain = mapper.toDomain(request);
        var result = bookRepository.updateBook(bookId, mapper.toEntity(domain));
        if (Objects.isNull(result)) {
            throw new ClientException("failure to update Book");
        }
        try {
            bookTagRepository.save(result.getBookId(), request.getTags(), Mode.CHANGE);
        } catch (Exception e) {
            throw new ClientException("failure to register book tag related");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public BookResponse findById(String bookId) {
        var result = bookRepository.fetchById(bookId);
        if (Objects.isNull(result)) {
            throw new ResourceNotFoundException(String.format("Book Id: [%s] not found", bookId));
        }
        var tags = tagRepository.fetchAllRelatedBookId(bookId);
        return mapper.toBookResponse(BookAggregate.build(result, tags));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public BookListResponse findAll(Integer limit) {
        var bookResult = bookRepository.fetchAll(limit);
        var result = bookResult.stream()
                .map(e -> {
                    var tags = tagRepository.fetchAllRelatedBookId(e.getBookId());
                    return BookAggregate.build(e, tags);
                }).toList();
        return BookResponseConverter.buildBooKResponse(mapper.toBookResponse(result));
    }
}

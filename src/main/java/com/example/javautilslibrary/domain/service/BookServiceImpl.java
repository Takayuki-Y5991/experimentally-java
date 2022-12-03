package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.converter.BookResponseConverter;
import com.example.javautilslibrary.common.enums.Mode;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.exception.DomainException;
import com.example.javautilslibrary.common.exception.ResourceNotFoundException;
import com.example.javautilslibrary.common.mapper.BookMapper;
import com.example.javautilslibrary.common.mapper.BookRentalMapper;
import com.example.javautilslibrary.common.mapper.MemberMapper;
import com.example.javautilslibrary.common.utils.Constance;
import com.example.javautilslibrary.common.utils.JwtUtils;
import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.domain.object.entity.aggregate.BookAggregate;
import com.example.javautilslibrary.domain.object.value.BookStatus;
import com.example.javautilslibrary.domain.repository.BookRentalRepository;
import com.example.javautilslibrary.domain.repository.BookRepository;
import com.example.javautilslibrary.domain.repository.BookTagRepository;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import com.example.javautilslibrary.domain.repository.TagRepository;
import org.openapi.example.model.BookListResponse;
import org.openapi.example.model.BookRequest;
import org.openapi.example.model.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * {@link BookService} implementation
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BookRentalMapper bookRentalMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BookTagRepository bookTagRepository;

    @Autowired
    private BookRentalRepository bookRentalRepository;

    @Autowired
    private MemberRepository memberRepository;

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
        /* Delete Related Book - Tag */
        bookTagRepository.delete(bookId);
        /* Delete Book */
        bookRepository.deleteBook(bookId);
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

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public BookListResponse borrowBooks(List<String> bookId, String token) {

        // Fetch account data
        var accountName = jwtUtils.parseToken(token);
        var member = memberRepository.fetchByAccountName(accountName);

        // Check Count Borrowed Book
        var countHaveBook = bookRentalRepository.countBorrowedBook(member.getMemberId());
        var countBorrowBook = bookId.size();
        if (!canBorrowBookByBorrowedCount.test(countHaveBook + countBorrowBook)) {
            throw new DomainException(String.format("You have exceeded the maximum number of books, you can borrow %d", countCanBorrowBook.apply(countHaveBook)));
        }

        // Book rental workflows
        var result = bookId.parallelStream()
                .map(e -> {
                    // Check book status
                    var rentalTarget = bookRepository.fetchById(e);
                    if (canBorrowBookByStatus.test(rentalTarget)) {
                        // Borrow the book
                        var borrowedBook = bookRepository.bookRental(e);
                        // Create book rental history
                        var entity = bookRentalMapper.toEntity(bookRentalMapper.generateDomain(member, borrowedBook, Constance.DEFAULT_BOOK_RETURN_LIMIT()));
                        bookRentalRepository.create(entity);
                        // Generate Loading complete Book
                        var tags = tagRepository.fetchAllRelatedBookId(borrowedBook.getBookId());
                        return BookAggregate.build(borrowedBook, tags);
                    } else {
                        throw new DomainException(String.format("%s is borrowed...", rentalTarget.getTitle()));
                    }
                }).toList();
        return BookResponseConverter.buildBooKResponse(mapper.toBookResponse(result));
    }

    private final Predicate<Book> canBorrowBookByStatus = (source) -> {
        return source.getStatus() == BookStatus.BE;
    };

    private final Predicate<Integer> canBorrowBookByBorrowedCount = (source) -> {
        return source <= Constance.DEFAULT_BOOK_MAX_BORROWED_COUNT;
    };

    private final Function<Integer, Integer> countCanBorrowBook = (source) -> {
        return Constance.DEFAULT_BOOK_MAX_BORROWED_COUNT - source;
    };

}

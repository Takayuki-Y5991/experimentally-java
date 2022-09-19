package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;

import java.time.LocalDateTime;


public class BookRental extends Domain<BookRental> {

    private Long bookRentalId;
    private LocalDateTime checkoutDate;
    private LocalDateTime returnDate;
    private Book book;
    private Member member;
}

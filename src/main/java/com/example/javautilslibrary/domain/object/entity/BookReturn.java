package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;

import java.time.LocalDateTime;


public class BookReturn extends Domain<BookReturn> {
    private Long bookReturnId;
    private LocalDateTime returnDate;
    private BookRental rental;
}

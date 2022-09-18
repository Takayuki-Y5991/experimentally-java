package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import com.example.javautilslibrary.infrastructure.entity.member.MemberEntity;

import java.time.LocalDateTime;


public class BookRental extends Domain<BookRental> {
    private Long bookRentalId;

    private LocalDateTime checkoutDate;

    private LocalDateTime returnDate;

    private Book book;

    private MemberEntity member;
}

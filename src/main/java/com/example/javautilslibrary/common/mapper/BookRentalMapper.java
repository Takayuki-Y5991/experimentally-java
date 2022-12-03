package com.example.javautilslibrary.common.mapper;

import com.example.javautilslibrary.common.config.ConfigMapper;
import com.example.javautilslibrary.common.mapper.common.EnumConverter;
import com.example.javautilslibrary.domain.object.entity.Book;
import com.example.javautilslibrary.domain.object.entity.BookRental;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookRentalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(uses = EnumConverter.class, config = ConfigMapper.class)
public interface BookRentalMapper {

    default BookRental generateDomain(Member member, Book book, LocalDateTime returnDate) {
        return BookRental.builder()
                .member(member)
                .book(book)
                .checkoutDate(LocalDateTime.now())
                .returnDate(returnDate)
                .build();
    }

    @Mapping(target = "bookId", source = "domain.book.bookId")
    @Mapping(target = "memberId", source = "domain.member.memberId")
    BookRentalEntity toEntity(BookRental domain);
}

package com.example.javautilslibrary.infrastructure.entity.mybatis;

import javax.annotation.Generated;

public class MemberRentalBookEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180949943+09:00", comments="Source field: member_rental_book.member_id")
    private Long memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18097406+09:00", comments="Source field: member_rental_book.book_id")
    private String bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180959386+09:00", comments="Source field: member_rental_book.member_id")
    public Long getMemberId() {
        return memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180967921+09:00", comments="Source field: member_rental_book.member_id")
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180980082+09:00", comments="Source field: member_rental_book.book_id")
    public String getBookId() {
        return bookId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180987313+09:00", comments="Source field: member_rental_book.book_id")
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
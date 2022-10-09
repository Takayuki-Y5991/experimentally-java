package com.example.javautilslibrary.infrastructure.entity.mybatis;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class BookRentalEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178886359+09:00", comments="Source field: book_rental.book_rental_id")
    private Long bookRentalId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178917836+09:00", comments="Source field: book_rental.checkout_date")
    private LocalDateTime checkoutDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178943161+09:00", comments="Source field: book_rental.return_date")
    private LocalDateTime returnDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.1789596+09:00", comments="Source field: book_rental.book_id")
    private String bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178976607+09:00", comments="Source field: book_rental.member_id")
    private Long memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178903263+09:00", comments="Source field: book_rental.book_rental_id")
    public Long getBookRentalId() {
        return bookRentalId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178912648+09:00", comments="Source field: book_rental.book_rental_id")
    public void setBookRentalId(Long bookRentalId) {
        this.bookRentalId = bookRentalId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178932444+09:00", comments="Source field: book_rental.checkout_date")
    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178938906+09:00", comments="Source field: book_rental.checkout_date")
    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178949349+09:00", comments="Source field: book_rental.return_date")
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178955034+09:00", comments="Source field: book_rental.return_date")
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178965187+09:00", comments="Source field: book_rental.book_id")
    public String getBookId() {
        return bookId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178971707+09:00", comments="Source field: book_rental.book_id")
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.17898148+09:00", comments="Source field: book_rental.member_id")
    public Long getMemberId() {
        return memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178987415+09:00", comments="Source field: book_rental.member_id")
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
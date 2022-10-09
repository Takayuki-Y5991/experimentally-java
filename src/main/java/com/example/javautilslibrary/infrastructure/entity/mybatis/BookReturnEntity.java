package com.example.javautilslibrary.infrastructure.entity.mybatis;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class BookReturnEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179427204+09:00", comments="Source field: book_return.book_return_id")
    private Long bookReturnId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179446972+09:00", comments="Source field: book_return.return_date")
    private LocalDateTime returnDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179464268+09:00", comments="Source field: book_return.book_rental_id")
    private Long bookRentalId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179435318+09:00", comments="Source field: book_return.book_return_id")
    public Long getBookReturnId() {
        return bookReturnId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179442086+09:00", comments="Source field: book_return.book_return_id")
    public void setBookReturnId(Long bookReturnId) {
        this.bookReturnId = bookReturnId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179453222+09:00", comments="Source field: book_return.return_date")
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179459647+09:00", comments="Source field: book_return.return_date")
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179469405+09:00", comments="Source field: book_return.book_rental_id")
    public Long getBookRentalId() {
        return bookRentalId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179475235+09:00", comments="Source field: book_return.book_rental_id")
    public void setBookRentalId(Long bookRentalId) {
        this.bookRentalId = bookRentalId;
    }
}
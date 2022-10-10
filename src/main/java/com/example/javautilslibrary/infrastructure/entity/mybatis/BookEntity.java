package com.example.javautilslibrary.infrastructure.entity.mybatis;

import java.time.LocalDate;
import javax.annotation.Generated;

public class BookEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177665917+09:00", comments="Source field: book.book_id")
    private String bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177702951+09:00", comments="Source field: book.author")
    private String author;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177721417+09:00", comments="Source field: book.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177739734+09:00", comments="Source field: book.image_url")
    private String imageUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177756699+09:00", comments="Source field: book.publish_date")
    private LocalDate publishDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177785062+09:00", comments="Source field: book.publisher")
    private String publisher;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177801284+09:00", comments="Source field: book.status")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177816144+09:00", comments="Source field: book.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.1776852+09:00", comments="Source field: book.book_id")
    public String getBookId() {
        return bookId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177696647+09:00", comments="Source field: book.book_id")
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177709207+09:00", comments="Source field: book.author")
    public String getAuthor() {
        return author;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.17771594+09:00", comments="Source field: book.author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177728744+09:00", comments="Source field: book.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177735317+09:00", comments="Source field: book.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177744892+09:00", comments="Source field: book.image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177751+09:00", comments="Source field: book.image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177771935+09:00", comments="Source field: book.publish_date")
    public LocalDate getPublishDate() {
        return publishDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177778351+09:00", comments="Source field: book.publish_date")
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177790406+09:00", comments="Source field: book.publisher")
    public String getPublisher() {
        return publisher;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177796889+09:00", comments="Source field: book.publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177806377+09:00", comments="Source field: book.status")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177811723+09:00", comments="Source field: book.status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177821259+09:00", comments="Source field: book.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.177827245+09:00", comments="Source field: book.title")
    public void setTitle(String title) {
        this.title = title;
    }
}
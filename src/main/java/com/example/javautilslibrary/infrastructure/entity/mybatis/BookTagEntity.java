package com.example.javautilslibrary.infrastructure.entity.mybatis;

import javax.annotation.Generated;

public class BookTagEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.168055598+09:00", comments="Source field: book_tag.tag_id")
    private Long tagId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.16870495+09:00", comments="Source field: book_tag.book_id")
    private String bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.168507612+09:00", comments="Source field: book_tag.tag_id")
    public Long getTagId() {
        return tagId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.168687355+09:00", comments="Source field: book_tag.tag_id")
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.168716513+09:00", comments="Source field: book_tag.book_id")
    public String getBookId() {
        return bookId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.168750735+09:00", comments="Source field: book_tag.book_id")
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
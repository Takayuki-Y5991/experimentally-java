package com.example.javautilslibrary.application.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class BookRequest {
    @JsonProperty(value = "bookId")
    private UUID bookId;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "author")
    private String author;
    @JsonProperty(value = "publisher")
    private String publisher;
    @JsonProperty(value = "publish_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "imageUrl")
    private String imageUrl;
    @JsonProperty(value = "status")
    private Integer status;
    @JsonProperty(value = "tags")
    private List<Integer> tags;

    public BookRequest() {

    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
    
}

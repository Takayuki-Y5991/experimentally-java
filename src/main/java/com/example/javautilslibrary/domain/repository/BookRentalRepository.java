package com.example.javautilslibrary.domain.repository;


import com.example.javautilslibrary.infrastructure.entity.mybatis.BookRentalEntity;

public interface BookRentalRepository {

    /**
     * Create rental book history
     *
     * @param entity book rental information
     * @return true: successful create, false: failed create
     */
    boolean create(BookRentalEntity entity);

    /**
     * Count member's borrowed books
     *
     * @param memberId Member Id
     * @return count of borrowed books
     */
    int countBorrowedBook(Long memberId);
}

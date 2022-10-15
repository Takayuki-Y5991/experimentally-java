package com.example.javautilslibrary.domain.repository;

import com.example.javautilslibrary.common.enums.Mode;

import java.util.List;

/**
 * Book-Tag related repository
 */
public interface BookTagRepository {
    /**
     * Save Related (Book - Tag)
     *
     * @param bookId Book ID
     * @param tags   Tags ID
     * @param mode   1: NEW, 2: CHANGE
     */
    void save(String bookId, List<Integer> tags, Mode mode);

    /**
     * Delete Related (Book - Tag)
     *
     * @param bookId Book ID
     */
    void delete(String bookId);
}

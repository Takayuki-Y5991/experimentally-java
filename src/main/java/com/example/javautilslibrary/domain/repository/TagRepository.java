package com.example.javautilslibrary.domain.repository;

import com.example.javautilslibrary.domain.object.entity.Tag;
import com.example.javautilslibrary.infrastructure.entity.mybatis.TagEntity;

import java.util.List;

/**
 * Tag repository
 */
public interface TagRepository {
    /**
     * Fetch All Tags
     *
     * @return tags
     */
    List<Tag> fetchALl();

    /**
     * Fetch All Tags, related to book
     *
     * @param bookId Book ID
     * @return tags
     */
    List<Tag> fetchAllRelatedBookId(String bookId);

    /**
     * Save tags
     *
     * @param tags
     */
    void save(List<TagEntity> tags);
}

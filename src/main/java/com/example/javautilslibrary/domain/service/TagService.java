package com.example.javautilslibrary.domain.service;

import org.openapi.example.model.TagResponse;

import java.util.List;

/*+
 * Tag service
 */
public interface TagService {

    /**
     * @param tagName tag name
     */
    void create(List<String> tagName);

    /**
     * Fetch Tags data
     *
     * @return Tags
     */
    TagResponse findAll();

}

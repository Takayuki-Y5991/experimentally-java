package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.converter.CommonResponseConverter;
import com.example.javautilslibrary.common.config.anotation.Authorize;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.TagService;
import org.openapi.example.api.TagsApi;
import org.openapi.example.model.CreatedResponse;
import org.openapi.example.model.TagRequest;
import org.openapi.example.model.TagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController implements TagsApi {

    @Autowired
    private TagService service;

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<CreatedResponse> createTag(String authorization, TagRequest tagRequest) {
        service.create(tagRequest.getTags());
        return ResponseEntity.ok(CommonResponseConverter.buildCreated("Tags"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonAuthorize
    public ResponseEntity<TagResponse> getAllTagInformation() {
        var result = service.findAll();
        return ResponseEntity.ok(result);
    }
}

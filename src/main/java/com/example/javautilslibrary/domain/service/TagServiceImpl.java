package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.converter.TagResponseConverter;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.mapper.TagMapper;
import com.example.javautilslibrary.domain.object.entity.Tag;
import com.example.javautilslibrary.domain.repository.TagRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.openapi.example.model.TagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository repository;

    @Autowired
    private TagMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void create(List<String> tagName) {
        var entities = mapper.toEntityList(tagName);
        var existTags = repository.fetchAll().stream().map(Tag::getName).toList();
        // will save tag data for not exist database
        var shouldSaveEntity = entities.stream()
                .filter(e -> !existTags.contains(e)).toList();
        if (CollectionUtils.isNotEmpty(shouldSaveEntity)) {
            try {
                repository.save(shouldSaveEntity);
            } catch (Exception e) {
                throw new ClientException("failure to register tag");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public TagResponse findAll() {
        var fetchData = repository.fetchAll();
        return TagResponseConverter.buildBookResponse(mapper.toResponse(fetchData));
    }
}

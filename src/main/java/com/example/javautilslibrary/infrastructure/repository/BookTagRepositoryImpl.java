package com.example.javautilslibrary.infrastructure.repository;


import com.example.javautilslibrary.common.enums.Mode;
import com.example.javautilslibrary.domain.repository.BookTagRepository;
import com.example.javautilslibrary.infrastructure.entity.mybatis.BookTagEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.BookTagEntityMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.BookTagEntityDynamicSqlSupport.bookTagEntity;
import static org.mybatis.dynamic.sql.SqlBuilder.deleteFrom;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.render.RenderingStrategies.MYBATIS3;

/**
 * {@link BookTagRepository} implementation
 */
@Repository
public class BookTagRepositoryImpl implements BookTagRepository {

    @Autowired
    private BookTagEntityMapper mybatis;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(String bookId, List<Integer> tags, Mode mode) {
        if (CollectionUtils.isNotEmpty(tags)) {
            // TagEntityObject Generated
            var entities = tags.stream()
                    .map(e -> {
                        var entity = new BookTagEntity();
                        entity.setBookId(bookId);
                        entity.setTagId(Long.valueOf(e));
                        return entity;
                    }).collect(Collectors.toSet());
            // If exist data, it will delete
            if (mode == Mode.CHANGE) {
                tags.forEach(e -> mybatis.deleteByPrimaryKey(Long.valueOf(e), bookId));
            }
            entities.forEach(e -> mybatis.insert(e));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String bookId) {
        var options = deleteFrom(bookTagEntity)
                .where(bookTagEntity.bookId, isEqualTo(bookId))
                .build()
                .render(MYBATIS3);
        mybatis.delete(options);
    }
}

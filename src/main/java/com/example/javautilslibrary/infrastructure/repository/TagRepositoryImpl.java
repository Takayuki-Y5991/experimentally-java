package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.common.mapper.TagMapper;
import com.example.javautilslibrary.domain.object.entity.Tag;
import com.example.javautilslibrary.domain.repository.TagRepository;
import com.example.javautilslibrary.infrastructure.entity.mybatis.TagEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.TagEntityMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.BookTagEntityDynamicSqlSupport.bookTagEntity;
import static com.example.javautilslibrary.infrastructure.repository.mybatis.TagEntityDynamicSqlSupport.tagEntity;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static org.mybatis.dynamic.sql.render.RenderingStrategies.MYBATIS3;

/**
 * Tag repository
 */
@Repository
public class TagRepositoryImpl implements TagRepository {

    @Autowired
    private TagMapper mapper;

    @Autowired
    private TagEntityMapper mybatis;

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Tag> fetchALl() {
        var options = select(tagEntity.allColumns())
                .from(tagEntity)
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectMany(options);
        return CollectionUtils.isNotEmpty(result) ? mapper.toDomainList(result) : Collections.EMPTY_LIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Tag> fetchAllRelatedBookId(String bookId) {
        var options = select(tagEntity.allColumns())
                .from(tagEntity, "t1")
                .join(bookTagEntity, "t2").on(tagEntity.tagId, equalTo(bookTagEntity.tagId))
                .where(bookTagEntity.bookId, isEqualTo(bookId))
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectMany(options);
        return CollectionUtils.isNotEmpty(result) ? mapper.toDomainList(result) : Collections.EMPTY_LIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(List<TagEntity> tags) {
        tags.forEach(mybatis::insert);
    }
}

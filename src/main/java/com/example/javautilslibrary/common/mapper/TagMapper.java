package com.example.javautilslibrary.common.mapper;

import com.example.javautilslibrary.common.config.ConfigMapper;
import com.example.javautilslibrary.common.mapper.common.EnumConverter;
import com.example.javautilslibrary.domain.object.entity.Tag;
import com.example.javautilslibrary.infrastructure.entity.mybatis.TagEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = EnumConverter.class, config = ConfigMapper.class)
public interface TagMapper {

    Tag toDomain(TagEntity entity);

    TagEntity toEntity(Tag target);

    default List<Tag> toDomainList(List<TagEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}

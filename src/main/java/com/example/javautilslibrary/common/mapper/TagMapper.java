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

    default List<TagEntity> toEntityList(List<String> domains) {
        return domains.stream()
                .map(e -> {
                    var obj = new TagEntity();
                    obj.setTagName(e);
                    return obj;
                })
                .collect(Collectors.toList());
    }

    /**
     * mapping domain to response
     *
     * @param domain domain
     * @return response model
     */
    org.openapi.example.model.Tag toTag(Tag domain);

    /**
     * mapping List<domain> to List<response>
     *
     * @param sources domain (Type List)
     * @return response model
     */
    default List<org.openapi.example.model.Tag> toResponse(List<Tag> sources) {
        return sources.stream()
                .map(this::toTag)
                .collect(Collectors.toList());
    }
}

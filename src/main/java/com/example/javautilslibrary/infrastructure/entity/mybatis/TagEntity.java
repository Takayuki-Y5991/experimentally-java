package com.example.javautilslibrary.infrastructure.entity.mybatis;

import javax.annotation.Generated;

public class TagEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178446634+09:00", comments="Source field: tag.tag_id")
    private Long tagId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178469171+09:00", comments="Source field: tag.tag_name")
    private String tagName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178455978+09:00", comments="Source field: tag.tag_id")
    public Long getTagId() {
        return tagId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178463616+09:00", comments="Source field: tag.tag_id")
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178475983+09:00", comments="Source field: tag.tag_name")
    public String getTagName() {
        return tagName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.17848273+09:00", comments="Source field: tag.tag_name")
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
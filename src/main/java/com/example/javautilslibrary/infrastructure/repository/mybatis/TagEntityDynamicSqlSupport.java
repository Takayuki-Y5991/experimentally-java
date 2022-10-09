package com.example.javautilslibrary.infrastructure.repository.mybatis;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TagEntityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178511451+09:00", comments="Source Table: tag")
    public static final TagEntity tagEntity = new TagEntity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178535844+09:00", comments="Source field: tag.tag_id")
    public static final SqlColumn<Long> tagId = tagEntity.tagId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178546907+09:00", comments="Source field: tag.tag_name")
    public static final SqlColumn<String> tagName = tagEntity.tagName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.178525828+09:00", comments="Source Table: tag")
    public static final class TagEntity extends AliasableSqlTable<TagEntity> {
        public final SqlColumn<Long> tagId = column("tag_id", JDBCType.BIGINT);

        public final SqlColumn<String> tagName = column("tag_name", JDBCType.VARCHAR);

        public TagEntity() {
            super("tag", TagEntity::new);
        }
    }
}
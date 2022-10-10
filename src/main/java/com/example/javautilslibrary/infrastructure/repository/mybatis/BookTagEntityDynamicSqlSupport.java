package com.example.javautilslibrary.infrastructure.repository.mybatis;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class BookTagEntityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.170241546+09:00", comments="Source Table: book_tag")
    public static final BookTagEntity bookTagEntity = new BookTagEntity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.170334534+09:00", comments="Source field: book_tag.tag_id")
    public static final SqlColumn<Long> tagId = bookTagEntity.tagId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.17051423+09:00", comments="Source field: book_tag.book_id")
    public static final SqlColumn<String> bookId = bookTagEntity.bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.170303886+09:00", comments="Source Table: book_tag")
    public static final class BookTagEntity extends AliasableSqlTable<BookTagEntity> {
        public final SqlColumn<Long> tagId = column("tag_id", JDBCType.BIGINT);

        public final SqlColumn<String> bookId = column("book_id", JDBCType.VARCHAR);

        public BookTagEntity() {
            super("book_tag", BookTagEntity::new);
        }
    }
}
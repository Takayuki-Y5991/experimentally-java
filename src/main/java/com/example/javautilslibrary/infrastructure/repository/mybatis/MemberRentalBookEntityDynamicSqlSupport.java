package com.example.javautilslibrary.infrastructure.repository.mybatis;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MemberRentalBookEntityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18101675+09:00", comments="Source Table: member_rental_book")
    public static final MemberRentalBookEntity memberRentalBookEntity = new MemberRentalBookEntity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.181044532+09:00", comments="Source field: member_rental_book.member_id")
    public static final SqlColumn<Long> memberId = memberRentalBookEntity.memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.181055974+09:00", comments="Source field: member_rental_book.book_id")
    public static final SqlColumn<String> bookId = memberRentalBookEntity.bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.181033165+09:00", comments="Source Table: member_rental_book")
    public static final class MemberRentalBookEntity extends AliasableSqlTable<MemberRentalBookEntity> {
        public final SqlColumn<Long> memberId = column("member_id", JDBCType.BIGINT);

        public final SqlColumn<String> bookId = column("book_id", JDBCType.VARCHAR);

        public MemberRentalBookEntity() {
            super("member_rental_book", MemberRentalBookEntity::new);
        }
    }
}
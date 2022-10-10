package com.example.javautilslibrary.infrastructure.repository.mybatis;

import java.sql.JDBCType;
import java.time.LocalDate;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MemberEntityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180390707+09:00", comments="Source Table: member")
    public static final MemberEntity memberEntity = new MemberEntity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180441777+09:00", comments="Source field: member.member_id")
    public static final SqlColumn<Long> memberId = memberEntity.memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180453593+09:00", comments="Source field: member.account_name")
    public static final SqlColumn<String> accountName = memberEntity.accountName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18046448+09:00", comments="Source field: member.birthday")
    public static final SqlColumn<LocalDate> birthday = memberEntity.birthday;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180474006+09:00", comments="Source field: member.contact")
    public static final SqlColumn<String> contact = memberEntity.contact;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18048296+09:00", comments="Source field: member.email")
    public static final SqlColumn<String> email = memberEntity.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180491488+09:00", comments="Source field: member.name")
    public static final SqlColumn<String> name = memberEntity.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18049964+09:00", comments="Source field: member.password")
    public static final SqlColumn<String> password = memberEntity.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180509579+09:00", comments="Source field: member.sex")
    public static final SqlColumn<Integer> sex = memberEntity.sex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180423946+09:00", comments="Source Table: member")
    public static final class MemberEntity extends AliasableSqlTable<MemberEntity> {
        public final SqlColumn<Long> memberId = column("member_id", JDBCType.BIGINT);

        public final SqlColumn<String> accountName = column("account_name", JDBCType.VARCHAR);

        public final SqlColumn<LocalDate> birthday = column("birthday", JDBCType.DATE);

        public final SqlColumn<String> contact = column("contact", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sex = column("sex", JDBCType.INTEGER);

        public MemberEntity() {
            super("member", MemberEntity::new);
        }
    }
}
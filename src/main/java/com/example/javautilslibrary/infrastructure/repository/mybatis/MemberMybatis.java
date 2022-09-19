package com.example.javautilslibrary.infrastructure.repository.mybatis;

import com.example.javautilslibrary.common.utils.ConvertUtils;
import com.example.javautilslibrary.infrastructure.entity.member.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;

import java.sql.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Mapper
public interface MemberMybatis extends CommonSelectMapper, CommonInsertMapper<MemberEntity>, CommonUpdateMapper, CommonDeleteMapper {

    static final MemberTable MEMBER = new MemberTable();

    static final class MemberTable extends SqlTable {
        public final SqlColumn<Long> memberId = column("member_id");
        public final SqlColumn<String> accountName = column("account_name");
        public final SqlColumn<Date> birthday = column("birthday");
        public final SqlColumn<String> contact = column("contact");
        public final SqlColumn<String> email = column("email");
        public final SqlColumn<String> name = column("name");
        public final SqlColumn<String> password = column("password");
        public final SqlColumn<Integer> sex = column("sex");

        public MemberTable() {
            super("member");
        }

        public final Function<Map<String, Object>, MemberEntity> mapper = map -> {
            if (Objects.isNull(map)) {
                return null;
            }
            var t = new MemberEntity();
            Optional.ofNullable(map.get(memberId.name())).ifPresent(v -> t.setMemberId((Long) v));
            Optional.ofNullable(map.get(accountName.name())).ifPresent(v -> t.setAccountName((String) v));
            Optional.ofNullable(map.get(birthday.name())).ifPresent(v -> t.setBirthday(ConvertUtils.toLocalDate((Date) v)));
            Optional.ofNullable(map.get(contact.name())).ifPresent(v -> t.setContact((String) v));
            Optional.ofNullable(map.get(email.name())).ifPresent(v -> t.setEmail((String) v));
            Optional.ofNullable(map.get(password.name())).ifPresent(v -> t.setPassword((String) v));
            Optional.ofNullable(map.get(sex.name())).ifPresent(v -> t.setSex((Integer) v));
            return t;
        };
    }
}

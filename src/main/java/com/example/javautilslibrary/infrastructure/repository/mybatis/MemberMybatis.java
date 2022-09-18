package com.example.javautilslibrary.infrastructure.repository.mybatis;

import com.example.javautilslibrary.infrastructure.entity.member.MemberEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMybatis {

    final String SAVE = "INSERT INTO member(birthday, contact, email, name, password, sex) " +
            "values (#{birthday,jdbcType=DATE}, #{contact, jdbcType=VARCHAR}, #{email, jdbcType=VARCHAR}, #{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{sex, jdbcType=INTEGER})";

    final String FETCH_ALL = "SELECT * FROM member";
    final String FETCH_BY_ID = "SELECT * FROM member WHERE member_id = #{memberId, jdbcType=VARCHAR}";

    @Insert(SAVE)
    @Options(useGeneratedKeys = true, keyProperty = "memberId")
    Integer save(MemberEntity entity);

    @Select(FETCH_BY_ID)
    Optional<MemberEntity> fetchById(Long memberId);

    @Select(FETCH_ALL)
    List<MemberEntity> fetchAll();
}

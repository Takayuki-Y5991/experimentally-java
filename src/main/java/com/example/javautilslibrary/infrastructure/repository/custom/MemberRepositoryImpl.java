package com.example.javautilslibrary.infrastructure.repository.custom;

import com.example.javautilslibrary.common.mapper.MemberMapper;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import com.example.javautilslibrary.infrastructure.entity.member.MemberEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.MemberMybatis;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * {@link MemberRepository}
 */
@Repository
@Slf4j
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private MemberMybatis mybatis;

    /**
     * @param member memberDomain
     * @return
     */
    @Override
    public Member save(MemberEntity member) {
        mybatis.save(member);
        log.info("Member : {}", member);
        return mapper.toDomain(member);
    }

    /**
     * @param memberId memberId
     * @return
     */
    @Override
    public Member fetchById(Long memberId) {
        var result = mybatis.fetchById(memberId);
        return result.isPresent() ? mapper.toDomain(result.get()) : null;
    }

    /**
     * @return
     */
    @Override
    public List<Member> fetchAll() {
        var result = mybatis.fetchAll();
        return CollectionUtils.isNotEmpty(result) ? mapper.toDomainList(result) : Collections.EMPTY_LIST;
    }
}

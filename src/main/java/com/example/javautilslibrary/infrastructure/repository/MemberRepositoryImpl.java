package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.mapper.MemberMapper;
import com.example.javautilslibrary.common.utils.AuthUtils;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import com.example.javautilslibrary.infrastructure.entity.mybatis.MemberEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.MemberEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.MemberEntityDynamicSqlSupport.memberEntity;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static org.mybatis.dynamic.sql.render.RenderingStrategies.MYBATIS3;

;


/**
 * {@link MemberRepository}
 */
@Repository
@Slf4j
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private MemberEntityMapper mybatis;

    @Autowired
    private AuthUtils authUtils;

    /**
     * {@inheritDoc}
     */
    @Override
    public Member save(MemberEntity member) {
        member.setPassword(authUtils.generateDigest(member.getPassword()));
        try {
            mybatis.insertSelective(member);
        } catch (Exception e) {
            throw new ClientException(String.format("failure to create member, already registry account name: %s", member.getAccountName()));
        }
        return mapper.toDomain(member);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Member fetchById(Long memberId) {
        var result = mybatis.selectByPrimaryKey(memberId);
        return result.map(memberEntity -> mapper.toDomain(memberEntity)).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Member> fetchAll() {
        var options = select(memberEntity.allColumns())
                .from(memberEntity)
                .orderBy(memberEntity.memberId)
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectMany(options);
        return CollectionUtils.isNotEmpty(result) ? mapper.toDomainList(result) : Collections.EMPTY_LIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Member fetchByAccountName(String accountName) {
        SelectStatementProvider sql = select(memberEntity.allColumns())
                .from(memberEntity)
                .where(memberEntity.accountName, isEqualTo(accountName))
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectOne(sql);
        return result.map(memberEntity -> mapper.toDomain(memberEntity)).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean deleteById(Long memberId) {
        return mybatis.deleteByPrimaryKey(memberId) > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Member updateMember(MemberEntity member) {
        member.setPassword(authUtils.generateDigest(member.getPassword()));
        try {
            mybatis.updateByPrimaryKeySelective(member);
        } catch (Exception e) {
            throw new ClientException(String.format("failure to create member, already registry account name: %s", member.getAccountName()));
        }
        return fetchById(member.getMemberId());
    }
}

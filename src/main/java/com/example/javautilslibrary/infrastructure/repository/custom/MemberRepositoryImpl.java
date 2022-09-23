package com.example.javautilslibrary.infrastructure.repository.custom;

import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.mapper.MemberMapper;
import com.example.javautilslibrary.common.utils.AuthUtils;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import com.example.javautilslibrary.infrastructure.entity.member.MemberEntity;
import com.example.javautilslibrary.infrastructure.repository.mybatis.MemberMybatis;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.javautilslibrary.infrastructure.repository.mybatis.MemberMybatis.MEMBER;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.render.RenderingStrategies.MYBATIS3;


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

    @Autowired
    private AuthUtils authUtils;

    /**
     * @param member memberDomain
     * @return
     */
    @Override
    public Member save(MemberEntity member) {
        member.setPassword(authUtils.generateDigest(member.getPassword()));
        InsertStatementProvider<MemberEntity> sql = insert(member)
                .into(MEMBER)
                .map(MEMBER.accountName).toProperty("accountName")
                .map(MEMBER.birthday).toProperty("birthday")
                .map(MEMBER.name).toProperty("name")
                .map(MEMBER.contact).toProperty("contact")
                .map(MEMBER.password).toProperty("password")
                .map(MEMBER.sex).toProperty("sex")
                .map(MEMBER.email).toProperty("email")
                .build()
                .render(MYBATIS3);
        try {
            mybatis.insert(sql);
        } catch (Exception e) {
            throw new ClientException(String.format("failure to create member, already registry account name: %s", member.getAccountName()));
        }
        return mapper.toDomain(member);
    }

    /**
     * @param memberId memberId
     * @return
     */
    @Override
    public Member fetchById(Long memberId) {
        SelectStatementProvider sql = select(MEMBER.allColumns())
                .from(MEMBER)
                .where(MEMBER.memberId, isEqualTo(memberId))
                .build()
                .render(MYBATIS3);
        var result = Optional.ofNullable(mybatis.selectOne(sql, MEMBER.mapper));
        return result.isPresent() ? mapper.toDomain(result.get()) : null;
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Member> fetchAll() {
        SelectStatementProvider sql = select(MEMBER.allColumns())
                .from(MEMBER)
                .build()
                .render(MYBATIS3);
        var result = mybatis.selectMany(sql, MEMBER.mapper);
        return CollectionUtils.isNotEmpty(result) ? mapper.toDomainList(result) : Collections.EMPTY_LIST;
    }

    /**
     * @param accountName
     * @return
     */
    @Override
    public Member fetchByAccountName(String accountName) {
        SelectStatementProvider sql = select(MEMBER.allColumns())
                .from(MEMBER)
                .where(MEMBER.accountName, isEqualTo(accountName))
                .build()
                .render(MYBATIS3);
        var result = Optional.ofNullable(mybatis.selectOne(sql, MEMBER.mapper));
        return result.map(memberEntity -> mapper.toDomain(memberEntity)).orElse(null);
    }

    /**
     * @param memberId
     * @return
     */
    @Override
    public Boolean deleteById(Long memberId) {
        DeleteStatementProvider sql = deleteFrom(MEMBER)
                .where(MEMBER.memberId, isEqualTo(memberId))
                .build()
                .render(MYBATIS3);
        return mybatis.delete(sql) > 0;
    }

    /**
     * @param member
     * @return
     */
    @Override
    public Member updateMember(MemberEntity member) {
        member.setPassword(authUtils.generateDigest(member.getPassword()));
        UpdateStatementProvider sql = update(MEMBER)
                .set(MEMBER.name).equalToWhenPresent(member.getName())
                .set(MEMBER.password).equalToWhenPresent(member.getPassword())
                .set(MEMBER.contact).equalToWhenPresent(member.getContact())
                .set(MEMBER.email).equalToWhenPresent(member.getEmail())
                .where(MEMBER.memberId, isEqualTo(member.getMemberId()))
                .and(MEMBER.accountName, isEqualTo(member.getAccountName()))
                .build()
                .render(MYBATIS3);
        mybatis.update(sql);
        return fetchById(member.getMemberId());
    }
}

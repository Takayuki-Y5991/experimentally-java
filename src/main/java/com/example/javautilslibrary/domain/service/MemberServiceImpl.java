package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.converter.MemberResponseConverter;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.exception.ResourceNotFoundException;
import com.example.javautilslibrary.common.mapper.MemberMapper;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.openapi.example.model.MemberListResponse;
import org.openapi.example.model.MemberRequest;
import org.openapi.example.model.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Objects;


@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private MemberRepository memberRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void createMember(MemberRequest request) {
        var domain = mapper.toDomain(request);
        var result = memberRepository.save(mapper.toEntity(domain));
        if (Objects.isNull(result)) {
            throw new ClientException("failure to create Member");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteMember(Long memberId) {
        var result = memberRepository.deleteById(memberId);
        if (Objects.isNull(result)) {
            throw new ClientException("failure to delete Member");
        }
    }

    /**
     * @param request
     */
    @Override
    @Transactional
    public void updateMember(MemberRequest request) {
        var domain = mapper.toDomain(request);
        var result = memberRepository.updateMember(mapper.toEntity(domain));
        if (Objects.isNull(result)) {
            throw new ClientException("failure to update Member");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public MemberResponse findById(Long memberId) {
        var result = memberRepository.fetchById(memberId);
        if (Objects.isNull(result)) {
            throw new ResourceNotFoundException(String.format("Member Id: [%s] not found", memberId));
        }
        return mapper.toMemberResponse(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public MemberListResponse findAll(Integer count) {
        var result = memberRepository.fetchAll(count);
        if (CollectionUtils.isEmpty(result)) {
            return MemberResponseConverter.buildMemberResponse(Collections.EMPTY_LIST);
        }
        var response = mapper.toMemberList(result);
        return MemberResponseConverter.buildMemberResponse(response);
    }
}

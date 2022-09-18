package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.application.response.MemberResponse;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.mapper.MemberMapper;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
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
    public MemberResponse findById(Long memberId) {
        var result = memberRepository.fetchById(memberId);
        if (Objects.isNull(result)) {
            return null;
        }
        return mapper.toMemberResponse(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MemberResponse> findAll() {
        var result = memberRepository.fetchAll();
        if (CollectionUtils.isEmpty(result)) {
            return Collections.EMPTY_LIST;
        }
        return mapper.toMemberResponseList(result);
    }
}

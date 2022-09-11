package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.infrastructure.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createMember(MemberRequest request) {
        var domain = Member.build(
                request.getMemberId(),
                request.getName(),
                request.getSex(),
                request.getEmail(),
                request.getPassword(),
                request.getBirthday(),
                request.getContact()
        );
        var result = memberRepository.save(Member.buildEntity(domain));
        if (Objects.isNull(result)) {
            throw new ClientException("failure to create Member");
        }
    }
}

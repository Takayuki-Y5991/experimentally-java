package com.example.javautilslibrary.application.controller;


import com.example.javautilslibrary.application.converter.CommonResponseConverter;
import com.example.javautilslibrary.common.config.anotation.Authorize;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.openapi.example.api.MemberApi;
import org.openapi.example.api.MembersApi;
import org.openapi.example.model.CreatedResponse;
import org.openapi.example.model.DeletedResponse;
import org.openapi.example.model.MemberListResponse;
import org.openapi.example.model.MemberRequest;
import org.openapi.example.model.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Slf4j
@RestController
public class MemberController implements MemberApi, MembersApi {

    @Autowired
    private MemberService service;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return MemberApi.super.getRequest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonAuthorize
    public ResponseEntity<CreatedResponse> createMember(MemberRequest memberRequest) {
        service.createMember(memberRequest);
        return ResponseEntity.ok(CommonResponseConverter.buildCreated("Member"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<DeletedResponse> deleteMember(Long memberId) {
        service.deleteMember(memberId);
        return ResponseEntity.ok(CommonResponseConverter.buildDeleted("Member"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<MemberResponse> getMemberInformation(Long memberId) {
        var result = service.findById(memberId);
        return ResponseEntity.ok(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Authorize
    public ResponseEntity<MemberListResponse> getAllMemberInformation(Integer count) {
        var result = service.findAll(count);
        return ResponseEntity.ok(result);
    }
}

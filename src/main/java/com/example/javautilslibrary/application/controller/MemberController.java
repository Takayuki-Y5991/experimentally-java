package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.application.response.CreatedResponse;
import com.example.javautilslibrary.application.response.NoContentResponse;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
public class MemberController implements BaseController {

    @Autowired
    private MemberService service;

    @NonAuthorize
    @PostMapping(value = "member")
    public ResponseEntity<CreatedResponse> createMember(@RequestBody MemberRequest request) {
        service.createMember(request);
        return ResponseEntity.ok(CreatedResponse.build("Member"));
    }

    @NonAuthorize
    @GetMapping(value = "member")
    public ResponseEntity<Object> getAllMemberInformation() {
        var result = service.findAll();
        return ResponseEntity.ok(!CollectionUtils.isEmpty(result) ?
                result : NoContentResponse.build("Members"));
    }

    @NonAuthorize
    @GetMapping(value = "member/{memberId}")
    public ResponseEntity<Object> getMemberInformation(@PathVariable(name = "memberId") Long memberId) throws JsonProcessingException {
        var result = service.findById(memberId);
        mapper.writeValueAsString(result);
        return ResponseEntity.ok(Objects.nonNull(result) ?
                result : NoContentResponse.build(String.format("Member id: %s", memberId)));
    }


}

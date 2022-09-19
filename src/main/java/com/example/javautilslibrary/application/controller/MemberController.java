package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.application.response.CreatedResponse;
import com.example.javautilslibrary.application.response.DeletedResponse;
import com.example.javautilslibrary.application.response.NoContentResponse;
import com.example.javautilslibrary.common.config.anotation.Authorize;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.MemberService;
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

    @Authorize
    @DeleteMapping(value = "member/{memberId}")
    public ResponseEntity<DeletedResponse> deleteMember(@PathVariable(name = "memberId") Long memberId) {
        service.deleteMember(memberId);
        return ResponseEntity.ok(DeletedResponse.build("Member"));
    }

    @Authorize
    @GetMapping(value = "member")
    public ResponseEntity<Object> getAllMemberInformation() {
        var result = service.findAll();
        return ResponseEntity.ok(!CollectionUtils.isEmpty(result) ?
                result : NoContentResponse.build("Members"));
    }

    @Authorize
    @GetMapping(value = "member/{memberId}")
    public ResponseEntity<Object> getMemberInformation(@PathVariable(name = "memberId") Long memberId) {
        var result = service.findById(memberId);
        return ResponseEntity.ok(Objects.nonNull(result) ?
                result : NoContentResponse.build(String.format("Member id: %s", memberId)));
    }

}

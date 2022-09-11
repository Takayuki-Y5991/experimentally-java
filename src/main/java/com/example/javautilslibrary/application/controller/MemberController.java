package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.application.response.CreatedResponse;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController implements BaseController {

    @Autowired
    private MemberService service;

    @NonAuthorize
    @PostMapping(path = "member", consumes = "application/json")
    public ResponseEntity<CreatedResponse> createMember(@RequestBody MemberRequest request) {
        service.createMember(request);
        return ResponseEntity.ok(CreatedResponse.build("Member"));
    }

    ;

}

package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.request.MemberRequest;

public interface MemberService {

    /**
     * create member
     *
     * @param request member
     */
    public void createMember(MemberRequest request);

}

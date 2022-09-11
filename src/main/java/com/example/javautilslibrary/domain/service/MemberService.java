package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.common.exception.ClientException;
import com.example.javautilslibrary.common.exception.DomainException;

public interface MemberService {

    /**
     * create member
     *
     * @param request member
     */
    public void createMember(MemberRequest request) throws DomainException, ClientException;

}

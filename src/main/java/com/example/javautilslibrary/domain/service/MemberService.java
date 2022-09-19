package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.application.response.MemberResponse;

import java.util.List;

public interface MemberService {

    /**
     * create member
     *
     * @param request member
     */
    void createMember(MemberRequest request);

    /**
     * delete member by member id
     *
     * @param memberId
     */
    void deleteMember(Long memberId);

    /**
     * update member by member id and account name
     *
     * @param request
     */
    void updateMember(MemberRequest request);

    /**
     * fetch member by member_id
     *
     * @param memberId memberId
     * @return member Information
     */
    MemberResponse findById(Long memberId);

    /**
     * fetch all members
     */
    List<MemberResponse> findAll();
}

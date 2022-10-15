package com.example.javautilslibrary.domain.service;


import org.openapi.example.model.MemberListResponse;
import org.openapi.example.model.MemberRequest;
import org.openapi.example.model.MemberResponse;

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
     *
     * @param count number of members
     */
    MemberListResponse findAll(Integer count);
}

package com.example.javautilslibrary.application.converter;

import org.openapi.example.model.Member;
import org.openapi.example.model.MemberListResponse;

import java.util.List;

/**
 * Member Response Converter
 */
public class MemberResponseConverter {

    public static MemberListResponse buildMemberResponse(List<Member> source) {
        var response = new MemberListResponse();
        response.setMembers(source);
        response.setCount(source.size());
        return response;
    }
}

package com.example.javautilslibrary.common.mapper;

import com.example.javautilslibrary.application.request.MemberRequest;
import com.example.javautilslibrary.application.response.MemberResponse;
import com.example.javautilslibrary.common.config.ConfigMapper;
import com.example.javautilslibrary.common.mapper.common.EnumConverter;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.infrastructure.entity.member.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = EnumConverter.class, config = ConfigMapper.class)
public interface MemberMapper {

    @Mapping(target = "accountName", qualifiedByName = {"EnumConverter", "fromAccountName"})
    @Mapping(target = "sex", qualifiedByName = {"EnumConverter", "fromSex"})
    @Mapping(target = "birthday", qualifiedByName = {"EnumConverter", "fromBirthday"})
    @Mapping(target = "email", qualifiedByName = {"EnumConverter", "fromEmail"})
    @Mapping(target = "contact", qualifiedByName = {"EnumConverter", "fromContact"})
    MemberEntity toEntity(Member member);

    @Mapping(target = "accountName", qualifiedByName = {"EnumConverter", "toAccountName"})
    @Mapping(target = "sex", qualifiedByName = {"EnumConverter", "toSex"})
    @Mapping(target = "birthday", qualifiedByName = {"EnumConverter", "toBirthday"})
    @Mapping(target = "email", qualifiedByName = {"EnumConverter", "toEmail"})
    @Mapping(target = "contact", qualifiedByName = {"EnumConverter", "toContact"})
    Member toDomain(MemberEntity member);

    @Mapping(target = "accountName", qualifiedByName = {"EnumConverter", "toAccountName"})
    @Mapping(target = "sex", qualifiedByName = {"EnumConverter", "toSex"})
    @Mapping(target = "birthday", qualifiedByName = {"EnumConverter", "toBirthday"})
    @Mapping(target = "email", qualifiedByName = {"EnumConverter", "toEmail"})
    @Mapping(target = "contact", qualifiedByName = {"EnumConverter", "toContact"})
    Member toDomain(MemberRequest request);

    @Mapping(target = "accountName", qualifiedByName = {"EnumConverter", "fromAccountName"})
    @Mapping(target = "sex", qualifiedByName = {"EnumConverter", "fromSex"})
    @Mapping(target = "birthday", qualifiedByName = {"EnumConverter", "fromBirthday"})
    @Mapping(target = "email", qualifiedByName = {"EnumConverter", "fromEmail"})
    @Mapping(target = "contact", qualifiedByName = {"EnumConverter", "fromContact"})
    MemberResponse toMemberResponse(Member member);

    default List<Member> toDomainList(List<MemberEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    default List<MemberResponse> toMemberResponseList(List<Member> domains) {
        return domains.stream()
                .map(this::toMemberResponse)
                .collect(Collectors.toList());
    }


}

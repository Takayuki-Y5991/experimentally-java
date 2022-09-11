package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import com.example.javautilslibrary.domain.object.value.BirthDay;
import com.example.javautilslibrary.domain.object.value.Contact;
import com.example.javautilslibrary.domain.object.value.Email;
import com.example.javautilslibrary.domain.object.value.Sex;
import com.example.javautilslibrary.infrastructure.repository.entity.member.MemberEntity;
import lombok.*;
import org.modelmapper.PropertyMap;

import java.time.LocalDate;

/**
 * Member entity
 */
@Data
@Builder(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Member extends Domain<Member> {
    private Long memberId;
    private String name;
    private Sex sex;
    private Email email;
    private String password;
    private BirthDay birthDay;
    private Contact contact;

    public static Member build(Long memberId, String name, int sex, String email, String password, LocalDate birthDay, String contact) {
        return Member.builder()
                .memberId(memberId)
                .name(name)
                .sex(Sex.isSex(sex))
                .email(Email.build(email))
                .password(password)
                .birthDay(BirthDay.build(birthDay))
                .contact(Contact.build(contact))
                .build();
    }

    public static Member buildFromEntity(MemberEntity entity) {
        var propertyMap = new PropertyMap<MemberEntity, Member>() {
            @Override
            protected void configure() {
                map().setBirthDay(BirthDay.build(source.getBirthday()));
                map().setSex(Sex.isSex(source.getSex()));
                map().setContact(Contact.build(source.getContact()));
                map().setEmail(Email.build(source.getEmail()));
            }
        };
        mapper.addMappings(propertyMap);
        return mapper.map(entity, Member.class);
    }

    public static MemberEntity buildEntity(Member domain) {
        var propertyMap = new PropertyMap<Member, MemberEntity>() {
            @Override
            protected void configure() {
                map().setBirthday(source.getBirthDay().getDate());
                map().setSex(source.getSex().getSex());
                map().setContact(source.getContact().getContact());
                map().setEmail(source.getEmail().getEmail());
            }
        };
        mapper.addMappings(propertyMap);
        return mapper.map(domain, MemberEntity.class);
    }
}

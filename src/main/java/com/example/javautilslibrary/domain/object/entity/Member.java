package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import com.example.javautilslibrary.domain.object.value.BirthDay;
import com.example.javautilslibrary.domain.object.value.Contact;
import com.example.javautilslibrary.domain.object.value.Email;
import com.example.javautilslibrary.domain.object.value.Sex;
import lombok.*;

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
    private BirthDay birthday;
    private Contact contact;

    public static Member build(Long memberId, String name, int sex, String email, String password, LocalDate birthDay, String contact) {
        return Member.builder()
                .memberId(memberId)
                .name(name)
                .sex(Sex.isSex(sex))
                .email(Email.build(email))
                .password(password)
                .birthday(BirthDay.build(birthDay))
                .contact(Contact.build(contact))
                .build();
    }
}

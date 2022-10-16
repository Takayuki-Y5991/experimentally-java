package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import com.example.javautilslibrary.domain.object.value.AccountName;
import com.example.javautilslibrary.domain.object.value.BirthDay;
import com.example.javautilslibrary.domain.object.value.Contact;
import com.example.javautilslibrary.domain.object.value.Email;
import com.example.javautilslibrary.domain.object.value.Sex;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private AccountName accountName;
    private Sex sex;
    private Email email;
    private String password;
    private BirthDay birthday;
    private Contact contact;
}

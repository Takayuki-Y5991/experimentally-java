package com.example.javautilslibrary.infrastructure.entity.mybatis;

import java.time.LocalDate;
import javax.annotation.Generated;

public class MemberEntity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180034131+09:00", comments="Source field: member.member_id")
    private Long memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180056706+09:00", comments="Source field: member.account_name")
    private String accountName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180075187+09:00", comments="Source field: member.birthday")
    private LocalDate birthday;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180094061+09:00", comments="Source field: member.contact")
    private String contact;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180111549+09:00", comments="Source field: member.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18012734+09:00", comments="Source field: member.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180144547+09:00", comments="Source field: member.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180297953+09:00", comments="Source field: member.sex")
    private Integer sex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180044086+09:00", comments="Source field: member.member_id")
    public Long getMemberId() {
        return memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18005161+09:00", comments="Source field: member.member_id")
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180063088+09:00", comments="Source field: member.account_name")
    public String getAccountName() {
        return accountName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180069771+09:00", comments="Source field: member.account_name")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180083397+09:00", comments="Source field: member.birthday")
    public LocalDate getBirthday() {
        return birthday;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180089351+09:00", comments="Source field: member.birthday")
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180099999+09:00", comments="Source field: member.contact")
    public String getContact() {
        return contact;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180106316+09:00", comments="Source field: member.contact")
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180116508+09:00", comments="Source field: member.email")
    public String getEmail() {
        return email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180123249+09:00", comments="Source field: member.email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180132943+09:00", comments="Source field: member.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180139711+09:00", comments="Source field: member.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180150938+09:00", comments="Source field: member.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.18015741+09:00", comments="Source field: member.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180334451+09:00", comments="Source field: member.sex")
    public Integer getSex() {
        return sex;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.180347132+09:00", comments="Source field: member.sex")
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
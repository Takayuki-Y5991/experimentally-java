package com.example.javautilslibrary.common.mapper.common;

import com.example.javautilslibrary.domain.object.value.*;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Named("EnumConverter")
public class EnumConverter {

    @Named("toAccountName")
    public AccountName valueToAccountNameConverter(String target) {
        return AccountName.build(target);
    }

    @Named("fromAccountName")
    public String accountNameToValueConverter(AccountName target) {
        return target.getAccountName();
    }

    @Named("toSex")
    public Sex valueToSexConverter(Integer target) {
        return Sex.isSex(target);
    }

    @Named("fromSex")
    public Integer sexToValueConverter(Sex target) {
        return target.getSex();
    }

    @Named("toEmail")
    public Email valueToEmailConverter(String target) {
        return Email.build(target);
    }

    @Named("fromEmail")
    public String emailToValueConverter(Email target) {
        return target.getEmail();
    }

    @Named("toBirthday")
    public BirthDay valueToBirthdayConverter(LocalDate target) {
        return BirthDay.build(target);
    }

    @Named("fromBirthday")
    public LocalDate birthdayToValueConverter(BirthDay target) {
        return target.getBirthday();
    }

    @Named("toContact")
    public Contact valueToContactConverter(String target) {
        return Contact.build(target);
    }

    @Named("fromContact")
    public String contactToValueConverter(Contact target) {
        return target.getContact();
    }
    
}

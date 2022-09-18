package com.example.javautilslibrary.common.mapper.common;

import com.example.javautilslibrary.domain.object.value.BirthDay;
import com.example.javautilslibrary.domain.object.value.Contact;
import com.example.javautilslibrary.domain.object.value.Email;
import com.example.javautilslibrary.domain.object.value.Sex;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Named("EnumConverter")
public class EnumConverter {
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

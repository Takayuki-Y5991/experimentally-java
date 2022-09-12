package com.example.javautilslibrary.domain.object.value;

import com.example.javautilslibrary.common.exception.DomainException;
import com.example.javautilslibrary.common.utils.Constance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class Contact {

    private String contact;

    public static Contact build(String contact) {
        return Contact.builder()
                .contact(isValidContactFormat(contact))
                .build();
    }

    private static String isValidContactFormat(String contact) {
        if (StringUtils.isBlank(contact)) {
            return contact;
        }
        if (!contact.matches(Constance.CONTACT_FORMAT)) {
            throw new DomainException("Contact is invalid format, check your contact");
        }
        return contact;
    }
}

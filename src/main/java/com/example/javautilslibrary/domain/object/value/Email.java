package com.example.javautilslibrary.domain.object.value;

import com.example.javautilslibrary.common.exception.DomainException;
import com.example.javautilslibrary.common.utils.Constance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Email Value Object
 */
@Data
@Builder(access = AccessLevel.PRIVATE)
public class Email {

    private String email;

    public static Email build(String email) {
        return Email.builder()
                .email(isValidFormat(isValidFormat(email)))
                .build();
    }

    /**
     * Email Format Validation
     *
     * @param email email
     * @return
     * @throws DomainException
     */
    private static String isValidFormat(String email) {
        if (StringUtils.isBlank(email)) {
            return email;
        }
        if (!email.matches(Constance.MAIL_FORMAT)) {
            throw new DomainException("Email is invalid format, check your email");
        }
        return email;
    }
}

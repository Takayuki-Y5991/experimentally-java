package com.example.javautilslibrary.domain.object.value;

import com.example.javautilslibrary.common.exception.DomainException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

/**
 * BirthDay value object
 */
@Data
@Builder(access = AccessLevel.PRIVATE)
public class BirthDay {

    private LocalDate birthday;

    public static BirthDay build(LocalDate date) {
        return BirthDay.builder()
                .birthday(isValidBirthDay(date))
                .build();
    }

    /**
     * BirthDay valid
     *
     * @param date
     * @return
     * @throws DomainException
     */
    private static LocalDate isValidBirthDay(LocalDate date) {
        if (Objects.isNull(date)) {
            throw new DomainException("Birthday must not be null");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new DomainException("Birthday is invalid, your input future date");
        }
        return date;
    }
}

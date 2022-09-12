package com.example.javautilslibrary.domain.object.value;

import com.example.javautilslibrary.common.exception.DomainException;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * Sex Enum
 */
@Getter
public enum Sex {
    MALE(1),
    FEMALE(2);

    private Integer sex;

    private Sex(Integer sex) {
    }

    public static Sex isSex(Integer sex) {
        if (Objects.isNull(sex)) {
            throw new DomainException("Sex must not be null");
        }
        for (Sex e : Sex.values()) {
            System.out.println(e.getSex());
        }

        var value = Arrays.stream(Sex.values()).filter(e -> e.getSex() == sex).findAny();
        if (!value.isPresent()) {
            throw new DomainException("Sex is valid, you check value");
        } else {
            return value.get();
        }
    }
}

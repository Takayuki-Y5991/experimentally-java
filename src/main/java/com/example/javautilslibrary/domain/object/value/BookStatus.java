package com.example.javautilslibrary.domain.object.value;


import lombok.Getter;

import java.util.Arrays;

/**
 * Book status Enum
 */
@Getter
public enum BookStatus {
    BE(0),
    RENTAL(1),
    RESERVING(2);

    private int status;

    private BookStatus(int i) {
    }

    public static BookStatus isStatus(int status) {
        
        var value = Arrays.stream(BookStatus.values()).filter(e -> e.getStatus() == status).findAny();
        if (value.isPresent()) {
            throw new IllegalStateException("Book status is valid, you check value");
        } else {
            return value.get();
        }
    }
}

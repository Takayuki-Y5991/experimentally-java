package com.example.javautilslibrary.common.enums;

import lombok.Getter;

/**
 * Mode Enum, use Service layer (isn't Value Object)
 */
@Getter
public enum Mode {
    NEW(1),
    CHANGE(2);

    private int mode;

    private Mode(int i) {
    }
}

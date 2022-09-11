package com.example.javautilslibrary.common.exception;

import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiErrorResponse {

    private int status;
    private String message;

    public static ApiErrorResponse build(int status, String message) {
        return ApiErrorResponse.builder()
                .status(status)
                .message(message)
                .build();
    }
}

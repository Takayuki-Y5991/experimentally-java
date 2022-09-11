package com.example.javautilslibrary.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class CreatedResponse {
    private final Integer status = 201;
    private String message;

    public static CreatedResponse build(String target) {
        return CreatedResponse.builder()
                .message(target.concat(" Created"))
                .build();
    }
}

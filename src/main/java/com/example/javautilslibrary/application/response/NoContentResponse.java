package com.example.javautilslibrary.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class NoContentResponse {
    private final Integer status = 204;
    private String message;

    public static NoContentResponse build(String target) {
        return NoContentResponse.builder()
                .message(target.concat(" No Content"))
                .build();
    }
}

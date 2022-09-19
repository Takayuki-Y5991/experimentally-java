package com.example.javautilslibrary.application.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class DeletedResponse {
    private final Integer status = 204;
    private String message;

    public static DeletedResponse build(String target) {
        return DeletedResponse.builder()
                .message(target.concat(" Deleted"))
                .build();
    }
}

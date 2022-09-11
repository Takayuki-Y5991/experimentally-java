package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class Token extends Domain<Token> {

    private String token;

    public static Token build(String token) {
        return Token.builder()
                .token(token)
                .build();
    }
}

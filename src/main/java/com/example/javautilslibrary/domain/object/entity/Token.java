package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Token extends Domain<Token> {
    private String token;
}

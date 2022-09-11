package com.example.javautilslibrary.application.response;

import com.example.javautilslibrary.domain.object.entity.Token;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

/**
 * token publish
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenResponse {

    private String token;

    public static TokenResponse converter(Token token) {
        var mapper = new ModelMapper();
        return mapper.map(token, TokenResponse.class);
    }
}

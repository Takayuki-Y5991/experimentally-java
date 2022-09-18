package com.example.javautilslibrary.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * token publish
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    /**
     * Token
     */
    private String token;
}

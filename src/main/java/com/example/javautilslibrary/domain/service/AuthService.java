package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.request.AuthRequest;
import com.example.javautilslibrary.application.response.TokenResponse;

/**
 * Authorization service interface
 */
public interface AuthService {
    /**
     * Create token
     *
     * @param value value in token subject
     * @return token
     */
    public TokenResponse getToken(AuthRequest value);

    /**
     * Confirm token
     *
     * @return token
     */
    public TokenResponse refreshToken(String token);
}

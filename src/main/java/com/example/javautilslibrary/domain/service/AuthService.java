package com.example.javautilslibrary.domain.service;


import org.openapi.example.model.AuthRequest;
import org.openapi.example.model.TokenResponse;

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

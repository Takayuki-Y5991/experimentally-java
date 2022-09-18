package com.example.javautilslibrary.domain.service;

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
    public TokenResponse getToken(String value);

    /**
     * Confirm token
     *
     * @return boolean
     */
    public boolean confirmTokenKey(String value);
}

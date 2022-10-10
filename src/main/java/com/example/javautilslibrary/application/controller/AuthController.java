package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.openapi.example.api.AuthApi;
import org.openapi.example.model.AuthRequest;
import org.openapi.example.model.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController implements AuthApi {

    @Autowired
    private AuthService service;

    /**
     * {@inheritDoc}
     */
    @Override
    @NonAuthorize
    public ResponseEntity<TokenResponse> getToken(@RequestBody AuthRequest request) {
        var response = service.getToken(request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonAuthorize
    public ResponseEntity<TokenResponse> refreshTokenToken(String authentication) {
        var response = service.refreshToken(authentication);
        return ResponseEntity.ok(response);
    }
}

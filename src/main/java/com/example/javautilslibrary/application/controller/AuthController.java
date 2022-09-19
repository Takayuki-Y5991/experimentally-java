package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.request.AuthRequest;
import com.example.javautilslibrary.application.response.TokenResponse;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements BaseController {

    @Autowired
    private AuthService service;

    @NonAuthorize
    @PostMapping("auth")
    public ResponseEntity<TokenResponse> getToken(@RequestBody AuthRequest request) {
        var response = service.getToken(request);
        return ResponseEntity.ok(response);
    }

    @NonAuthorize
    @PostMapping("auth/refresh")
    public ResponseEntity<TokenResponse> refreshToken(@NonNull @RequestParam("authKey") String key) {
        var response = service.refreshToken(key);
        return ResponseEntity.ok(response);
    }
}

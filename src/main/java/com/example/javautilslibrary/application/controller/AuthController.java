package com.example.javautilslibrary.application.controller;

import com.example.javautilslibrary.application.response.TokenResponse;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements BaseController {

    @Autowired
    private AuthService service;

    @NonAuthorize
    @GetMapping("auth")
    public ResponseEntity<TokenResponse> getToken(@NonNull @RequestParam("authKey") String value) {
        var response = TokenResponse.converter(service.getToken(value));
        return ResponseEntity.ok(response);
    }

    @NonAuthorize
    @GetMapping("auth/confirm")
    public ResponseEntity<Boolean> confirmTokenKey(@NonNull @RequestParam("authValue") String value) {
        boolean result = service.confirmTokenKey(value);
        return ResponseEntity.ok(result);
    }
}

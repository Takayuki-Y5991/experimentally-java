package com.example.javautilslibrary.common.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Password encoder, plain password to digest password
     *
     * @param password
     * @return
     */
    public String generateDigest(String password) {
        return passwordEncoder().encode(password);
    }

    /**
     * Password compare to verify
     *
     * @param request password from request
     * @param store   password from database
     * @return verify result OK: true , No:  false
     */
    public boolean verifyPassword(String request, String store) {
        return passwordEncoder().matches(request, store);
    }
}

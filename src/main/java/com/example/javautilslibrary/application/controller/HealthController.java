package com.example.javautilslibrary.application.controller;


import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements BaseController {

    @NonAuthorize
    @GetMapping("health")
    public ResponseEntity<Void> checkHealth() {
        return ResponseEntity.ok().build();
    }
}

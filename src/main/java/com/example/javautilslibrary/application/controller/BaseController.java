package com.example.javautilslibrary.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/v1", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface BaseController {
    public ObjectMapper mapper = new ObjectMapper();
}

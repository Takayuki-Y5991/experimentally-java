package com.example.javautilslibrary.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/v1", produces = "application/json")
public interface BaseController {
    public ObjectMapper mapper = new ObjectMapper();
}

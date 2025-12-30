package com.example.crud_operation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

    @GetMapping("/")
    public String home() {
        return "experiment with java part one";
    }
}

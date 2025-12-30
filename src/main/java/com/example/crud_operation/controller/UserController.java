package com.example.crud_operation.controller;

import com.example.crud_operation.model.User;
import com.example.crud_operation.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Exposes REST APIs
@RestController

// Base path for user APIs
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE API
    // POST /api/users
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {

        // No try-catch needed
        // Any exception thrown here will be handled by GlobalExceptionHandler
        return userService.createUser(user);
    }

    // UPDATE API (by email)
    // PUT /api/users/email/{email}
    @PutMapping("/email/{email}")
    public User updateUserByEmail(
            @PathVariable String email,
            @Valid @RequestBody User user) {

        // Clean and simple
        // Custom exceptions will be translated to proper HTTP responses
        return userService.updateUserByEmail(email, user);
    }

    @DeleteMapping("/email/{email}")
    public void deleteUserByEmail(@PathVariable String email) {

        userService.deleteUserByEmail(email);
    }
}

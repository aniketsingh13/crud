package com.example.crud_operation.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 404 - User not found
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(
            UserNotFoundException ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now());
        error.put("status", 404);
        error.put("error", "Not Found");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 409 - Duplicate email
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateKey(
            DuplicateKeyException ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now());
        error.put("status", 409);
        error.put("error", "Conflict");
        error.put("message", "Email already exists. Please use a different email.");

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // 400 - Validation errors (@NotBlank, @Email, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now());
        error.put("status", 400);
        error.put("error", "Bad Request");

        // Generic message (clean)
        error.put("message", "Invalid request data. Please check the input fields.");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 500 - Real server errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(
            Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now());
        error.put("status", 500);
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

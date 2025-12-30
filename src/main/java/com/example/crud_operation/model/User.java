package com.example.crud_operation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Document(collection = "users")
public class User {

    @Id
    public String id;   // maps to _id in MongoDB

    @NotBlank
    public String name;

    @Email
    @Indexed(unique = true)   
    @NotBlank
    public String email;

    public String message;

    @NotNull
    public Boolean status;   // true = active, false = inactive

    // Automatically set when document is created
    @CreatedDate
    public Instant createdAt;

    // Automatically updated when document is modified
    @LastModifiedDate
    public Instant updatedAt;

    // parameterized constructor
    public User(String name, String email, String message, Boolean status) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.status = status;
    }
}

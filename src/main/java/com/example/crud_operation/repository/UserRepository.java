package com.example.crud_operation.repository;
import java.util.Optional;

import com.example.crud_operation.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Marks this interface as a MongoDB repository
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // No code needed here for basic CRUD
    // save(), findAll(), findById(), deleteById() are auto-provided
        Optional<User> findByEmail(String email);
        void deleteByEmail(String email);
} 

package com.example.crud_operation.service;
import java.util.Optional;

import com.example.crud_operation.exception.UserNotFoundException;
import com.example.crud_operation.model.User;
import com.example.crud_operation.repository.UserRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Business layer method
    public User createUser(@NotNull @Valid User user) {

        // No persistence logic here
        // No try-catch
        // Just delegation

        return userRepository.save(user);
    }

        public User updateUserByEmail(String email, User updatedUser) {

        Optional<User> existingUserOpt = userRepository.findByEmail(email);

        if (existingUserOpt.isEmpty()) {
            throw new RuntimeException("User not found with email: " + email);
        }

        User existingUser = existingUserOpt.get();

        // Update allowed fields
        existingUser.name = updatedUser.name;
        existingUser.message = updatedUser.message;
        existingUser.status = updatedUser.status;

        // email usually should NOT be updated if it’s the identifier
        // existingUser.email = updatedUser.email; ❌

        return userRepository.save(existingUser);
    }
        public void deleteUserByEmail(String email) {

        // Check if user exists
        userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with email: " + email));

        // Delete user
        userRepository.deleteByEmail(email);
    }
}

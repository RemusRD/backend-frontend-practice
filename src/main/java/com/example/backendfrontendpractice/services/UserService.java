package com.example.backendfrontendpractice.services;

import com.example.backendfrontendpractice.models.User;
import com.example.backendfrontendpractice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User updateUserInformation(String username, String newUserName, String newPassword, int newAge) {
        final User user = findByUsername(username);
        user.setUsername(newUserName);
        user.setPassword(newPassword);
        user.setAge(newAge);
        return userRepository.save(user);
    }
}

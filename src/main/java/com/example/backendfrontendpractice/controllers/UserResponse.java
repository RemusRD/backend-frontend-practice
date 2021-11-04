package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private String username;
    private int age;

    public static UserResponse fromUser(User user) {
        if(user == null) {
            return null;
        }
        return new UserResponse(user.getUsername(), user.getAge());
    }
}

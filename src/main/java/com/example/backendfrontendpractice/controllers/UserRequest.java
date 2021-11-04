package com.example.backendfrontendpractice.controllers;


import com.example.backendfrontendpractice.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequest {
    private String username;
    private int age;
    private String password;
}

package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.models.User;
import com.example.backendfrontendpractice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Validated
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public UserResponse getByUsername(Principal principal) {
        final var user = userService.findByUsername(principal.getName());
        return UserResponse.fromUser(user);
    }

}

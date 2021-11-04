package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //update user
    @PutMapping("/me")
    public UserResponse updateUserInformation(Principal principal, @RequestBody UserRequest request) {
        final var user = userService.updateUserInformation(principal.getName(), request.getUsername(), request.getPassword(), request.getAge());
        return UserResponse.fromUser(user);
    }

}

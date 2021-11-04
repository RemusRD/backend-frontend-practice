package com.example.backendfrontendpractice;

import com.example.backendfrontendpractice.models.User;
import com.example.backendfrontendpractice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendFrontendPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendFrontendPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner createUser(UserRepository userRepository) {
        //This should not be done here, but the authentication is currently on memory.
        return args -> {
            userRepository.save(
                    User.builder()
                            .username("username").age(19)
                            .password("password")
                            .build());
        };
    }

}

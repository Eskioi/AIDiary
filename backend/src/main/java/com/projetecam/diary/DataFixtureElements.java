package com.projetecam.diary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.projetecam.diary.core.RegisterRequestDTO;
import com.projetecam.diary.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataFixtureElements implements CommandLineRunner {
    private final UserService userService;

    @Override
    public void run(String... args) {
        userService.register(new RegisterRequestDTO("test-user-1", "test-user-1@floodaid.jku.at", "SuperSecretPassword!"));
        userService.register(new RegisterRequestDTO("test-user-2", "test-user-2@floodaid.jku.at", "SuperSecretPassword!"));
        userService.register(new RegisterRequestDTO("test-user-3", "test-user-3@floodaid.jku.at", "SuperSecretPassword!"));
    }
}
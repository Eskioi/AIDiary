package com.projetecam.diary;

import com.projetecam.diary.core.ArticleDTO;
import com.projetecam.diary.core.CreateArticleDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.projetecam.diary.core.RegisterRequestDTO;
import com.projetecam.diary.service.UserService;
import com.projetecam.diary.service.ArticleService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataFixtureElements implements CommandLineRunner {
    private final UserService userService;
    private final ArticleService articleService;

    @Override
    public void run(String... args) {
        userService.register(new RegisterRequestDTO("test-user-1", "test-user-1@mailbox.com", "SuperSecretPassword!"));
        userService.register(new RegisterRequestDTO("test-user-2", "test-user-2@mailbox.com", "SuperSecretPassword!"));
        userService.register(new RegisterRequestDTO("test-user-3", "test-user-3@mailbox.com", "SuperSecretPassword!"));

        ArticleDTO article1 = articleService.create(new CreateArticleDTO(LocalDate.now(),
                1,
                "",
                "",
                "",
                "",
                "",
                "",
                ""));
    }
}
package com.projetecam.diary.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {
    @GetMapping("test")
    public String test() {
        return "Hello World!";
    }
}

package com.projetecam.diary.api;

import com.projetecam.diary.core.LoginRequestDTO;
import com.projetecam.diary.core.LoginResponseDTO;
import com.projetecam.diary.core.RegisterRequestDTO;
import com.projetecam.diary.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;

    @PostMapping("login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userService.login(loginRequestDTO);
    }

    @PostMapping("register")
    public LoginResponseDTO register(@RequestBody RegisterRequestDTO registerRequestDTO){
        return userService.register(registerRequestDTO);
    }
}

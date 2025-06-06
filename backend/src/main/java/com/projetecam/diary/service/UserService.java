package com.projetecam.diary.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetecam.diary.core.LoginRequestDTO;
import com.projetecam.diary.core.LoginResponseDTO;
import com.projetecam.diary.core.RegisterRequestDTO;
import com.projetecam.diary.entity.User;
import com.projetecam.diary.persistence.UserRepository;
import com.projetecam.diary.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow();
        if (passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            return  new LoginResponseDTO(jwtUtil.generateToken(user.getId()));
        } else {
            throw new RuntimeException("Username or password is incorrect");
        }
    }

    public LoginResponseDTO register(RegisterRequestDTO registerRequestDto) {
        User newUser = new User(null, registerRequestDto.getEmail(), passwordEncoder.encode(registerRequestDto.getPassword()),
                registerRequestDto.getUsername(), 0);

        User savedUser = userRepository.save(newUser);

        return new LoginResponseDTO(jwtUtil.generateToken(savedUser.getId()));
    }
}

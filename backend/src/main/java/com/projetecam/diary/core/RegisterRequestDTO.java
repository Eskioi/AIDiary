package com.projetecam.diary.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;
}

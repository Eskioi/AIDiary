package com.projetecam.diary.core; 

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String jwtToken;
}

package com.projetecam.diary.core; 

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Data
public class LoginResponseDTO {
    private final String jwtToken;
}

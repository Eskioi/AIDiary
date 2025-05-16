package com.projetecam.diary.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public Long currentUserId() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            // Fallback to a default user ID for bootstrapping
            return 1L; // or throw an exception if you want to enforce login
        }
        return Long.parseLong(authentication.getPrincipal().toString());
    }
}

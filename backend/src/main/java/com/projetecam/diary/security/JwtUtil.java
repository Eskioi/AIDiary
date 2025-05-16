package com.projetecam.diary.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;
    private final long expirationTime;

    // Constructor injects the secret key and expiration time from properties
    public JwtUtil(@Value("${jwt.secret.key}") String secretKey,
                   @Value("${jwt.expiration.time}") long expirationTime) {
        // Ensure the key is at least 256 bits long
        if (secretKey.length() < 32) {
            throw new IllegalArgumentException("JWT Secret key must be at least 256 bits (32 characters)");
        }
        this.key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        this.expirationTime = expirationTime;
    }

    // Method to generate JWT token
    public String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }

    // Extracts the user ID from the token
    public Long extractUserId(String token) {
        try {
            return Long.parseLong(
                    Jwts.parserBuilder()
                            .setSigningKey(key)
                            .build()
                            .parseClaimsJws(token)
                            .getBody()
                            .getSubject()
            );
        } catch (ExpiredJwtException e) {
            // Token has expired
            throw new JwtException("Token has expired", e);
        } catch (SignatureException e) {
            // Invalid signature
            throw new JwtException("Invalid token signature", e);
        } catch (Exception e) {
            // Catch any other exceptions
            throw new JwtException("Token is invalid", e);
        }
    }

    // Checks if the token has expired
    public boolean isTokenExpired(String token) {
        try {
            Date expiration = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());
        } catch (JwtException e) {
            // If the token is invalid, assume it has expired or is malformed
            return true;
        }
    }
}

package com.projetecam.diary.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetecam.diary.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

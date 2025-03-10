package com.projetecam.diary.service;

import com.projetecam.diary.core.*;
import com.projetecam.diary.entity.*;
import com.projetecam.diary.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor

public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleDTO> search(LocalDate date){
        return articleRepository.search(date)
            .stream()
            .map(this::convertToArticleDto)
            .toList();
    }
}

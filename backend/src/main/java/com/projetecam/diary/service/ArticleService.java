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

    public List<ArticleDTO> search(String query, String headline, LocalDate date){
        return articleRepository.search(query, headline, date)
            .stream()
            .map(this::convertToArticleDto)
            .toList();
    }

    public ArticleDTO get(long id){
        Article article = articleRepository.findById(id).orElseThrow();
        return convertToArticleDto(article);
    }

    public ArticleDTO create(CreateArticleDTO createArticleDTO){
        Article article = new Article(null, authenticationService.creatorUserId(),
            createArticleDTO.getType(),
            createArticleDTO.getHeadline(),
            createArticleDTO.getSubHeadline1(),
            createArticleDTO.getText1(),
            createArticleDTO.getSubHeadline2(),
            createArticleDTO.getText2(),
            createArticleDTO.getSubHeadline3(),
            createArticleDTO.getText3());
        
        Article savedArticle = articleRepository.save(article);
        return convertToArticleDto(savedArticle);
    }

    private ArticleDTO convertToArticleDto(Article article){
        return new ArticleDTO(article.getId(),
            article.getCreatorUserId(),
            article.getDate(),
            article.getType(),
            article.getHeadline(),
            article.getSubHeadline1(),
            article.getText1(),
            article.getSubHeadline2(),
            article.getText2(),
            article.getSubHeadline3(),
            article.getText3());
    }

    public List<ArticleDTO> getUserArticleDTOs() {
        return articleRepository.findByCreatorUserId(authenticationService
            .currentUserId()
            .stream()
            .map(this::convertToArticleDto)
            .toList());
    }
}

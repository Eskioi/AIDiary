package com.projetecam.diary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projetecam.diary.core.ArticleDTO;
import com.projetecam.diary.core.CreateArticleDTO;
import com.projetecam.diary.entity.Article;
import com.projetecam.diary.persistence.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;  // Make it final
    private final AuthenticationService authenticationService;  // Make it final

    public List<ArticleDTO> search(String query, LocalDate date) {
        return articleRepository.search(query, date)
                .stream()
                .map(this::convertToArticleDto)
                .toList();
    }

    public ArticleDTO get(long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        return convertToArticleDto(article);
    }

    public ArticleDTO create(CreateArticleDTO createArticleDTO) {
        Article article = new Article(null, authenticationService.currentUserId(),
                createArticleDTO.getDate(),
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

    private ArticleDTO convertToArticleDto(Article article) {
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
        Long currentUserId = authenticationService.currentUserId();

        return articleRepository.findByCreatorUserId(currentUserId)
                .stream()
                .map(this::convertToArticleDto)
                .toList();
    }
}

package com.projetecam.diary.api;

import com.projetecam.diary.core.ArticleDTO;
import com.projetecam.diary.core.CreateArticleDTO;
import com.projetecam.diary.service.ArticleService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("help-request")
@RequiredArgsConstructor

public class ArticleAPI {
    private final ArticleService articleService;

    @GetMapping("search")
    public List<ArticleDTO> search(@RequestParam String query, @RequestParam LocalDate date){
        return articleService.search(query, date);
    }

    @GetMapping("{id}")
    public ArticleDTO get(@PathVariable("id") long id){
        return articleService.get(id);
    }
}

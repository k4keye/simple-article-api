package com.simple.article.controller;

import com.simple.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author         : raon_jh
 * date           : 2022/09/05
 * description    :
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity saveArticle(){
        articleService.saveNewArticle();
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}

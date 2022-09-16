package com.simple.article.service;

import com.simple.article.domain.Article;
import com.simple.article.dummy.DummyArticle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class FindArticleTest extends DummyArticle {

    @Autowired
    private ArticleService articleService;
    @Test
    @DisplayName("article 전체 조회")
    public void fetchAllArticle(){
        PageRequest of = PageRequest.of(0, 10);

        Page<Article> articles = articleService.fetchAll(of);

        System.out.println("articles.getTotalElements() = " + articles.getTotalElements());
        Assertions.assertTrue(articles.getTotalElements() > 0);
    }
}

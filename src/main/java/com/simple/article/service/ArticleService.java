package com.simple.article.service;

import com.simple.article.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void saveArticle(String title, String context){

    }

    public void fetch(){

    }

    public void update(){

    }
    public void delete(){

    }
}

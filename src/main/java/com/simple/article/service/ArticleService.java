package com.simple.article.service;

import com.simple.article.domain.Article;
import com.simple.article.domain.Member;
import com.simple.article.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;
    public void post(Member member, String title, String context){

        Article article = new Article(title, context);
        member.newArticle(article);

        articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public Page<Article> fetchAll(Pageable pageable){
        return articleRepository.findAll(pageable);
    }

    public Article fetch(Long id){
        return articleRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("not exist article id"));
    }
    public void update(){

    }
    public void delete(Long id){
        Article fetch = fetch(id);
        fetch.inActive();
    }
}

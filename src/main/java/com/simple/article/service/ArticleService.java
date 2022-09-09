package com.simple.article.service;

import com.simple.article.domain.Member;
import com.simple.article.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberService memberService;

    public void saveArticle(String title, String context){
        Member authMember = memberService.getAuthMember();
        System.out.println("authMember = " + authMember);
    }

    public void fetch(){

    }

    public void update(){

    }
    public void delete(){

    }
}

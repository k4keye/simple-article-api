package com.simple.article.dummy;

import com.simple.article.domain.Article;
import com.simple.article.domain.Member;
import com.simple.article.domain.repository.ArticleRepository;
import com.simple.article.service.ArticleService;
import com.simple.article.service.LoginService;
import com.simple.article.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
public class DummyArticle extends DummyMember{

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    public void createDummyArticle(){

        String title = "dummy title";
        String context = "dummy context";

        Member member = memberService.fetchMember(loginId);
        Assertions.assertNotNull(member);

        articleService.post(member,title,context);

        em.flush();
        em.clear();
        List<Article> all = articleRepository.findAll();
        Assertions.assertTrue(all.size()>0);
    }
}

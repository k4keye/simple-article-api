package com.simple.article.controller.dto.response;


import com.simple.article.domain.Article;
import com.simple.article.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ArticleDto {

    private long no;
    private String author;
    private String title;
    private String context;


    public ArticleDto(Article article) {
        this.no = article.getId();
        this.author = article.getMember().getNickName();
        this.title = article.getTitle();
        this.context = article.getContext();
    }
}

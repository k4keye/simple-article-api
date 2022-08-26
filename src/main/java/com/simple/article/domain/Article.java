package com.simple.article.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ARTICLE")
public class Article {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "context")
    private String context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Member member;

    public void setAuthor(Member member){
        this.member = member;
    }
}

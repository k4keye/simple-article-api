package com.simple.article.domain;

import com.simple.article.domain.base.BaseStateEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ARTICLE")
public class Article extends BaseStateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "context")
    private String context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Member member;

    public Article(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public void setAuthor(Member member){
        this.member = member;
    }
}

package com.simple.article.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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
}

package com.simple.article.domain;


import com.simple.article.domain.base.BaseStateEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "TB_MEMBER")
public class Member extends BaseStateEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "login_id", unique = true)
    private String loginID;

    @Column(name = "login_pwd")
    private String loginPWD;

    @Column(name = "nick_name", unique = true)
    private String nickName;

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    public void newArticles(Article article){
        if(article != null){
            getArticles().add(article);
            article.setAuthor(this);
        }
    }

}

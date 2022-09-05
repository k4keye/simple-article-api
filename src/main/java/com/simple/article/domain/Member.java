package com.simple.article.domain;


import com.simple.article.domain.base.BaseStateEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    public Member(String loginID, String loginPWD, String nickName, String email) {
        this.loginID = loginID;
        this.loginPWD = loginPWD;
        this.nickName = nickName;
        this.email = email;
    }

    public void newArticles(Article article){
        if(article != null){
            getArticles().add(article);
            article.setAuthor(this);
        }
    }

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "loginID", referencedColumnName = "loginID")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorities;

}

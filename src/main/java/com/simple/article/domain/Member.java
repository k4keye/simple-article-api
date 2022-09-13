package com.simple.article.domain;


import com.simple.article.domain.base.BaseStateEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Getter
@ToString(exclude = {"articles","authorities"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_MEMBER")
public class Member extends BaseStateEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        this.active();

        Authority authority = Authority.userAuth();
        this.authorities.add(authority);
    }

    public void newArticle(Article article){
        if(article != null){
            getArticles().add(article);
            article.setAuthor(this);
        }
    }

    @ManyToMany
    @JoinTable(
            name = "tb_member_authority",
            joinColumns = {@JoinColumn(name = "login_id", referencedColumnName = "login_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorities = new HashSet<>();

    public boolean isAdmin(){

        Optional<Authority> first = this.authorities.stream()
                .filter(Authority::isAdmin)
                .findFirst();

        return first.isPresent();
    }

    public void changeEmail(String newEmail){
        this.email = newEmail;
    }

    public void changeNickName(String newNickName){
        this.nickName = newNickName;
    }
}

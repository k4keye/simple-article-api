package com.simple.article.domain;


import com.simple.article.domain.base.BaseStateEntity;
import com.simple.article.vo.Email;
import com.simple.article.vo.LoginID;
import com.simple.article.vo.NickName;
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

    private static final long serialVersionUID = 1L;


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @Embedded
//    @AttributeOverride(name="value", column=@Column(name="login_id", nullable = false , unique = true))

    @Column(name = "login_id")
    private String loginID;

    @Column(name = "login_pwd")
    private String loginPWD;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "nick_name", nullable = false , unique = true))
    private NickName nickName;

  //  @Column(name = "email")
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email", nullable = false))
    private Email email;

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    public Member(LoginID loginID, String loginPWD, NickName nickName, Email email) {
        this.loginID = loginID.getValue();
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

    public String getEmail() {
        return email.getValue();
    }

    public String getLoginID() {
        return loginID;
    }

    public String getNickName(){
        return nickName.getValue();
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

    public void changeEmail(Email newEmail){
        this.email = newEmail;
    }

    public void changeNickName(NickName newNickName){
        this.nickName = newNickName;
    }
}

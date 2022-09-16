package com.simple.article.dummy;

import com.simple.article.domain.Member;
import com.simple.article.domain.repository.MemberRepository;
import com.simple.article.service.LoginService;
import com.simple.article.vo.Email;
import com.simple.article.vo.LoginID;
import com.simple.article.vo.NickName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DummyMember {

    @Autowired
    private LoginService loginService;
    public static String loginId = "loginTest";

    private String loginPwd = "loginPwd";
    private String nickName = "nickname";
    private String email = "email@naver.com";

    @BeforeEach
    public void createDummyMember(){
        Member saveMember = loginService.join(new LoginID(loginId), loginPwd, new NickName(nickName), new Email(email));
        Assertions.assertNotNull(saveMember);
    }
}

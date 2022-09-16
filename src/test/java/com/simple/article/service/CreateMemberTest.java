package com.simple.article.service;

import com.simple.article.domain.Member;
import com.simple.article.domain.repository.MemberRepository;
import com.simple.article.vo.Email;
import com.simple.article.vo.LoginID;
import com.simple.article.vo.NickName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author         : raon_jh
 * date           : 2022/09/05
 * description    :
 */
@SpringBootTest
@Transactional
class CreateMemberTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private MemberRepository memberRepository;
    public String loginId = "loginTest";

    private String loginPwd = "loginPwd";
    private String nickName = "nickname";
    private String email = "email@naver.com";


    @Test
    @DisplayName("[성공] 회원가입")
    public void joinSuccess(){
        
        Member saveMember = loginService.join(new LoginID(loginId), loginPwd, new NickName(nickName), new Email(email));
        Assertions.assertNotNull(saveMember);


        System.out.println("saveMember = " + saveMember);
        Assertions.assertEquals(loginId, saveMember.getLoginID());
        Member findMember = memberRepository.findById(saveMember.getId())
                                                .orElseGet(() -> Assertions.fail());

        Assertions.assertEquals(loginId, findMember.getLoginID());
    }

    @Test
    @DisplayName("[성공] 로그인")
    public void loginSuccess(){

        joinSuccess();

        String token= loginService.login(loginId, loginPwd);

        System.out.println("token = " + token);

        assertNotNull(token);

    }
}
package com.simple.article.service;

import com.simple.article.config.TokenProvider;
import com.simple.article.domain.Member;
import com.simple.article.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public String login(String id, String pwd){
        Member member = memberService.fetchMember(id);

        if( ! passwordEncoder.matches(pwd,member.getLoginPWD())){
            throw new IllegalStateException("not match login password");
        }

        return getToken(id,pwd);
    }

    private String getToken(String id ,String pwd){
        //https://studyandwrite.tistory.com/499

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(id, pwd);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);

        return token;
    }
    public Member join(String id, String pwd,String nickName, String email){

        if(memberService.existLoginId(id))
            throw new IllegalStateException("exist member login id");

        if(memberService.existNickName(nickName))
            throw new IllegalStateException("exist member nickName");

        String encodePwd = passwordEncoder.encode(pwd);

        return memberService.saveMember(id,encodePwd,nickName,email);
    }
}

package com.simple.article.service;

import com.simple.article.domain.Member;
import com.simple.article.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;


    public boolean login(String id, String pwd){
        Member member = memberService.fetchMember(id);
        if( ! member.getLoginPWD().equals(pwd)){
            return false;
        }

        return true;
    }
    public void join(String id, String pwd,String nickName, String email){

        if(memberService.existLoginId(id))
            throw new IllegalStateException("exist member login id");

        if(memberService.existNickName(nickName))
            throw new IllegalStateException("exist member nickName");


        memberService.saveMember(id,pwd,nickName,email);

        //패스워드 해시
       // String randomNickName = RandomUtils.getString(true, 20);
    }
}

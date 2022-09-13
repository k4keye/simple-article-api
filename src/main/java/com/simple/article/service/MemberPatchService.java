package com.simple.article.service;

import com.simple.article.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberPatchService {
    private final MemberService memberService;

    @Transactional
    public void patch(Member member, String op, String path, String value){

        if(op.equals("replace")){
            replaceOp(member,path,value);
        }
        if(op.equals("add")){
            addOp(member,path,value);
        }
        if(op.equals("remove")){
            removeOp(member,path,value);
        }
    }

    private void replaceOp(Member member,String path, String value){
        if(path.equals("email")){
            member.changeEmail(value);
            return;
        }

        if(path.equals("nickName")){
            member.changeNickName(value);
            return;
        }
    }
    private void addOp(Member member,String path, String value){

    }
    private void removeOp(Member member,String path, String value){

    }
}

package com.simple.article.service;

import com.simple.article.domain.Member;
import com.simple.article.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member fetchMember(String id){
        return memberRepository
                .findByLoginID(id)
                .orElseThrow(() -> new IllegalStateException("not exist member"));
    }

    @Transactional(readOnly = true)
    public boolean existLoginId(String id){
        return memberRepository.existsByLoginID(id);
    }
    @Transactional(readOnly = true)
    public boolean existNickName(String nickName){
        return memberRepository.existsByNickName(nickName);
    }

    public void saveMember(String id, String pwd, String nickName, String email ){
        Member member = new Member(id, pwd, nickName, email);
        memberRepository.save(member);
    }
    public void update(){

    }

    public void delete(){

    }
}

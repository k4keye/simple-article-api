package com.simple.article.domain.repository;

import com.simple.article.domain.Member;
import com.simple.article.vo.LoginID;
import com.simple.article.vo.NickName;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Member> findOneWithAuthoritiesByLoginID(String loginID);


    boolean existsByLoginID(String loginId);
    boolean existsByNickName(NickName nickName);

    Optional<Member> findByLoginID(String loginId);
}

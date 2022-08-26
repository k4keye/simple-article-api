package com.simple.article.domain.repository;

import com.simple.article.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByLoginID(String loginId);
    boolean existsByNickName(String nickName);

    Optional<Member> findByLoginID(String loginId);
}

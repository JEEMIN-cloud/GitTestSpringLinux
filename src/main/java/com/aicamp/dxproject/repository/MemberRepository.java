package com.aicamp.dxproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aicamp.dxproject.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByUserIdAndPw(String userId, String pw);

    boolean existsById(String userId);
}
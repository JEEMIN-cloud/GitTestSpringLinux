package com.aicamp.dxproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aicamp.dxproject.entity.Member;
import com.aicamp.dxproject.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member regist(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> login(String userId, String pw) {
        return memberRepository.findByUserIdAndPw(userId, pw);
    }

    public boolean checkId(String userId) {
        return memberRepository.existsById(userId);
    }
}
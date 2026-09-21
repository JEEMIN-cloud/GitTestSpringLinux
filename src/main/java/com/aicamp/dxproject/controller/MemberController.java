package com.aicamp.dxproject.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aicamp.dxproject.entity.Member;
import com.aicamp.dxproject.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller 
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    @PostMapping("/regist")
    public String registMember(@RequestParam String userId,
                               @RequestParam String pw,
                               @RequestParam String name,
                               @RequestParam int age) {

        Member member = new Member();
        member.setUserId(userId);
        member.setPw(pw);
        member.setName(name);
        member.setAge(age);

        memberService.regist(member);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginMember(@RequestParam String userId,
                             @RequestParam String pw,
                             HttpSession session,
                             RedirectAttributes rttr) {

        Optional<Member> member = memberService.login(userId, pw);

        if (member.isPresent()) {
            session.setAttribute("loginUser", member.get());
            return "redirect:/mypage";
        } else {
            rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("loginUser");
        model.addAttribute("member", member);
        return "mypage";
    }
}
package com.ssg.membertest.controller;

import com.ssg.membertest.Member;
import com.ssg.membertest.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@Log4j2
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("/list");
        List<Member> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
    }

    @GetMapping("/register")
    public void register() {
        log.info("/register");
    }

    @PostMapping("/save")
    public void save(Member member, Model model){
        log.info("/save");
        memberService.joinMember(member);
        model.addAttribute("member", member);
    }

}

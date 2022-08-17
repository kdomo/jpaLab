package com.jpaLab.Controller;

import com.jpaLab.Entity.Member;
import com.jpaLab.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberRepository memberRepository;
    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/save")
    public Member memberSave(Member member){
        return memberRepository.save(member);

    }
}

package com.jpaLab.Controller;

import com.jpaLab.Entity.Member;
import com.jpaLab.Repository.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController("/member")
public class MemberController {

    private MemberRepository memberRepository;

    @GetMapping("/save")
    @Transactional
    public Member memberSave(Member member){
        return memberRepository.save(member);

    }
}

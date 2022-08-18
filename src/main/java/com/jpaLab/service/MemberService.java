package com.jpaLab.service;

import com.jpaLab.dto.MemberDto;
import com.jpaLab.entity.Member;
import com.jpaLab.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class MemberService {
    private MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<Member> findAll(Pageable pageable){
        return memberRepository.findAll(pageable);
    }

    public Long save(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        member.setCreatedDate(LocalDateTime.now());
        member.setCreatedBy(member.getName());
        member.setModifiedDate(LocalDateTime.now());
        member.setModifiedBy(member.getName());
        return memberRepository.save(member).getId();
    }

//    public Long save(MemberDto dto){
//        return memberRepository.save(dto.toEntity()).getId();
//    }
}

package com.jpaLab.controller;

import com.jpaLab.dto.MemberDto;
import com.jpaLab.entity.Member;
import com.jpaLab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



    @GetMapping
    public ResponseEntity<Page<Member>> memberList(Pageable pageable){
//        return new ResultEntity<>(HttpServletResponse.SC_OK,"",memberService.findAll(PageRequest.of(page,size)).getContent());
        try {
            Page<Member> memberList = memberService.findAll(pageable);
            return ResponseEntity.ok()
                    .body(memberList);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/save")
    public ResponseEntity<Long> memberSave(MemberDto memberDto){
        try{
            Long member = memberService.save(memberDto);
            return ResponseEntity.ok()
                    .body(member);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


//    @Transactional(readOnly = true)
//    @GetMapping("/save")
//    public ResponseEntity<Long> memberSave(MemberDto memberDto){
//
//        try{
//            Long memberId = memberService.save(memberDto);
//            return new ResultEntity<>(HttpStatus.CREATED,memberId);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResultEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//
//    }
}

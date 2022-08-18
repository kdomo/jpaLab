package com.jpaLab.dto;

import com.jpaLab.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private int age;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }
}

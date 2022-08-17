package com.jpaLab.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

}

package com.jpaLab.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "tbl_member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

}

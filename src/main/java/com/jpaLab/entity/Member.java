package com.jpaLab.entity;

import com.jpaLab.common.entity.BaseEntity;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Where(clause = "is_del = 0")
public class Member extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -553387833344791762L;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int age;

}

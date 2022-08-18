package com.jpaLab.common.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
//@EntityListeners(value={AuditingEntityListener.class})
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 2953580233610416382L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name = "is_del")
    private boolean isDel;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

}

package com.jpaLab.repository;

import com.jpaLab.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>, CrudRepository<Member,Long>{
    @Query("SELECT m " +
            "FROM Member m " +
            "ORDER BY m.id DESC")
    Page<Member> findAll(Pageable pageable);

    Member save(Member member);
}

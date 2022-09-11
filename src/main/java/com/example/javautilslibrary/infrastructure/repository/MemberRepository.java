package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.infrastructure.repository.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    public MemberEntity save(MemberEntity entity);
}

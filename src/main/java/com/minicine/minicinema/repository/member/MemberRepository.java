package com.minicine.minicinema.repository.member;

import com.minicine.minicinema.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryCustom {
    // 쿼리 메서드
    MemberEntity findMemberByUsername(String username);
}

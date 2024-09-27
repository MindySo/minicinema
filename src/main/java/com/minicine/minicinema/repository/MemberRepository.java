package com.minicine.minicinema.repository;

import com.minicine.minicinema.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 쿼리 메서드
    MemberEntity findMemberByUsername(String username);
    boolean existsByUsername(String username);

    MemberEntity findMemberById(Long memberId);
}

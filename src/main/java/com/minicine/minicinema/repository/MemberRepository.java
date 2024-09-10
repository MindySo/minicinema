package com.minicine.minicinema.repository;

import com.minicine.minicinema.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryCustom {
    Optional<MemberEntity> findByUsername(String username);
}

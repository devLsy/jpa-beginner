package com.test.lsy.jpa01.ex02.member.repository;

import com.test.lsy.jpa01.ex02.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

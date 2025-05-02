package com.test.lsy.jpa01.ex02.repository;

import com.test.lsy.jpa01.ex02.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

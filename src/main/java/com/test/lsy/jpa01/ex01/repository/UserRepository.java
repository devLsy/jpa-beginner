package com.test.lsy.jpa01.ex01.repository;

import com.test.lsy.jpa01.ex01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

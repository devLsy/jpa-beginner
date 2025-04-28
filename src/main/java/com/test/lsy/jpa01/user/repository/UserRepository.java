package com.test.lsy.jpa01.user.repository;

import com.test.lsy.jpa01.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

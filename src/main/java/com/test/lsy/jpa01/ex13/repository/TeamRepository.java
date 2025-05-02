package com.test.lsy.jpa01.ex13.repository;

import com.test.lsy.jpa01.ex13.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

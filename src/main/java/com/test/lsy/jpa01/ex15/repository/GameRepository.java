package com.test.lsy.jpa01.ex15.repository;

import com.test.lsy.jpa01.ex15.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

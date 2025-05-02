package com.test.lsy.jpa01.ex12.repository;

import com.test.lsy.jpa01.ex12.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

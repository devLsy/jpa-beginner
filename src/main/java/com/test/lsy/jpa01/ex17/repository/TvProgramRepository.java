package com.test.lsy.jpa01.ex17.repository;

import com.test.lsy.jpa01.ex17.domain.TvProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvProgramRepository extends JpaRepository<TvProgram, Long> {
}

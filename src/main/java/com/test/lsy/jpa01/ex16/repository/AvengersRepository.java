package com.test.lsy.jpa01.ex16.repository;

import com.test.lsy.jpa01.ex16.domain.Avengers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvengersRepository extends JpaRepository<Avengers, Long> {
}

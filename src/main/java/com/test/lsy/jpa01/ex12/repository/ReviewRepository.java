package com.test.lsy.jpa01.ex12.repository;

import com.test.lsy.jpa01.ex12.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

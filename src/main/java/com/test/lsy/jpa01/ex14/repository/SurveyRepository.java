package com.test.lsy.jpa01.ex14.repository;

import com.test.lsy.jpa01.ex14.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}

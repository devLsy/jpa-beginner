package com.test.lsy.jpa01.ex14.controller;


import com.test.lsy.jpa01.ex14.domain.Survey;
import com.test.lsy.jpa01.ex14.repository.SurveyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/survey")
@Tag(name = "Survey API")
public class SurveyController {

    private final SurveyRepository surveyRepository;

    @Operation(summary = "설문 저장", description = "설문을 저장합니다.")
    @PostMapping
    public Survey save(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    @Operation(summary = "설문 목록 조회", description = "설문 목록을 조회합니다.")
    @GetMapping
    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }
}

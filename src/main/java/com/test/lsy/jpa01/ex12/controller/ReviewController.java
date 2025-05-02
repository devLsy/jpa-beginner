package com.test.lsy.jpa01.ex12.controller;

import com.test.lsy.jpa01.ex12.domain.Review;
import com.test.lsy.jpa01.ex12.repository.ReviewRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Tag(name = "Review API")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @Operation(summary = "리뷰 저장", description = "리뷰를 저장합니다.")
    @PostMapping
    public Review save(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @Operation(summary = "리뷰 목록 조회", description = "리뷰 목록을 조회합니다.")
    @GetMapping
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }
}

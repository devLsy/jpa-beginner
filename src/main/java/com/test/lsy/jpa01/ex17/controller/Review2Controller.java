package com.test.lsy.jpa01.ex17.controller;

import com.test.lsy.jpa01.ex17.domain.Review2;
import com.test.lsy.jpa01.ex17.repository.Review2Repository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reviews2")
@Tag(name = "Reviews2 API")
public class Review2Controller {

    private final Review2Repository review2Repository;

    @GetMapping("/hotel/{hotelId}")
    public List<Review2> getByHotel(@PathVariable(name = "hotelId") String hotelId) {
        return review2Repository.findByHotelIdOrderByIdDesc(hotelId);
    }

    @GetMapping("/count/{hotelId}")
    public Long count(@PathVariable(name = "hotelId") String hotelId) {
        return review2Repository.countByHotelId(hotelId);
    }

    @GetMapping("/search")
    public List<Review2> search(@RequestParam(name = "keyword") String keyword) {
        return review2Repository.searchByContentKeyword(keyword);
    }

    @GetMapping
    public List<Review2> getList() {
        return review2Repository.findAll();
    }

    @PostMapping
    public Review2 save(@RequestBody Review2 review2) {
        return review2Repository.save(review2);
    }
}

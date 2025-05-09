package com.test.lsy.jpa01.ex16.controller;

import com.test.lsy.jpa01.ex16.domain.Avengers;
import com.test.lsy.jpa01.ex16.repository.AvengersRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/avengers")
@Tag(name = "Avengers API")
public class AvengersController {

    private final AvengersRepository avengersRepository;

    @Operation(summary = "영웅 저장", description = "영웅을 저장합니다.")
    @PostMapping
    public Avengers save(@RequestBody Avengers avengers) {
        return avengersRepository.save(avengers);
    }

    @Operation(summary = "마블 영웅 목록 조회", description = "마블 영웅 목록을 조회합니다.")
    @GetMapping
    public List<Avengers> getAll() {
        return avengersRepository.findAll();
    }
}

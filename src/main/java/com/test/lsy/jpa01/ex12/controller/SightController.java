package com.test.lsy.jpa01.ex12.controller;

import com.test.lsy.jpa01.ex12.domain.Sight;
import com.test.lsy.jpa01.ex12.repository.SightRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sights")
@Tag(name = "Sight API")
public class SightController {

    private final SightRepository sightRepository;

    @Operation(summary = "사이트 저장", description = "사이트를 저장합니다.")
    @PostMapping
    public Sight save(@RequestBody Sight sight) {
        return sightRepository.save(sight);
    }

    @Operation(summary = "사이트 목록 조회", description = "사이트 목록을 조회합니다.")
    @GetMapping
    public List<Sight> getAll() {
        return sightRepository.findAll();
    }
}

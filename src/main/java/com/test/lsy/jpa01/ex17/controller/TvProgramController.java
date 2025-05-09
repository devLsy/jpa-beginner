package com.test.lsy.jpa01.ex17.controller;

import com.test.lsy.jpa01.ex17.domain.TvProgram;
import com.test.lsy.jpa01.ex17.repository.TvProgramRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tv")
@Tag(name = "TVs API")
public class TvProgramController {

    private final TvProgramRepository tvProgramRepository;

    @Operation(summary = "프로그램 저장", description = "프로그램을 저장합니다.")
    @PostMapping
    public TvProgram save(@RequestBody TvProgram tvProgram) {
        return tvProgramRepository.save(tvProgram);
    }

    @Operation(summary = "프로그램 목록 조회", description = "프로그램 목록을 조회합니다.")
    @GetMapping
    public List<TvProgram> getAll() {
        return tvProgramRepository.findAll();
    }
}

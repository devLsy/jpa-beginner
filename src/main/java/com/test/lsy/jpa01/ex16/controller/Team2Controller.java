package com.test.lsy.jpa01.ex16.controller;


import com.test.lsy.jpa01.ex16.domain.Team2;
import com.test.lsy.jpa01.ex16.repository.Team2Repository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/team2")
@Tag(name = "Team2 API")
public class Team2Controller {

    private final Team2Repository team2Repository;

    @Operation(summary = "팀 저장", description = "팀을 저장합니다.")
    @PostMapping
    public Team2 save(@RequestBody Team2 team2) {
        return team2Repository.save(team2);
    }

    @Operation(summary = "팀 목록 조회", description = "팀 목록을 조회합니다.")
    @GetMapping
    public List<Team2> getAll() {
        return team2Repository.findAll();
    }
}

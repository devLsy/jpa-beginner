package com.test.lsy.jpa01.ex13.controller;

import com.test.lsy.jpa01.ex13.domain.Team;
import com.test.lsy.jpa01.ex13.repository.TeamRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/teams")
@Tag(name = "Team API")
public class TeamController {

    private final TeamRepository teamRepository;

    @Operation(summary = "팀 저장", description = "팀을 저장합니다.")
    @PostMapping
    public Team save(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @Operation(summary = "팀 목록 조회", description = "팀 목록을 조회합니다.")
    @GetMapping
    public List<Team> getAll() {
        return teamRepository.findAll();
    }
}

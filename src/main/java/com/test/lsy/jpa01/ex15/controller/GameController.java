package com.test.lsy.jpa01.ex15.controller;


import com.test.lsy.jpa01.ex15.domain.Game;
import com.test.lsy.jpa01.ex15.repository.GameRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/game")
@Tag(name = "Game API")
public class GameController {

    private final GameRepository gameRepository;

    @Operation(summary = "게임 저장", description = "게임을 저장합니다.")
    @PostMapping
    public Game save(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @Operation(summary = "게임 목록 조회", description = "게임 목록을 조회합니다.")
    @GetMapping
    public List<Game> getAll() {
        return gameRepository.findAll();
    }
}

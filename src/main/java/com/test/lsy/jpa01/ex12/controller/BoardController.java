package com.test.lsy.jpa01.ex12.controller;

import com.test.lsy.jpa01.ex12.domain.Board;
import com.test.lsy.jpa01.ex12.repository.BoardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boards")
@Tag(name = "Board API")
public class BoardController {

    private final BoardRepository boardRepository;

    @Operation(summary = "게시글 저장", description = "게시글을 저장합니다.")
    @PostMapping
    public Board save(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @Operation(summary = "게시글 목록 조회", description = "게시글 목록을 조회합니다.")
    @GetMapping
    public List<Board> getAll() {
        return boardRepository.findAll();
    }
}

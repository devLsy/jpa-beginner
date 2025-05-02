package com.test.lsy.jpa01.ex12.controller;

import com.test.lsy.jpa01.ex12.domain.Reply;
import com.test.lsy.jpa01.ex12.repository.ReplyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replys")
@Tag(name = "Reply API")
public class ReplyController {

    private final ReplyRepository replyRepository;

    @Operation(summary = "댓글 저장", description = "댓글을 저장합니다.")
    @PostMapping
    public Reply save(@RequestBody Reply reply) {
        return replyRepository.save(reply);
    }
    
    @Operation(summary = "댓글 목록 조회", description = "댓글 목록을 조회합니다.")
    @GetMapping
    public List<Reply> getAll() {
        return replyRepository.findAll();
    }
}

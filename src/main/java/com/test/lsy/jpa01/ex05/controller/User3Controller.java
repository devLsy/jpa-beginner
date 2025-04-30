package com.test.lsy.jpa01.ex05.controller;

import com.test.lsy.jpa01.ex05.domain.User3;
import com.test.lsy.jpa01.ex05.repository.User3Repository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users3")
@Tag(name = "사용자3 API")
public class User3Controller {

    private final User3Repository user3Repository;

    @PostMapping
    @Operation(summary = "사용자3 저장", description = "사용자3을 저장합니다.")
    public User3 save(@RequestBody User3 user3) {
        return user3Repository.save(user3);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자3 조회", description = "사용자3을 단건 조회합니다.")
    public User3 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return user3Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자3 전체 조회", description = "사용자3 전체를 조회합니다.")
    public List<User3> findAll() {
        return user3Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자3 수정", description = "사용자3을 수정합니다.")
    public User3 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User3 newUser3) {
        User3 findedUser3 = user3Repository.findById(id).orElseThrow();
        findedUser3.setName(newUser3.getName());
        findedUser3.setAddress(newUser3.getAddress());
        return findedUser3;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자3 삭제", description = "사용자3을 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (user3Repository.existsById(id)) {
            user3Repository.deleteById(id);
        }
    }
}

package com.test.lsy.jpa01.ex10.controller;

import com.test.lsy.jpa01.ex10.domain.User10;
import com.test.lsy.jpa01.ex10.repository.User10Repository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user10")
@RequiredArgsConstructor
@Tag(name = "사용자 10 API")
public class User10CardController {

    private final User10Repository user10Repository;

    @PostMapping
    @Operation(summary = "사용자 10 저장", description = "사용자 10을 저장합니다.")
    public User10 save(@RequestBody User10 user10) {
        return user10Repository.save(user10);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자 10 조회", description = "사용자 10을 단건 조회합니다.")
    public User10 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") String id) {
        return user10Repository.findById(id.toString()).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자 10 전체 조회", description = "사용자 10 전체를 조회합니다.")
    public List<User10> findAll() {
        return user10Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자10 수정", description = "사용자10을 수정합니다.")
    public User10 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") String id, @RequestBody User10 newUser10) {
        User10 findedUser8 = user10Repository.findById(id.toString()).orElseThrow();
        findedUser8.setName(newUser10.getName());
        return findedUser8;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자10 삭제", description = "사용자10을 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") String id) {
        if (user10Repository.existsById(id.toString())) {
            user10Repository.deleteById(id.toString());
        }
    }
}

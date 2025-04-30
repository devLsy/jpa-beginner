package com.test.lsy.jpa01.ex08.controller;

import com.test.lsy.jpa01.ex08.domain.User7;
import com.test.lsy.jpa01.ex08.repository.User7Repository;
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
@RequestMapping("/users6")
@Tag(name = "사용자6 API")
public class User7Controller {

    private final User7Repository user7Repository;

    @PostMapping
    @Operation(summary = "사용자6 저장", description = "사용자6을 저장합니다.")
    public User7 save(@RequestBody User7 user7) {
        return user7Repository.save(user7);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자6 조회", description = "사용자6을 단건 조회합니다.")
    public User7 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return user7Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자6 전체 조회", description = "사용자6 전체를 조회합니다.")
    public List<User7> findAll() {
        return user7Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자6 수정", description = "사용자6을 수정합니다.")
    public User7 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User7 newUser7) {
        User7 findedUser7 = user7Repository.findById(id).orElseThrow();
        findedUser7.setName(newUser7.getName());
        return findedUser7;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자6 삭제", description = "사용자6을 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (user7Repository.existsById(id)) {
            user7Repository.deleteById(id);
        }
    }
}

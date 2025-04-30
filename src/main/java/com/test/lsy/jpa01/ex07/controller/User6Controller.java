package com.test.lsy.jpa01.ex07.controller;

import com.test.lsy.jpa01.ex07.domain.User6;
import com.test.lsy.jpa01.ex07.repository.User6Repository;
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
@RequestMapping("/users5")
@Tag(name = "사용자5 API")
public class User6Controller {

    private final User6Repository user6Repository;

    @PostMapping
    @Operation(summary = "사용자5 저장", description = "사용자5를 저장합니다.")
    public User6 save(@RequestBody User6 user6) {
        return user6Repository.save(user6);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자5 조회", description = "사용자5를 단건 조회합니다.")
    public User6 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return user6Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자5 전체 조회", description = "사용자5 전체를 조회합니다.")
    public List<User6> findAll() {
        return user6Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자5 수정", description = "사용자5를 수정합니다.")
    public User6 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User6 newUser6) {
        User6 findedUser6 = user6Repository.findById(id).orElseThrow();
        findedUser6.setName(newUser6.getName());
        return findedUser6;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자5 삭제", description = "사용자5를 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (user6Repository.existsById(id)) {
            user6Repository.deleteById(id);
        }
    }
}

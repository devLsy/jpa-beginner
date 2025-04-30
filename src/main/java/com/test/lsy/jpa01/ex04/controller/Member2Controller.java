package com.test.lsy.jpa01.ex04.controller;

import com.test.lsy.jpa01.ex04.domain.User2;
import com.test.lsy.jpa01.ex04.repository.Member2Repository;
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
@RequestMapping("/members2")
@Tag(name = "멤버2 API")
public class Member2Controller {

    private final Member2Repository member2Repository;

    @PostMapping
    @Operation(summary = "멤버 저장", description = "멤버를 저장합니다.")
    public User2 save(@RequestBody User2 user2) {
        return member2Repository.save(user2);
    }

    @GetMapping("/{id}")
    @Operation(summary = "멤버 조회", description = "멤버를 단건 조회합니다.")
    public User2 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return member2Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "멤버 전체 조회", description = "멤버 전체를 조회합니다.")
    public List<User2> findAll() {
        return member2Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "멤버 수정", description = "멤버를 수정합니다.")
    public User2 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User2 newUser2) {
        User2 findedUser2 = member2Repository.findById(id).orElseThrow();
        findedUser2.setName(newUser2.getName());
        findedUser2.setAddress(newUser2.getAddress());
        return member2Repository.save(findedUser2);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "멤버 삭제", description = "멤버를 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (member2Repository.existsById(id)) {
            member2Repository.deleteById(id);
        }
    }
}

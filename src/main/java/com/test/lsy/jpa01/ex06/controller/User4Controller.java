package com.test.lsy.jpa01.ex06.controller;

import com.test.lsy.jpa01.ex06.domain.User5;
import com.test.lsy.jpa01.ex06.repository.User4Repository;
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
@RequestMapping("/users4")
@Tag(name = "사용자4 API")
public class User4Controller {

    private final User4Repository user4Repository;

    @PostMapping
    @Operation(summary = "사용자4 저장", description = "사용자4를 저장합니다.")
    public User5 save(@RequestBody User5 user5) {
        return user4Repository.save(user5);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자4 조회", description = "사용자4를 단건 조회합니다.")
    public User5 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return user4Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자4 전체 조회", description = "사용자4 전체를 조회합니다.")
    public List<User5> findAll() {
        return user4Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자4 수정", description = "사용자4를 수정합니다.")
    public User5 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User5 newUser5) {
        User5 findedUser5 = user4Repository.findById(id).orElseThrow();
        findedUser5.setName(newUser5.getName());
        findedUser5.setEmails(newUser5.getEmails());
        return user4Repository.save(findedUser5);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자4 삭제", description = "사용자4를 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (user4Repository.existsById(id)) {
            user4Repository.deleteById(id);
        }
    }
}

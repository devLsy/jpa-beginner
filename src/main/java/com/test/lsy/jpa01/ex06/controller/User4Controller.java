package com.test.lsy.jpa01.ex06.controller;

import com.test.lsy.jpa01.ex06.domain.User4;
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
    public User4 save(@RequestBody User4 user4) {
        return user4Repository.save(user4);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자4 조회", description = "사용자4를 단건 조회합니다.")
    public User4 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return user4Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자4 전체 조회", description = "사용자4 전체를 조회합니다.")
    public List<User4> findAll() {
        return user4Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자4 수정", description = "사용자4를 수정합니다.")
    public User4 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User4 newUser4) {
        User4 findedUser4 = user4Repository.findById(id).orElseThrow();
        findedUser4.setName(newUser4.getName());
        findedUser4.setEmails(newUser4.getEmails());
        return user4Repository.save(findedUser4);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자4 삭제", description = "사용자4를 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (user4Repository.existsById(id)) {
            user4Repository.deleteById(id);
        }
    }
}

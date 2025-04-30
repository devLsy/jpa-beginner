package com.test.lsy.jpa01.ex09.controller;

import com.test.lsy.jpa01.ex09.domain.User8;
import com.test.lsy.jpa01.ex09.repository.User8Repository;
import com.test.lsy.jpa01.ex09.service.User8Service;
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
@RequestMapping("/users7")
@Tag(name = "사용자7 API")
public class User8Controller {

    private final User8Service user8Service;
    private final User8Repository user8Repository;

    /**
     * 더티 체킹 용 API
     * @param id
     * @param name
     * @return
     */
    @PutMapping("/{id}/dirty")
    public User8 dirtyCheck(@PathVariable(name = "id") Long id, @RequestParam(name = "name") String name) {
        return user8Service.changeName(id, name);
    }

    @PostMapping
    @Operation(summary = "사용자7 저장", description = "사용자7을 저장합니다.")
    public User8 save(@RequestBody User8 user8) {
        return user8Repository.save(user8);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자7 조회", description = "사용자7을 단건 조회합니다.")
    public User8 findById(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        return user8Repository.findById(id).orElse(null);
    }

    @GetMapping
    @Operation(summary = "사용자7 전체 조회", description = "사용자7 전체를 조회합니다.")
    public List<User8> findAll() {
        return user8Repository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자7 수정", description = "사용자7을 수정합니다.")
    public User8 update(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id, @RequestBody User8 newUser8) {
        User8 findedUser8 = user8Repository.findById(id).orElseThrow();
        findedUser8.setName(newUser8.getName());
        return findedUser8;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자7 삭제", description = "사용자7을 삭제합니다.")
    public void delete(@Parameter(name = "id", description = "아이디") @PathVariable(name = "id") Long id) {
        if (user8Repository.existsById(id)) {
            user8Repository.deleteById(id);
        }
    }
}

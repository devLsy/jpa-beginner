package com.test.lsy.jpa01.ex01.controller;

import com.test.lsy.jpa01.ex01.domain.User;
import com.test.lsy.jpa01.ex01.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "사용자 API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "사용자 저장", description = "새로운 사용자를 저장합니다.")
    @PostMapping
    public void save(@RequestBody User user) {
        userService.saveUser(user);
    }

    @Operation(summary = "특정 사용자 조회", description = "아이디로 특정 사용자를 조회합니다.")
    @GetMapping("/{id}")
    public User getUser(
            @Parameter(description = "조회할 사용자 아이디")
            @PathVariable(name = "id") Long id) {
        return userService.getUser(id);
    }

    @Operation(summary = "전체 사용자 조회", description = "저장된 모든 사용자를 조회합니다.")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "사용자 이름 수정", description = "아이디로 사용자를 찾아 이름을 수정합니다.")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @Operation(summary = "사용자 삭제", description = "아이디로 사용자를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteUser(
            @Parameter(description = "삭제할 사용자 아이디")
            @PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
    }
}

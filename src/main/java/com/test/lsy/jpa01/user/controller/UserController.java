package com.test.lsy.jpa01.user.controller;

import com.test.lsy.jpa01.user.domain.User;
import com.test.lsy.jpa01.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void save(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{email}")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }
}

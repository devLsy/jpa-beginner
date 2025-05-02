package com.test.lsy.jpa01.ex11.controller;

import com.test.lsy.jpa01.ex11.domain.User11;
import com.test.lsy.jpa01.ex11.repository.User11Repository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user11")
@RequiredArgsConstructor
@Tag(name = "사용자11 API")
public class User11Controller {

    private final User11Repository user11Repository;

    @PostMapping
    public User11 save(@RequestBody User11 user11) {
        return user11Repository.save(user11);
    }

    @GetMapping
    public List<User11> findAll() {
        return user11Repository.findAll();
    }
}

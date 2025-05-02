package com.test.lsy.jpa01.ex11.controller;

import com.test.lsy.jpa01.ex11.domain.BestPick;
import com.test.lsy.jpa01.ex11.repository.BestPickRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/best-pick")
@RequiredArgsConstructor
@Tag(name = "best-pick API")
public class BestPickController {

    private final BestPickRepository bestPickRepository;

    @PostMapping
    public BestPick save(@RequestBody BestPick bestPick) {
        return bestPickRepository.save(bestPick);
    }

    @GetMapping
    public List<BestPick> findAll() {
        return bestPickRepository.findAll();
    }
}

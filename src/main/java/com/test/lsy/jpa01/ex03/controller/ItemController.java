package com.test.lsy.jpa01.ex03.controller;

import com.test.lsy.jpa01.ex03.domain.Item;
import com.test.lsy.jpa01.ex03.repository.ItemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/items")
@Tag(name = "아이템 API")
public class ItemController {

    private final ItemRepository itemRepository;

    @Operation(summary = "아이템 저장", description = "아이템을 DB에 저장합니다.")
    @PostMapping
    // 아이디를 개발자가 직접 세팅
    public Item save(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @Operation(summary = "아이템 조회", description = "아이템 단건을 조회합니다.")
    @GetMapping("/{id}")
    public Item get(@PathVariable(name = "id") String id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Operation(summary = "아이템 목록 조회", description = "아이템 목록을 조회합니다.")
    @GetMapping
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Operation(summary = "아이템 수정", description = "아이템을 수정합니다.")
    @PutMapping("/{id}")
    public Item update(@PathVariable(name = "id") String id, @RequestBody Item item) {
        Item findItem = itemRepository.findById(id).orElse(null);
        findItem.setName(item.getName());
        return itemRepository.save(findItem);
    }

    @Operation(summary = "아이템 삭제", description = "아이템을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User Not Found: " + id));
        itemRepository.delete(item);
    }
}

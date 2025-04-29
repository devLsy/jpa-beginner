package com.test.lsy.jpa01.ex03.controller;

import com.test.lsy.jpa01.ex03.domain.Order;
import com.test.lsy.jpa01.ex03.repository.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/orders")
@Tag(name = "주문 API")
public class OrderController {

    private final OrderRepository orderRepository;

    @Operation(summary = "주문 저장", description = "주문을 DB에 저장합니다.")
    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @Operation(summary = "주문 조회", description = "주문 단건을 조회합니다.")
    @GetMapping("/{id}")
    public Order get(@PathVariable(name = "id") Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Operation(summary = "주문 목록 조회", description = "주문 목록을 조회합니다.")
    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Operation(summary = "주문 수정", description = "주문을 수정합니다.")
    @PutMapping("/{id}")
    public Order update(@PathVariable(name = "id") Long id, @RequestBody Order order) {
        Order findedOrder = orderRepository.findById(id).orElse(null);
        findedOrder.setDescription(order.getDescription());
        return orderRepository.save(findedOrder);
    }

    @Operation(summary = "주문 삭제", description = "주문을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order Not Found: " + id));
        orderRepository.delete(order);
    }
}

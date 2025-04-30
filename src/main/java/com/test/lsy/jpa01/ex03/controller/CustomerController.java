package com.test.lsy.jpa01.ex03.controller;

import com.test.lsy.jpa01.ex03.domain.Customer;
import com.test.lsy.jpa01.ex03.repository.CustomerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customers")
@Tag(name = "Customer API")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Operation(summary = "고객 저장", description = "고객을 DB에 저장합니다.")
    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @Operation(summary = "고객 단건 조회", description = "고객 단건 조회합니다.")
    @GetMapping("/{id}")
    public Customer getById(@PathVariable(name = "id") Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Operation(summary = "고객 목록 조회", description = "고객 목록을 조회합니다.")
    @GetMapping
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Operation(summary = "고객 수정", description = "고객을 수정합니다.")
    @PutMapping("/{id}")
    public Customer update(@PathVariable(name = "id") Long id, @RequestBody Customer customer) {
        Customer findCustomer = customerRepository.findById(id).orElse(null);
        findCustomer.setName(customer.getName());
        return findCustomer;
    }

    @Operation(summary = "고객 삭제", description = "고객을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer Not Found: " + id));
        customerRepository.delete(customer);
    }
}

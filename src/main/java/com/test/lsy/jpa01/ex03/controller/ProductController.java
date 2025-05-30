package com.test.lsy.jpa01.ex03.controller;

import com.test.lsy.jpa01.ex03.domain.Product;
import com.test.lsy.jpa01.ex03.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product")
@Tag(name = "상품 API")
public class ProductController {

    private final ProductRepository productRepository;

    @Operation(summary = "상품 저장", description = "상품을 DB에 저장합니다.")
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @Operation(summary = "상품 단건 조회", description = "상품 단건 조회합니다.")
    @GetMapping("/{id}")
    public Product getById(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Operation(summary = "상품 목록 조회", description = "상품 목록을 조회합니다.")
    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Operation(summary = "상품 수정", description = "상품을 수정합니다.")
    @PutMapping("/{id}")
    public Product update(@PathVariable(name = "id") Long id, @RequestBody Product product) {
        Product findProduct = productRepository.findById(id).orElse(null);
        findProduct.setName(product.getName());
        return findProduct;
    }

    @Operation(summary = "상품 삭제", description = "상품을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer Not Found: " + id));
        productRepository.delete(product);
    }
}

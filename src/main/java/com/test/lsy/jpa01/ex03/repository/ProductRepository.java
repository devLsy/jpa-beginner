package com.test.lsy.jpa01.ex03.repository;

import com.test.lsy.jpa01.ex03.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

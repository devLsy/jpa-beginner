package com.test.lsy.jpa01.ex03.repository;

import com.test.lsy.jpa01.ex03.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package com.test.lsy.jpa01.ex03.repository;

import com.test.lsy.jpa01.ex03.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

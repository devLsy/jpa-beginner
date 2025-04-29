package com.test.lsy.jpa01.ex03.repository;

import com.test.lsy.jpa01.ex03.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}

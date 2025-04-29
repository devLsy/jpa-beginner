package com.test.lsy.jpa01.ex03.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "product")
@NoArgsConstructor @AllArgsConstructor
public class Product {

    // 식별자 자동 세팅
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
}

package com.test.lsy.jpa01.ex12.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sight_info")
@Getter @Setter
@NoArgsConstructor
public class Sight {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Sight(String name) {
        this.name = name;
    }
}

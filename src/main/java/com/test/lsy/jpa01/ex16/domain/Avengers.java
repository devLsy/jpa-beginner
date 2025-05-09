package com.test.lsy.jpa01.ex16.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "avengers")
@Getter @Setter
@NoArgsConstructor
public class Avengers {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<MarvelHero> marvelHeroes = new HashSet<>();

    public Avengers(String name, Set<MarvelHero> marvelHeroes) {
        this.name = name;
        this.marvelHeroes = marvelHeroes;
    }
}

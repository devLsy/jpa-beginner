package com.test.lsy.jpa01.ex16.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marvel_heros")
@Getter @Setter
@NoArgsConstructor
public class MarvelHero {
    @Id @GeneratedValue
    @Schema(hidden = true)
    private Long id;
    private String heroCode;
    private String name;

    public MarvelHero(String heroCode, String name) {
        this.heroCode = heroCode;
        this.name = name;
    }
}

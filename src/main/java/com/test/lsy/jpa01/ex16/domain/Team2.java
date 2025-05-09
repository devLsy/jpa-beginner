package com.test.lsy.jpa01.ex16.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team_info2")
@Getter @Setter
@NoArgsConstructor
public class Team2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Player2> player2s = new HashSet<>();

    public Team2(String name, Set<Player2> player2s) {
        this.name = name;
        this.player2s = player2s;
    }
}

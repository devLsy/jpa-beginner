package com.test.lsy.jpa01.ex13.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_info")
@Getter @Setter
@NoArgsConstructor
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }
}

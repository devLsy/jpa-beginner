package com.test.lsy.jpa01.ex16.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_info2")
@Getter @Setter
@NoArgsConstructor
public class Player2 {
    @Id @GeneratedValue
    private Long id;
    private String playerCode;
    private String name;

    public Player2(String playerCode, String name) {
        this.playerCode = playerCode;
        this.name = name;
    }
}

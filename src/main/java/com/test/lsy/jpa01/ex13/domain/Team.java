package com.test.lsy.jpa01.ex13.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team_info")
@Getter @Setter
@NoArgsConstructor
// Team(1) : Player(N) 단방향 관계 매핑
// Player 입장에서는 Team을 모름
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id")   // player 테이블의 FK 컬럼
    private Set<Player> players = new HashSet<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }
}

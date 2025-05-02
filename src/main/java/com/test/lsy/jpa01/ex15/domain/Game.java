package com.test.lsy.jpa01.ex15.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "game_info")
@Getter @Setter
@NoArgsConstructor
// Game(1) : MemberInfo(N) 단방향 관계 매핑
// MemberInfo 입장에서는 Game을 모름
public class Game {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)   // Game 엔티티 insert 시 MemberInfo도 같이 insert
    @JoinColumn(name = "game_id")     // member_info 테이블에 fk 생성
    @MapKey(name = "roleName")      // 키를 member_info 테이블의 roleName을 지정
    private Map<String, MemberInfo> members = new HashMap<>();

    public Game(String name) {
        this.name = name;
    }
}

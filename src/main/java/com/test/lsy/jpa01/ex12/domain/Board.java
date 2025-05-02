package com.test.lsy.jpa01.ex12.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board_info")
@Getter @Setter
@NoArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String content;

    public Board(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}

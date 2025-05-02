package com.test.lsy.jpa01.ex01.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    private String name;
    @Column(name = "create_date")
    private String createDate;

    public User(String name, String createDate) {
        this.name = name;
        this.createDate = createDate;
    }
}

package com.test.lsy.jpa01.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "create_date")
    private String createDate;

    public User(String name, String createDate) {
        this.name = name;
        this.createDate = createDate;
    }
}

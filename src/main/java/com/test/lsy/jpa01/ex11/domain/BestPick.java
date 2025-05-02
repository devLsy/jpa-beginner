package com.test.lsy.jpa01.ex11.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "best_pick")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BestPick {

    @Id
    @Column(name = "user_email")
    private String userEmail;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "user_email")
    private User11 user;

    @Column(length = 100)
    private String title;
}

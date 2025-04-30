package com.test.lsy.jpa01.ex10.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "membership_card")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MembershipCard {
    @Id
    @Column(name = "card_no", length = 50)
    private String cardNumber;

    @OneToOne
    @JoinColumn(name = "user_email") // FK 컬럼
    private User10 owner;
}

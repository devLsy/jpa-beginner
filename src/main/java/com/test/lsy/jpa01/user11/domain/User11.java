package com.test.lsy.jpa01.user11.domain;

import com.test.lsy.jpa01.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user11")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User11 extends BaseTimeEntity {

    @Id
    @Column(length = 50)
    private String email;
}

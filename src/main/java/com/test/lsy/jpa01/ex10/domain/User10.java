package com.test.lsy.jpa01.ex10.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "user10")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User10 extends BaseTimeEntity {
    @Id
    @Column(length = 50, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    private String name;
}

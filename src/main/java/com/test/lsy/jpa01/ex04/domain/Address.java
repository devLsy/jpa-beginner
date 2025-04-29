package com.test.lsy.jpa01.ex04.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

// 값 타입
@Embeddable
@Getter @Setter
public class Address {
    private String addr1;
    private String addr2;
    private String zipcode;
}

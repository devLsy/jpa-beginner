package com.test.lsy.jpa01.ex04.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

// 값 타입
@Embeddable
@Getter
@RequiredArgsConstructor
public class Address {

    private final String addr1;
    private final String addr2;
    private final String zipcode;

    protected Address() {
        this.addr1 = null;
        this.addr2 = null;
        this.zipcode = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addr1, address.addr1) && Objects.equals(addr2, address.addr2) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addr1, addr2, zipcode);
    }
}

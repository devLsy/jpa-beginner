package com.test.lsy.jpa01.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
public class BaseTimeEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "create_date", updatable = false)
    protected LocalDateTime createDate;

    @PrePersist
    public void onPrePersist() {
        this.createDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }
}

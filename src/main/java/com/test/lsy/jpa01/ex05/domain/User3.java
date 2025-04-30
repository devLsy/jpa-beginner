package com.test.lsy.jpa01.ex05.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users3")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@SecondaryTable(
        name = "user3_details",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "user3_id")
)
public class User3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    private String name;

    // user_details 테이블의 컬럼
    // @SecondaryTable에 저장되는 필드들은 항상 즉시 로딩(EAGER)으로 강제됨(연관관계가 아님)
    @Column(table = "user3_details")
    private String address;

    @Column(table = "user3_details")
    private String phone;

}

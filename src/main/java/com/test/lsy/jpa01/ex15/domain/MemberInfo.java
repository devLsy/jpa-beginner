package com.test.lsy.jpa01.ex15.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_info")
@Getter @Setter
@NoArgsConstructor
public class MemberInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;
    private String roleName;  // Map의 Key가 될 필드

    public MemberInfo(String name, String roleName) {
        this.name = name;
        this.roleName = roleName;
    }
}

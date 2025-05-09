package com.test.lsy.jpa01.ex17.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tv_program")
@Getter @Setter
@NoArgsConstructor
public class TvProgram {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;
}

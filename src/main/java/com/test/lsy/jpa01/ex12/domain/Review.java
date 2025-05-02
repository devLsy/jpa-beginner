package com.test.lsy.jpa01.ex12.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review_info")
@Getter @Setter
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sight_id") // FK 컬럼 이름 명시
    private Sight sight;

    private int grade;
    private String comment;

    public Review(int grade, String comment) {
        this.grade = grade;
        this.comment = comment;
    }
}

package com.test.lsy.jpa01.ex14.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "survey_info")
@Getter @Setter
@NoArgsConstructor
// Survey(1) : Question(N) 단방향 관계 매핑
// Question 입장에서는 Survey을 모름
public class Survey {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "survey_id")     // question_info 테이블에 fk 생성
    private List<Question> questions = new ArrayList<>();
    
    public Survey(String name) {
        this.name = name;
    }
}

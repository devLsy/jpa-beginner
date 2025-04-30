package com.test.lsy.jpa01.ex08.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name = "user7")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User7 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "user7_tags", joinColumns = @JoinColumn(name = "user7_id"))
    @MapKeyColumn(name = "tag_name")
//    @Column(name = "tag_description")
//    private Map<String, String> tags;
    // 값 타입
    private Map<String, PropValue> props;
}

package com.test.lsy.jpa01.ex17.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review_info2")
@Getter @Setter
@NoArgsConstructor
public class Review2 {
    @Id @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Column(name = "hotel_id")
    private String hotelId;

    private String content;
}

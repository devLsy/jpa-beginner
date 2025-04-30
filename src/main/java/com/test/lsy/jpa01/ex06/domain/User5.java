package com.test.lsy.jpa01.ex06.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "user4")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "user4_emails",
            joinColumns = @JoinColumn(name = "user4_id")
    )
    @Column(name = "email")
    private Set<String> emails;
}

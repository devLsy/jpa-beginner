package com.test.lsy.jpa01.ex07.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user5")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "user5_hobbies", joinColumns = @JoinColumn(name = "user5_id"))
    @OrderColumn(name = "hobby_order")
    @Column(name = "hobby")
    private List<String> hobbies;

    @ElementCollection
    @CollectionTable(name = "user5_addresses", joinColumns = @JoinColumn(name = "user5_id"))
    @OrderColumn(name = "address_order")
    private List<Address5> address5s;
}

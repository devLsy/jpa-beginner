package com.test.lsy.jpa01.ex03.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "order_info")
@NoArgsConstructor @AllArgsConstructor
public class Order {
    
    // 테이블 방식(DB에 별도로 키 생성용 테이블을 만들어 id를 관리하는 방식)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "order_gen")
    @TableGenerator(
            name = "order_gen",
            table = "id_generator",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "order_id",
            allocationSize = 1
    )
    private Long id;
    private String description;
}

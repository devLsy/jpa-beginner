package com.test.lsy.jpa01.ex03.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "item_info")
public class Item {
    
    // 식별자 개발자가 직접 아이디 세팅
    @Id
    private String id;
    private String name;
    
    // 저장 전에 직접 id 지정해야 함
}

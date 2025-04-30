package com.test.lsy.jpa01.ex09.service;

import com.test.lsy.jpa01.ex09.domain.User8;
import com.test.lsy.jpa01.ex09.repository.User8Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class User8Service {

    private final User8Repository user8Repository;

    @Transactional
    public User8 changeName(Long id, String newName) {
        log.info("user 엔티티 조회하기 전");
        // 영속성 컨텍스트가 관리 중인 엔티티 → 변경 감지 가능
        User8 user = user8Repository.findById(id).orElseThrow();
        log.info("user 엔티티 조회 완료");

        log.info("🟡 조회된 사용자 - id: {}, name: {}, phone: {}", user.getId(), user.getName(), user.getPhone());
        user.setName(newName);
        log.info("🟢 변경된 사용자 - id: {}, name: {}, phone: {}", user.getId(), user.getName(), user.getPhone());
        // save() 호출 없이 트랜잭션 커밋 시점에 Hibernate가 변경 감지 후 UPDATE 실행
        log.info("🟣 트랜잭션 종료 시점 직전 - 실제 update 쿼리는 이 이후에 나감");
        // 주의: 수정 시에는 save() 호출하지 말 것
        // 이미 영속 상태인데 merge()가 실행되면 의도치 않은 쿼리 또는 객체 복제 발생 가능
        return user;
    }
}

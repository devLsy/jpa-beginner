package com.test.lsy.jpa01.ex10.controller;

import com.test.lsy.jpa01.ex10.domain.MembershipCard;
import com.test.lsy.jpa01.ex10.repository.MembershipCardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Tag(name = "멤버십 카드 API")
@Slf4j
public class MembershipCardController {

    private final MembershipCardRepository membershipCardRepository;

    @PostMapping
    @Operation(summary = "멤버십카드 저장", description = "멤버십카드를 저장합니다.")
    public MembershipCard save(@RequestBody MembershipCard membershipCard) {
        return membershipCardRepository.save(membershipCard);
    }

    @GetMapping
    @Operation(summary = "멤버십카드 전체 조회", description = "멤버십카드 전체를 조회합니다.")
    public List<MembershipCard> findAll() {
//    public void findAll() {
//        return membershipCardRepository.findAll();
        return membershipCardRepository.findAllWithOwner();
//        membershipCardRepository.findAll();
//        log.info("list size : {}", list.size());
    }

    /**
     * N + 1 테스트용 API
     */
    @GetMapping("/test-n-plus-1")
    public void testNPlus1() {
        List<MembershipCard> cards = membershipCardRepository.findAll();

        int size = 0;
        for (MembershipCard card : cards) {
            // 이 줄에서 owner 필드가 Lazy 로딩되어 SELECT 쿼리가 매번 실행됨
            log.info("카드번호: {}, 사용자명 : {}", card.getCardNumber(), card.getOwner().getName());
            size++;
        }
        log.info("N : {}", size);
    }
}
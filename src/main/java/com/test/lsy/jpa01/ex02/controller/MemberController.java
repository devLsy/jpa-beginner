package com.test.lsy.jpa01.ex02.controller;

import com.test.lsy.jpa01.ex02.domain.Member;
import com.test.lsy.jpa01.ex02.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
@Tag(name = "멤버 API")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 저장", description = "회원정보를 저장합니다.")
    @PostMapping
    public Member saveMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @Operation(summary = "회원 조회", description = "ID로 회원을 조회합니다.")
    @GetMapping("/{id}")
    public Member getMember(@PathVariable(name = "id") Long id) {
        return memberService.getMember(id);
    }

    @Operation(summary = "회원 전체 조회", description = "모든 회원을 조회합니다.")
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @Operation(summary = "회원 수정", description = "ID로 회원을 찾아 정보를 수정합니다.")
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable(name = "id") Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @Operation(summary = "회원 삭제", description = "아이디로 회원을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteMember(
            @Parameter(description = "삭제할 사용자 아이디")
            @PathVariable(name = "id") Long id) {
        memberService.deleteMember(id);
    }
}

package com.test.lsy.jpa01.ex02.member.service;

import com.test.lsy.jpa01.ex02.member.domain.Member;
import com.test.lsy.jpa01.ex02.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 멤버 등록
     * @param member
     * @return
     */
    public Member saveMember(Member member) {
        Member newMember = new Member();
        newMember.setName(member.getName());
        newMember.setStatus(member.getStatus());
        return memberRepository.save(newMember);
    }

    /**
     * 멤버 단건 조회
     * @param id
     * @return
     */
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + id));
    }

    /**
     * 멤버 전체 조회
     * @return
     */
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    /**
     * 멤버 수정
     * @param member
     * @return
     */
    public Member updateMember(Member member) {
        Member findedMember = getMember(member.getId());
        findedMember.setName(member.getName());
        findedMember.setStatus(member.getStatus());
        return memberRepository.save(findedMember);
    }

    /**
     * 멤버 삭제
     * @param id
     */
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

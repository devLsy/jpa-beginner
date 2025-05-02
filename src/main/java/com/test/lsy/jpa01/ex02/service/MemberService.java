package com.test.lsy.jpa01.ex02.service;

import com.test.lsy.jpa01.ex02.domain.Member;
import com.test.lsy.jpa01.ex02.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member saveMember(Member member) {
        Member newMember = new Member();
        newMember.setName(member.getName());
        newMember.setStatus(member.getStatus());
        return memberRepository.save(newMember);
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + id));
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public Member updateMember(Long id, Member member) {
        Member findedMember = getMember(id);
        findedMember.setName(member.getName());
        findedMember.setStatus(member.getStatus());
        return findedMember;
    }
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

package com.KNUTCLUB.service;

import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.MemberRepository;
import com.KNUTCLUB.repository.dto.ResetPwDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void resetPw(String studentId, ResetPwDto updateParam) {
        Member findMember = memberRepository.findById(studentId).orElseThrow();
        findMember.setPassword(updateParam.getPassword());
    }

    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    public String login(String id, String pw) {
        Member login = memberRepository.findById(id).orElseThrow();
        if (login.getPassword().equals(pw)) {
            return "Success";
        }
        return "Failed";
    }
}

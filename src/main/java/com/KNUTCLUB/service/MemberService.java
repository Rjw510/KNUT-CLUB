package com.KNUTCLUB.service;

import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

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

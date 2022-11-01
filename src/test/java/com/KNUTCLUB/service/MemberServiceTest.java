package com.KNUTCLUB.service;

import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.MemberRepository;
import com.KNUTCLUB.repository.dto.JoinDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void save() {
        JoinDto birthDto = new JoinDto("1997", "05", "10");
        String birth = birthDto.getBirth_yy() + "." + birthDto.getBirth_mm() + "." + birthDto.getBirth_dd();
        Member member = new Member("1111111","1234","test","컴퓨터공학과",birth,"남성",
                                     "010-1111-1111", "대구광역시 북구 동천로","24길 12");

        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getStudentId()).get();
        assertThat(findMember).isEqualTo(savedMember);
    }
}
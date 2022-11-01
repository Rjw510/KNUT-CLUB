package com.KNUTCLUB.repository;

import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.dto.ResetPwDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepository {

    private final EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public void resetPw(String studentId, ResetPwDto updateParam) {
        Member findMember = em.find(Member.class, studentId);

        if (updateParam.getPassword().equals(updateParam.getPassword_2())) {
            findMember.setPassword(updateParam.getPassword());
        }
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findById(String id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
}

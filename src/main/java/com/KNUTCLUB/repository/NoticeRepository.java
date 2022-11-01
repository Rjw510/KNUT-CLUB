package com.KNUTCLUB.repository;

import com.KNUTCLUB.domain.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class NoticeRepository {

    private final EntityManager em;

    public NoticeRepository(EntityManager em) {
        this.em = em;
    }

    public Notice save(Notice notice) {
        em.persist(notice);
        return notice;
    }

    public Optional<Notice> findById(Long id) {
        Notice notice = em.find(Notice.class, id);
        return Optional.ofNullable(notice);
    }

}

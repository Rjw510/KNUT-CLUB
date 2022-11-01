package com.KNUTCLUB.repository;

import com.KNUTCLUB.domain.Admin;
import com.KNUTCLUB.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@Transactional
public class AdminRepository {

    private final EntityManager em;

    public AdminRepository(EntityManager em) {
        this.em = em;
    }

    public Admin save(Admin admin) {
        em.persist(admin);
        return admin;
    }

    public Optional<Admin> findById(String id) {
        Admin admin = em.find(Admin.class, id);
        return Optional.ofNullable(admin);
    }
}

package com.KNUTCLUB.service;

import com.KNUTCLUB.domain.Admin;
import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> findById(String id) {
        return adminRepository.findById(id);
    }

    public String login(String id, String pw) {
        Admin login = adminRepository.findById(id).orElseThrow();
        if (login.getPassword().equals(pw)) {
            return "Success";
        }
        return "Failed";
    }
}

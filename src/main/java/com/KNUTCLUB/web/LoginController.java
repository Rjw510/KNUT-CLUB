package com.KNUTCLUB.web;

import com.KNUTCLUB.domain.Admin;
import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.service.AdminService;
import com.KNUTCLUB.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final AdminService adminService;

    @GetMapping("/login")
    public String goLogin(Model model) {

        model.addAttribute("login", new Member());
        model.addAttribute("adminLogin", new Admin());

        return "/sign/login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("login") Member member) {

        String status = memberService.login(member.getStudentId(), member.getPassword());

        log.info("회원 로그인 -> id : {}, pw : {}, status : {}", member.getStudentId(), member.getPassword(), status);

        if (status.equals("Success")) {

            return "index";
        }

        return "/sign/login";
    }

    @PostMapping("/adminLogin")
    public String doAdminLogin(@ModelAttribute("adminLogin") Admin admin) {

        String status = adminService.login(admin.getClubId(), admin.getPassword());

        log.info("관리자 로그인 -> id : {}, pw : {}, status : {}", admin.getClubId(), admin.getPassword(), status);

        if (status.equals("Success")) {

            return "index";
        }

        return "/sign/login";
    }


}

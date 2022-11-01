package com.KNUTCLUB.web;

import com.KNUTCLUB.domain.Admin;
import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.service.AdminService;
import com.KNUTCLUB.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final AdminService adminService;

    @GetMapping("/sign/login")
    public String goLogin(Model model) {

        model.addAttribute("login", new Member());
        model.addAttribute("adminLogin", new Admin());

        return "/sign/login";
    }

    @PostMapping("/sign/login")
    public String doLogin(@ModelAttribute("login") Member member,
                          HttpSession session) {

        String status = memberService.login(member.getStudentId(), member.getPassword());

        session.setAttribute("id", member.getStudentId());
        session.setAttribute("name", member.getName());
//        session.setAttribute("club", member.getClub());
        session.setAttribute("grade", "member");

        log.info("회원 로그인 -> id : {}, pw : {}, status : {}", member.getStudentId(), member.getPassword(), status);

        if (status.equals("Success")) {

            return "index";
        }

        return "/sign/login";
    }

    @PostMapping("/sign/login/admin")
    public String doAdminLogin(@ModelAttribute("adminLogin") Admin admin,
                               HttpSession session) {

        String status = adminService.login(admin.getClubId(), admin.getPassword());

        session.setAttribute("id", admin.getClubId());
        session.setAttribute("grade", "admin");

        log.info("관리자 로그인 -> id : {}, pw : {}, status : {}", admin.getClubId(), admin.getPassword(), status);

        if (status.equals("Success")) {

            return "index";
        }

        return "/sign/login";
    }

    @GetMapping("/sign/logout")
    public String logout(HttpSession session) {
        log.info("로그아웃");
        session.invalidate();
        return "redirect:/index";
    }
}

package com.KNUTCLUB.web;

import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String goLogin(Model model) {
        model.addAttribute("login", new Member());
        return "/sign/login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("login") Member member) {

        String status = memberService.login(member.getStudentId(), member.getPassword());

        log.info("id : {}, pw : {}, status : {}", member.getStudentId(), member.getPassword(), status);

        if (status.equals("Success")) {

            return "index";
        }

        return "/sign/login";
    }
}

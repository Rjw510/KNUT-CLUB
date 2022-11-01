package com.KNUTCLUB.web;

import com.KNUTCLUB.domain.Admin;
import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.dto.JoinDto;
import com.KNUTCLUB.service.AdminService;
import com.KNUTCLUB.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;
    private final AdminService adminService;

//    @GetMapping("/sign/join")
//    public String goJoin(Model model) {
//        model.addAttribute("join", new Member());
//        return "/sign/join";
//    }

    @PostMapping("/sign/join")
    public String doJoin(@ModelAttribute("join") Member member,
                         @ModelAttribute("birth") JoinDto dto) {

        String birth = dto.getBirth_yy() + "." + dto.getBirth_mm() + "." + dto.getBirth_dd();
        member.setBirth(birth);
        memberService.save(member);

        return "/index";
    }

    @PostMapping("/sign/join/admin")
    public String doJoin(@ModelAttribute("join") Admin admin,
                         @ModelAttribute("birth") JoinDto dto) {

        adminService.save(admin);

        return "/index";
    }
}

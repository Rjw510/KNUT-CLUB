package com.KNUTCLUB.web;

import com.KNUTCLUB.domain.Admin;
import com.KNUTCLUB.domain.Member;
import com.KNUTCLUB.repository.dto.JoinDto;
import com.KNUTCLUB.repository.dto.CheckDto;
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
public class CheckController {

    @GetMapping("/sign/check")
    public String goCheck(Model model) {
        model.addAttribute("chk", new CheckDto());
        return "/sign/check";
    }

    @GetMapping("/sign/check/admin")
    public String goCheckAdmin(Model model) {
        model.addAttribute("chk", new CheckDto());
        return "/sign/checkAdmin";
    }

    @PostMapping("/sign/check")
    public String doCheck(@ModelAttribute("chk") CheckDto chk,
                          Model model) {

        Boolean chk_1 = chk.getChk_1();
        Boolean chk_2 = chk.getChk_2();

        if (chk_1==true && chk_2==true) {
            model.addAttribute("join", new Member());
            model.addAttribute("birth", new JoinDto());
            return "/sign/join";
        }
        return "/sign/check";
    }

    @PostMapping("/sign/check/admin")
    public String doCheckAdmin(@ModelAttribute("chk") CheckDto chk,
                          Model model) {

        Boolean chk_1 = chk.getChk_1();
        Boolean chk_2 = chk.getChk_2();

        if (chk_1==true && chk_2==true) {
            model.addAttribute("join", new Admin());
            model.addAttribute("birth", new JoinDto());
            return "/sign/joinAdmin";
        }
        return "sign/checkAdmin";
    }
}

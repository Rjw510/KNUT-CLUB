package com.KNUTCLUB.web;

import com.KNUTCLUB.repository.dto.FindPwDto;
import com.KNUTCLUB.repository.dto.ResetPwDto;
import com.KNUTCLUB.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ResetPwController {

    private final MemberService memberService;

    @GetMapping("/sign/findPw")
    public String goFindPw(Model model) {

        model.addAttribute("findPw", new FindPwDto());
        return "/sign/findPw";
    }

    @PostMapping("/sign/findPw")
    public String doFindPw(@ModelAttribute("findPw") FindPwDto dto,
                           Model model) {

        log.info("비밀번호 재설정 -> 학번 : {}", dto.getStudentId());

        model.addAttribute("studentId", dto.getStudentId());
        model.addAttribute("resetPw", new ResetPwDto());
        return "/sign/resetPw";
    }

    @PostMapping("/sign/resetPw")
    public String doResetPw(@ModelAttribute("resetPw") ResetPwDto dto,
                            @RequestParam("studentId") String studentId) {

        memberService.resetPw(studentId, dto);

        log.info("비밀번호 재설정 -> 변경된 비밀번호 : {}", dto.getPassword());

        return "redirect:/sign/login";
    }
}

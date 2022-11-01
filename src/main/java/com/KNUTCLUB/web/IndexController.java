package com.KNUTCLUB.web;

import com.KNUTCLUB.domain.Notice;
import com.KNUTCLUB.repository.dto.NoticeDto;
import com.KNUTCLUB.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NoticeService noticeService;

    @GetMapping("/index")
    public String goIndex(@ModelAttribute("noticeSearch")NoticeDto dto,
                          Model model) {

        List<Notice> noticeList = noticeService.getNoticeList(dto);

        model.addAttribute("noticeList", noticeList);
        return "/index";
    }
}

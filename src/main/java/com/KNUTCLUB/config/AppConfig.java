//package com.KNUTCLUB.config;
//
//import com.KNUTCLUB.repository.MemberRepository;
//import com.KNUTCLUB.repository.NoticeQueryRepository;
//import com.KNUTCLUB.repository.NoticeRepository;
//import com.KNUTCLUB.service.MemberService;
//import com.KNUTCLUB.service.NoticeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//
//@Configuration
//@RequiredArgsConstructor
//public class AppConfig {
//
//    private final EntityManager em;
//    private final MemberRepository memberRepository;
//    private final NoticeRepository noticeRepository;
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//
//    @Bean
//    public NoticeService noticeService() {
//        return new NoticeService(noticeRepository, noticeQueryRepository());
//    }
//
//    @Bean
//    public NoticeQueryRepository noticeQueryRepository() {
//        return new NoticeQueryRepository(em);
//    }
//}

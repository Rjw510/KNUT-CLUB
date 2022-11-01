package com.KNUTCLUB.service;

import com.KNUTCLUB.domain.Notice;
import com.KNUTCLUB.repository.dto.NoticeDto;
import com.KNUTCLUB.repository.NoticeQueryRepository;
import com.KNUTCLUB.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeQueryRepository noticeQueryRepository;

    public Notice save(Notice notice) {
        return noticeRepository.save(notice);
    }

    public Optional<Notice> findById(Long id) {
        return noticeRepository.findById(id);
    }

    public List<Notice> getNoticeList(NoticeDto dto) {
        return noticeQueryRepository.findAll(dto);
    }

}

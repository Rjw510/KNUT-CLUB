package com.KNUTCLUB.repository;

import com.KNUTCLUB.domain.Notice;
import com.KNUTCLUB.repository.dto.NoticeDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.KNUTCLUB.domain.QNotice.*;

@Repository
@Transactional
public class NoticeQueryRepository {

    private final JPAQueryFactory query;

    public NoticeQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Notice> findAll(NoticeDto dto) {
        return query.select(notice)
                .from(notice)
                .where(likeNoticeTitle(dto.getTitle()),
                        likeNoticeWriter(dto.getWriter()))
                .fetch();
    }

    private BooleanExpression likeNoticeTitle(String title) {
        if (StringUtils.hasText(title)) {
            return notice.title.like("%" + title + "%");
        }
        return null;
    }

    private BooleanExpression likeNoticeWriter(String writer) {
        if (StringUtils.hasText(writer)) {
            return notice.writer.like("%" + writer + "%");
        }
        return null;
    }
}

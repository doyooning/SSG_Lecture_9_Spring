package com.ssg.springboard.service;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;

import java.util.List;

public interface ReplyService {
    List<ReplyVO> getListByBno(Criteria cri, Long bno);
    ReplyVO get(Long rno);
    int getTotal(Long bno);
    boolean modify(ReplyVO vo);
    boolean remove(Long rno);
    Long register(ReplyVO vo);
}

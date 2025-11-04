package com.ssg.springboard.service;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.mappers.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {
    private final ReplyMapper replyMapper;

    public List<ReplyVO> getListByBno(Criteria cri, Long bno) {
        return replyMapper.getReplyList(cri, bno);
    }

    public ReplyVO get(Long rno) {
        return replyMapper.selectOne(rno);
    }

    public boolean modify(ReplyVO vo){
        return replyMapper.updateOne(vo) == 1;
    }

    public boolean remove(Long rno) {
        return replyMapper.deleteOne(rno) == 1;
    }

    public Long register(ReplyVO vo){
        return replyMapper.insert(vo);
    }

    public int getTotal(Long bno) {
        return replyMapper.getTotal(bno);
    }
}

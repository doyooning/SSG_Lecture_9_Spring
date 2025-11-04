package com.ssg.springboard.controller;

import com.ssg.springboard.domain.BoardVO;
import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.PageDTO;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
@Log4j2
public class ReplyController {
//    @GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String sample() {
//
//        return "HELLO";
////        return Map.of("value1", "AAA", "value2", "BBB");
//    }

    private final ReplyService replyService;

    @GetMapping(value = "/list/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReplyVO> list(@ModelAttribute("cri") Criteria criteria,
                     @PathVariable(name = "bno") Long bno,
                     Model model){
        log.info("list................");
        log.info("criteria: " + criteria);

        List<ReplyVO> list = replyService.getListByBno(criteria, bno);

        log.info(list);
        log.info("리스트 출력");

        model.addAttribute("list", list);

        PageDTO pageDTO = new PageDTO(criteria, replyService.getTotal(bno));

        model.addAttribute("pageMaker", pageDTO);

        return list;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReplyVO registerPost(ReplyVO replyVO, RedirectAttributes rttr) {

        log.info("replyVO: " + replyVO);

        Long bno = replyService.register(replyVO);

        rttr.addFlashAttribute("result: ", bno);

        return replyVO;
    }

    @GetMapping(value = "/reply/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReplyVO read(
            @PathVariable(name = "rno") Long rno,
            Model model) {

        log.info("rno: " + rno);

        ReplyVO replyVO = replyService.get(rno);

        log.info("replyVO: " + replyVO);

        model.addAttribute("vo", replyVO);

        return replyVO;
    }

    @DeleteMapping("/reply/{rno}")
    public String remove(@PathVariable(name = "rno") Long rno) {
        log.info("rno: " + rno);

        return replyService.remove(rno) ? "삭제완료" : "error";
    }

    @PutMapping("/reply/{rno}")
    public String modify(@PathVariable(name = "rno") Long rno, ReplyVO replyVO) {
        log.info("rno: " + rno);

        log.info("replyVO: " + replyVO);

        return replyService.modify(replyVO) ? "수정완료" : "error";
    }



}

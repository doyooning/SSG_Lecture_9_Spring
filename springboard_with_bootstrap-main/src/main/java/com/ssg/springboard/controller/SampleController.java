package com.ssg.springboard.controller;

import com.ssg.springboard.dto.SampleDTO;
import com.ssg.springboard.dto.SampleDTOList;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping(value = "/sample")
public class SampleController {
    @GetMapping("/basic")
    public void basic() {
        log.info("basic 요청");
    }

    @GetMapping("/ex1")
    public void ex1(@RequestParam("name") String name,
                    @RequestParam(value = "age", required = false, defaultValue = "20") int age) {
        log.info("ex1 요청 : " + name + ", " + age);
    }

    @GetMapping("/ex02Bean")
    public void ex02Bean(SampleDTOList sampleDTOList) {
        log.info(sampleDTOList);
    }
}

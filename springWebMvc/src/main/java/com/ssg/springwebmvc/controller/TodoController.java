package com.ssg.springwebmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list() {
        log.info("Todo list Controller!");
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping(value = "/register")
    public void register() {
        log.info("Register Controller!");
    }

    @PostMapping("/register") // 스프링 버전 4부터 지원 시작
    public void registerPost() {
        log.info("Register Controller!");

    }
}

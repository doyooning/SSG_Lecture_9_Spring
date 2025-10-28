package com.ssg.springwebmvc.controller;

import com.ssg.springwebmvc.dto.TodoDTO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller // 해당 클래스가 스프링MVC에서 컨트롤러 역할 + 빈 등록
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello !");
    }

    @GetMapping("/ex01")
    public void ex01(String name, int age) {
        log.info("Ex01 Controller!");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex02")
    public void ex02(@RequestParam(name="name", defaultValue="asdfasdf") String name,
                     @RequestParam(name="age", defaultValue="10") int age) {
        log.info("Ex02 Controller!");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex03")
    public void ex03(LocalDate dueDate) {
        log.info("Ex03 Controller!");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex04")
    public void ex04(Model model) {
        log.info("Ex04 Model Parameter!");
        model.addAttribute("message", "Hello World !");
    }

    @GetMapping("/ex04_1")
    public void ex04(TodoDTO todoDTO, Model model) {
        log.info("todoDTO");
        model.addAttribute("todoDTO", todoDTO);
    }
}

package com.ssg.board.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
- **GET**: 작성 폼(JSP) : 제목/작성자/내용
- **POST**: 서버 검증(제목 2~200, 작성자 1~50, 내용 5자 이상, 비밀번호 4~20)
- insert 성공 → **PRG 패턴**으로 `/posts` 리다이렉트
* */

@WebServlet(name = "PostNewFormServlet", value = "/posts/new")
@Log4j2
public class PostNewFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET /posts/new → PostNewFormServlet
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

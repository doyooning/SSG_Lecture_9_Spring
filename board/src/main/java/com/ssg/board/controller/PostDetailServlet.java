package com.ssg.board.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

/*
- id로 단건 조회
- 상세에서 **수정/삭제 버튼** 제공.
* */

@WebServlet(name = "PostDetailServlet", value = "/posts/view")
@Log4j2
public class PostDetailServlet extends HttpServlet {
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET /posts/view → PostDetailServlet

//        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

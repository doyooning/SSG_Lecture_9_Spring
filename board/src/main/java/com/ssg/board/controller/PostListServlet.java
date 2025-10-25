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
- DAO에서 최신순 목록 조회.
- 목록에 **번호, 제목, 작성자, 작성일** 표시. 제목 클릭 시 상세로 이동.
- JSP는 **JSTL/EL** 사용,
* */

@WebServlet(name = "PostListServlet", value = "/posts")
@Log4j2
public class PostListServlet extends HttpServlet {
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET /posts → PostListServlet
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

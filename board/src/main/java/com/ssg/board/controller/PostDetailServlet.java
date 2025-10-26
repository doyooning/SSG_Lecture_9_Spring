package com.ssg.board.controller;

import com.ssg.board.dto.PostDTO;
import com.ssg.board.service.PostService;
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

    private PostService postService = PostService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET /posts/view → PostDetailServlet

        try {
            Long id = Long.parseLong(req.getParameter("id"));
            PostDTO postDTO = postService.getDetail(id);
            req.setAttribute("dto", postDTO);
            req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("detail error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

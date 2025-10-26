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

/*
- **GET**: 기존 값 바인딩된 폼 출력(제목/내용만 수정  하고  작성자 수정은 금지)
- **POST**: **비밀번호(passphrase) 확인** 후 업데이트. 불일치 시 오류 메시지.
- 성공 시 상세 페이지로 리다이렉트.
* */

@WebServlet(name = "PostEditFormServlet", value = "/posts/edit")
@Log4j2
public class PostEditFormServlet extends HttpServlet {
    private PostService postService = PostService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET /posts/edit → PostEditFormServlet
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            PostDTO postDTO = postService.getDetail(id);
            req.setAttribute("dto", postDTO);
            req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("edit error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST /posts/update <passphrase 검증 후 업데이트 및 리디렉션>
    }
}

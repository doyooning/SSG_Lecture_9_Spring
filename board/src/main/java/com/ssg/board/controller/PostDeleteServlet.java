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
- 비밀번호 확인 삭제
- 성공 시 목록으로 리다이렉트. 실패 시 상세로 돌아가 오류 표시.
* */

@WebServlet(name = "PostDeleteServlet", value = "/posts/delete")
@Log4j2
public class PostDeleteServlet extends HttpServlet {
    private PostService postService = PostService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST /posts/delete → PostDeleteServlet

        try {
            Long id = Long.parseLong(req.getParameter("id"));
            String pwd = req.getParameter("pwd");
            if (postService.remove(id, pwd)) {
                resp.sendRedirect("/posts");
            } else {
                req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }



    }
}

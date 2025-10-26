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

@WebServlet(name = "PostUpdateServlet", value = "/posts/update")
@Log4j2
public class PostUpdateServlet extends HttpServlet {
    private PostService postService = PostService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST /posts/update → PostUpdateServlet
        req.setCharacterEncoding("UTF-8");
        try {
            String passphrase = req.getParameter("passphrase");
            PostDTO postDTO = PostDTO.builder()
                    .postId(Long.parseLong(req.getParameter("id")))
                    .title(req.getParameter("title"))
                    .content(req.getParameter("content"))
                    .writer(req.getParameter("writer"))
                    .build();
            req.setAttribute("dto", postDTO);
            boolean result = postService.edit(postDTO, passphrase);
            if (!result) {
                req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        resp.sendRedirect("/posts");
    }
}


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
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            PostDTO postDTO = postService.getDetail(id);
            req.setAttribute("dto", postDTO);
            postService.edit(postDTO, postDTO.getPassphrase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/posts");
    }
}


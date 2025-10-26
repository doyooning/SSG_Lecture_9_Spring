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

@WebServlet(name = "PostSaveServlet", value = "/posts/save")
@Log4j2
public class PostSaveServlet extends HttpServlet {
    private PostService postService = PostService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 신규 작성 내용 검증
        log.info("===== /posts doPost =====");
        req.setCharacterEncoding("UTF-8");
        PostDTO postDTO = PostDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("content"))
                .writer(req.getParameter("writer"))
                .passphrase(req.getParameter("passphrase"))
                .build();

        long result = postService.write(postDTO);
        log.info("result: " + result);
        if (result < 1) {
            // 에러창
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req,resp);
        } else {
            // 성공
            resp.sendRedirect("/posts");
        }

    }
}

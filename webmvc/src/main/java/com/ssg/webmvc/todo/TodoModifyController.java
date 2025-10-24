package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoVO todoVO = todoService.read(tno);
            req.setAttribute("todoVO", todoVO);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo modify error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            TodoVO todoVO = TodoVO.builder()
                    .tno(Long.parseLong(req.getParameter("tno")))
                    .title(req.getParameter("title"))
                    .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                    .finished(Boolean.parseBoolean(req.getParameter("finished")))
                    .build();
            todoService.update(todoVO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo modify error");
        }
    }
}

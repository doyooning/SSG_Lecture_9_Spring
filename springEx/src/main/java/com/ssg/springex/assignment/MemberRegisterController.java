package com.ssg.springex.assignment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name="registerController", urlPatterns = "/register")
public class MemberRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberRegisterDAO dao = new MemberRegisterDAO();
        MemberRegisterVO vo = new MemberRegisterVO();
        vo.setId(req.getParameter("user_id"));
        vo.setPassword(req.getParameter("user_pwd"));
        vo.setGender(req.getParameter("user_gender"));
        String[] hobbies = req.getParameterValues("user_hobby");
        vo.setHobby(Arrays.toString(hobbies));

        String username = dao.saveMember(vo);

        RequestDispatcher rd = req.getRequestDispatcher("/assignment/result.jsp");
        rd.forward(req, resp);
    }
}

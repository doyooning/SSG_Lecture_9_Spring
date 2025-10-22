package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberlogin")
public class MemberRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doPost");
        doHandle(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet");
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doHandle");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String userid = request.getParameter("user_id");
        String password = request.getParameter("user_pwd");
        String gender = request.getParameter("radio");
        String[] hobbies = request.getParameterValues("checkbox");

        String data = "<html>";
        data += "<body>";
        data += "<p>" + "id: "+ userid + " pw: " + password + "</p>";
        data += "<p>" + " gender: " + gender + "</p>";
        data += "<p>" + " hobbies: ";
        for (String h : hobbies) {
            data += h + " ";
        }
        data += "</p>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }
}

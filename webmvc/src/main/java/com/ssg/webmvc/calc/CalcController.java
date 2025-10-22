package com.ssg.webmvc.calc;
// PRG 패턴 (Post-Redirect-Get)
// 웹 MVC 가장 일반적인 패턴
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.println(num1 + " " + num2);

        resp.sendRedirect("/calc/input");
        // post 방식과 redirect를 결합해서 사용하고 있음
        // 사용자는 컨트롤러에 원하는 작업을 Post방식으로 처리하기를 요청
        // Post방식을 컨트롤러에서 처리하고 브라우저는 다른 경로로 이동(Get)하라는 응답(Redirect)

    }
}

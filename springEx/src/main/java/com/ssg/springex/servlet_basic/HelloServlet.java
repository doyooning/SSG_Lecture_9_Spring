package com.ssg.springex.servlet_basic;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "myServlet", value = "/my")
public class HelloServlet extends HttpServlet { // HttpServlet을 상속받은 클래스는 웹 페이지의 역할을 할 수 있다
    private String message;

    // request와 response는 WAS(Tomcat)가 제공해줌
    // 클라이언트의 요청 정보가 담길 request, 서버의 응답이 담길 response

    /* WAS는 하나의 클라이언트를 하나의 스레드로 운영 */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> My Servlet </h1>");
        out.println("</body></html>");
        // -> DOM 구조로 만들어지면서 html 태그로 기능함
    }
}
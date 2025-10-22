<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<h1><%= "Hello World!" %></h1>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="servlet_basic/my.jsp">my</a>
<a href="/first">First Servlet</a>
<%--@WebServlet의 value 속성값을 href로 연결 가능--%>
<%--웹 서버는 정적인 콘텐츠를 다루는 역할(HTML 추가 등은 즉각 반영됨)--%>
<%--자바 컨테이너는 동적인 부분을 다루는 영역(href 링크 수정 등은 즉각 반영 안 됨 - 서버 재시작 필요)--%>
</body>
</html>
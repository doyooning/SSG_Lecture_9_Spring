<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-22
  Time: 오후 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <%
    String id = (String) request.getAttribute("user_id");
    Boolean result = (Boolean) request.getAttribute("result");
    String message = "";
    if (Boolean.TRUE.equals(result)){
        message = id + "님, 회원가입 성공하였습니다.";
    } else {
        message = "다시 시도해주세요.";
    } %>
    <h2><%= message %></h2>
    <a href="/assignment/memberRegister.html">첫 화면으로</a>
</body>
</html>

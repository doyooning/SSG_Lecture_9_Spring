<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-28
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Member List</title>
</head>
<body>
<%--    <p>${memberList}</p>--%>
    <c:forEach items="${memberList}" var="member">
        <h3>${member.mname}</h3>
        <p>${member.mid}</p>
        <p>${member.mpw}</p>
    </c:forEach>

    <button>
        <a href="register">회원 등록</a>
    </button>
</body>
</html>

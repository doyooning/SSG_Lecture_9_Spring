<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-23
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@: 지시자, --%>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
    <h1>List Page</h1>
<%--EL 표기법--%>
<%--${list}--%>
<%--<h3>${1+2+3}</h3>--%>
<%--<h3>${"AAA" += "BBB"}</h3>--%>
<%--<h3>${"AAA".equals("AAA")}</h3>--%>
<%--<h4>${list[0].tno}</h4>--%>
<%--<h4>${list[0].duedate}</h4>--%>
<%--<h4>${list[0].title}</h4>--%>

<ul>
    <c:forEach var = "dto" items="${dtoList}">
        <li>${dto}</li>
    </c:forEach>
</ul>


</body>
</html>

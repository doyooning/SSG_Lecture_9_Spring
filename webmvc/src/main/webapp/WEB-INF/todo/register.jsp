<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <p>title: </p><input type="text" name="title" >
        <p>dueDate: </p><input type="date" name="dueDate" >
        <p>finished: </p>
        <input type="radio" name="finished" value="true" checked> true
        <input type="radio" name="finished" value="false"> false
        <div>
            <button type="submit">register</button>
        </div>
    </form>
</body>
</html>

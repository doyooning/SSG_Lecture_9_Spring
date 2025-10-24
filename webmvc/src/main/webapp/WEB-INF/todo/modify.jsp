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
    <title>Todo Modify & Remove</title>
</head>
<body>
    <div>
        ${todoVO.tno} ${todoVO.title} ${todoVO.dueDate} ${todoVO.finished}
    </div>
    <form action="/todo/modify" method="post">
        <input type="hidden" name="tno" value="${todoVO.tno}" >
        <p>title: </p><input type="text" name="title" >
        <p>dueDate: </p><input type="date" name="dueDate" >
        <p>finished: </p>
        <input type="radio" name="finished" value="true" checked> true
        <input type="radio" name="finished" value="false"> false
        <div>
            <button type="submit">Modify</button>
        </div>
    </form>
    <form action="/todo/remove" method="post">
        <input type="hidden" name="tno" value="${todoVO.tno}" >
        <button type="submit">Remove</button>
    </form>

</body>
</html>

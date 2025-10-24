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
    <title>Todo Read</title>
</head>
<body>
    ${dto.tno} ${dto.title} ${dto.dueDate} ${dto.finished}
    <div>
        <a href="/todo/modify?tno=${dto.tno}">Modify</a>
    </div>
</body>
</html>

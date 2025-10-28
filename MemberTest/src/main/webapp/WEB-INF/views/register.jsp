<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-28
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Register</title>
</head>
<body>
    <form action="/save" method="post">
        <div>
            <p>ID를 입력하세요</p>
            <input type="text" name="mid" value=""/>
        </div>
        <div>
            <p>비밀번호를 입력하세요</p>
            <input type="password" name="mpw" value=""/>
        </div>
        <div>
            <p>이름을 입력하세요</p>
            <input type="text" name="mname" value=""/>
        </div>
        <button type="submit">작성 완료</button>
    </form>
</body>
</html>

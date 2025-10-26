<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-25
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--제목/작성자/시간/조회수/내용 + 수정/삭제 버튼--%>

<html>
<head>
    <title>Detail</title>
</head>
<body>

<div>
    <input type="text" name="postId" value="${dto.postId}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" readonly>
</div>
<div>
    <input type="text" name="content" value="${dto.content}">
</div>
<div>
    <input type="text" name="writer" value="${dto.writer}" readonly>
</div>
<div>
    <form action="/posts/edit?id=${dto.postId}" method="get">
        <button type="submit">수정</button>
    </form>
    <form action="/posts/delete" method="post">
        <button type="submit">삭제</button>
    </form>
</div>

</body>
</html>

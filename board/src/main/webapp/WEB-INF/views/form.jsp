<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-25
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--작성/수정 공용 폼(액션 URL만 다르게) + 필드 검증 메시지--%>

<html>
<head>
    <title>Form</title>
</head>
<body>
<%--작성 완료 분기 필요 - 신규 작성, 수정--%>
<%

%>
<form id="form1" action="/posts/save" method="post">
    <div>
        <p>글 제목</p>
        <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
        <p>글 내용</p>
        <input type="text" name="content" value="${dto.content}">
    </div>
    <div>
        <p>글쓴이</p>
        <input type="text" name="writer" value="${dto.writer}">
    </div>
    <div>
        <p>글 비밀번호</p>
        <input type="text" name="passphrase" value="${dto.passphrase}" >
    </div>
    <div>
        <button type="submit">작성 완료</button>
    </div>
</form>

</body>
</html>

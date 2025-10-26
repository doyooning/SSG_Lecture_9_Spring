<%--
  Created by IntelliJ IDEA.
  User: dynii
  Date: 2025-10-25
  Time: 오후 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--공통 오류 페이지(메시지/뒤로가기 링크)--%>

<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p>요청하신 작업을 처리하는 중 오류가 발생하였습니다.</p>
    <p>아래 내용을 확인해주세요:</p>
    <ul>
        <li>게시물 작성 조건<br>
            제목 2~200자, 작성자 1~50자, 내용 5자 이상, 비밀번호 4~20자입니다.
        </li>
        <li>
            비밀번호 오류<br>
            게시물 비밀번호가 일치하는지 확인해 주세요.
        </li>
    </ul>
    <a href="javascript:history.back()">뒤로가기</a>
</body>
</html>

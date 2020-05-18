<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 찾기</h1>
<form action="findPwEmail.jsp" method="post">
<hr>
<p>새롭게 사용할 비밀번호를 입력하세요.<br/>
	<input id="mpw" type="password" name="mpw" placeholder="비밀번호">
	<input id="mpw2" type="password" name="mpw" placeholder="비밀번호확인">
</p>
<p>
	<a href="findPwSuccess.jsp">완료</a>
</p>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
</head>
<body>
<h2>아이디 찾기</h2>
<form action="findIdResult.jsp" method="post">
	본인확인 이메일 인증<br/>
	<p>
		<label for="mname">이름:</label>
		<input id="mname" type="text" name="mname">
	</p>
	<p>
		<label for="memail">이메일:</label>
		<input id="memail" type="email" name="memail">
	</p>
	<p>
		<a href="login.jsp">이전</a>
		<a href="findIdResult.jsp">다음</a>
	</p>
</form>
</body>
</html>
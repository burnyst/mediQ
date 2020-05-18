<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
</head>
<body>
<h2 align="center">비밀번호 찾기</h2>
<form action="findPwEmail.jsp" method="post">
<hr>
	<p>회원가입한 아이디를 입력하세요<br/>
		<input id="mid" type="text" name="mid" placeholder="아이디를 입력하세요.">
	</p>
	<p>
		<a href="login.jsp">이전</a>
		<a href="findPwEmail.jsp">다음</a>
	</p>
</form>
</body>
</html>
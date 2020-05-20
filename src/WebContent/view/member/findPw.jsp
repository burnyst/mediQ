<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<script src="${pageContext.request.contextPath}/js/findPw.js"></script>
</head>
<body>
<h2 align="center">비밀번호 찾기</h2>
<form id="findPw" action="findPw.do" method="post">
<hr>
	<p>회원가입한 아이디를 입력하세요<br/>
		<input type="text" id="mid" name="mid" placeholder="아이디를 입력하세요.">
	</p>
	<p>회원정보에 등록된 이메일을 입력하세요.<br/>
		<input type="text" id="memail" name="memail">
	</p>
	<p>${fail}</p>
	<p>
		<a href="login.do">이전</a>
		<input type="submit" value="다음" />
	</p>
</form>
</body>
</html>
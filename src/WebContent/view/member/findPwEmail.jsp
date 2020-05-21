<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/findPwEmail.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 찾기 </h1>
<form id="findPwResult" action="findPwEmail.do" method="post">
<hr>
	<p>${mid}</p>
	<p>${memail}</p>
	<p>
		<input type="button" id="sendMail" value="인증번호 발송">
	</p>
	<input type="hidden" id="mid" name="mid" value=${mid}>
	<input type="hidden" id="memail" name="memail" value=${memail}>
	<input type="hidden" id="authCode" name="authCode" value=${authCode}>
	${authCode}
	<p>
		<input type="text" id="authCodeCheck" name="authCodeCheck" value="">
	</p>
	<p>${fail}</p>
	<p>
		<a href="findPw.do">이전</a>
		<input type="submit" value="다음" />
	</p>
</form>
</body>
</html>
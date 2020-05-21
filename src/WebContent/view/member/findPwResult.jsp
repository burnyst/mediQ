<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/findPwResult.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 찾기</h1>
<form id="findPwResult" action="findPwResult.do" method="post">
<hr>
${mid}
<p>새롭게 사용할 비밀번호를 입력하세요.<br/>
	<input type="hidden" name="mid" value="${mid}" />
	<input id="mpw1" type="password" name="mpw1" placeholder="비밀번호">
	<input id="mpw2" type="password" name="mpw2" placeholder="비밀번호확인">
</p>
<p>
${fail}
</p>
<p>
	<input type="submit" value="완료" />
</p>
</form>
</body>
</html>
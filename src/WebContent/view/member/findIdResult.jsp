<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ID찾기 결과</h1>
<c:if test="${findId != null && !findId.isEmpty()}">
<hr>회원님의 아이디는 다음과 같습니다.<br/>
${findId}
</c:if>
<c:if test="${findId == null || findId.isEmpty()}">
<hr>존재하지 않는 회원입니다.<br/>
</c:if>
<p>
	<a href="login.do">이전</a>
	<a href="index.jsp">홈으로</a>
</p>
</body>
</html>
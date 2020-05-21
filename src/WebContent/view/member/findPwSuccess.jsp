<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="비밀번호 찾기">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findPwSuccess.js"></script>
</t:head>
<t:body>
	<h2>비밀번호 찾기</h2>
	<hr />
	<table>
		<tr>
			<td>비밀번호 변경이 완료되었습니다</td>
		</tr>
		<tr class="center">
			<td>
				<button id="login" type="button" value="${pageContext.request.contextPath}/login.do">로그인</button>&nbsp;
				<button id="home" type="button" value="${pageContext.request.contextPath}/index.jsp">&nbsp;홈&nbsp;</button>
			</td>
		</tr>
	</table>
</t:body>
</html>
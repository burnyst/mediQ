<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<t:head title="아이디 찾기">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findIdResult.js"></script>
</t:head>
<t:body>
	<h2>아이디 찾기 결과</h2>
	<hr />
	<table>
		<c:if test="${findId != null && !findId.isEmpty()}">
			<tr>
				<td>회원님의 아이디는 다음과 같습니다.</td>
			</tr>
			<tr>
				<td class="center">${findId}</td>
			</tr>
		</c:if>
		<c:if test="${findId == null || findId.isEmpty()}">
			<tr>
				<td class="center">존재하지 않는 회원입니다.</td>
			</tr>
		</c:if>
		<tr>
			<td class="center">
				<button id="pre" type="button" value="${pageContext.request.contextPath}/login.do">이전</button>&nbsp;
				<button id="home" type="button" value="${pageContext.request.contextPath}/index.jsp">&nbsp;홈 &nbsp;</button>
			</td>
		</tr>
	</table>
</t:body>
</html>
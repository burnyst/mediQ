<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<t:head title="비밀번호 찾기">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findPwResult.js"></script>
</t:head>
<t:body>
	<h2>비밀번호 찾기</h2>
	<hr />
	<form id="findPwResult" action="findPwResult.do" method="post">
		<table>
			<tr>
				<td>새로운 비밀번호를 입력하세요</td>
				<td><input type="hidden" name="mid" value="${mid}" /></td>
			</tr>
			<tr>
				<td><input id="mpw1" type="password" name="mpw1" placeholder="새로운 비밀번호" /></td>
			</tr>
			<tr>
				<td><input id="mpw2" type="password" name="mpw2" placeholder="비밀번호확인" /></td>
			</tr>
			<tr>
				<td>${fail}</td>
			</tr>
			<tr>
				<td class="center">
					<button id="pre" type="button" value="${pageContext.request.contextPath}/login.do">이전</button>&nbsp;
					<input id="next" type="submit" value="다음" />
				</td>
			</tr>
		</table>
	</form>
</t:body>
</html>
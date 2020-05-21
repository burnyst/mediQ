<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="아이디 찾기">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findId.js"></script>
</t:head>
<t:body>
	<h2>아이디 찾기</h2>
	<hr />
	<form action="findId.do" method="post">
		<table>
			<tr>
				<td colspan="2">이름과 이메일을 입력하세요</td>
			</tr>
			<tr>
				<td><label for="mname">이름:</label></td>
				<td><input id="mname" type="text" name="mname"></td>
			</tr>
			<tr>
				<td><label for="memail">이메일:</label></td>
				<td><input id="memail" type="email" name="memail"></td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<button id="pre" type="button" value="${pageContext.request.contextPath}/login.do">이전</button>&nbsp;
					<input id="next" type="submit" value="다음" />
				</td>
			</tr>
		</table>
	</form>
</t:body>
</html>
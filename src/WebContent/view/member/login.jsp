<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="로그인">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findId.js"></script>
</t:head>
<t:body>
	<h2>로그인</h2>
	<hr />
	<form method="post" action="login.do">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" class="form-control" name="mid" maxlength="20" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" class="form-control" name="mpwd" maxlength="20" required></td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<input id="login" type="submit" value="로그인" />
				</td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/findId.do">아이디 찾기</a>&nbsp;
					<a href="${pageContext.request.contextPath}/findPw.do">비밀번호 찾기</a>&nbsp;
					<a href="${pageContext.request.contextPath}/join.do">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</t:body>
</html> 
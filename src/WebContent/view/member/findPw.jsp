<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="비밀번호 찾기">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findPw.js"></script>
</t:head>
<t:body>
	<h2>비밀번호 찾기</h2>
	<hr />
	<form action="findPw.do" method="post">
		<table>
			<tr>
				<td>회원가입한 아이디를 입력하세요</td>
			</tr>
			<tr>
				<td><input type="text" id="mid" name="mid" placeholder="아이디를 입력하세요."></td>
			</tr>
			<tr>
				<td>회원정보에 등록된 이메일을 입력하세요.</td>
			</tr>
			<tr>
				<td><input type="text" id="memail" name="memail"></td>
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
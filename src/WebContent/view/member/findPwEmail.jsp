<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="비밀번호 찾기">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/findPwEmail.js"></script>
</t:head>
<t:body>
	<h2>비밀번호 찾기 </h2>
	<hr />
	<form action="findPwEmail.do" method="post">
		<table>
			<tr>
				<td>인증번호를 발송하고 수신한 인증번호를 입력하세요</td>
			</tr>
			<tr>
				<td>${memail}</td>
			</tr>
			<tr>
				<td><input type="button" id="sendMail" value="인증번호 발송" /></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="mid" name="mid" value="${mid}" />
					<input type="hidden" id="memail" name="memail" value="${memail}" />
					<input type="hidden" id="authCode" name="authCode" value="${authCode}" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="authCodeCheck" name="authCodeCheck" value="" placeholder="인증번호를 입력하세요" />
				</td>
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
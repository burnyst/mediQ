<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="회원가입완료">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
</t:head>
<t:body>
	<h2>회원가입</h2>
	<hr/>
	<table>
		<tr>
			<td>회원가입이 완료되었습니다.</td>
		</tr>
		<tr class="center">
			<td>
				<button type="button" onclick="location.href='login.do'">&nbsp;로그인&nbsp;</button>&nbsp;
				<button type="button" onclick="location.href='index.jsp'">&nbsp;홈&nbsp;</button>
			</td>
		</tr>
	</table>	
</t:body>
</html>
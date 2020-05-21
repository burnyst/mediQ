<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="회원정보 변경">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
</t:head>
<t:body>
	<h2>회원정보 변경</h2>
	<hr />
	<table>
		<tr>
			<td colspan="2">${mname}님 회원 정보가 변경되었습니다</td>
		</tr>
		<tr>
			<td class="center">
				<button type="button" onclick="location.href='myinfo.do'">&nbsp;마이페이지&nbsp;</button>
				<button type="button" onclick="location.href='index.jsp'">&nbsp;홈&nbsp;</button>
			</td>
		</tr>
	</table>
</t:body>
</html>
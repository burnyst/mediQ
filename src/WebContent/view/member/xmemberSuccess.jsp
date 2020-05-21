<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="회원탈퇴">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
</t:head>
<t:body>
	<h2>회원탈퇴</h2>
	<hr />
	<table>
		<tr>
			<td>회원탈퇴가 완료되었습니다</td>
		</tr>
		<tr class="center">
			<td>
				<a href="${pageContext.request.contextPath}/logout.do">홈으로</a>
			</td>
		</tr>
	</table>
</t:body>
</body>
</html>
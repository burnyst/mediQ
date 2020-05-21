<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="회원탈퇴">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
</t:head>
<t:body>
	<h2>회원 탈퇴</h2>
	<hr />
	<form action="xmember.do" method="post" onsubmit="return confirm('정말 탈퇴하시겠습니까? 되돌릴 수 없습니다.')">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="mpwd" name="mpwd"></td>
			</tr>
			<tr>
				<td>탈퇴사유</td>
				<td><textarea type="text" id="xreason" name="xreason" style="width:400px; height:100px;" placeholder="자유롭게 입력해 주세요"></textarea></td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<input type="reset" value="취소" onclick="history.back()"/>
					<input type="submit" value="탈퇴하기"/>
				</td>
			</tr>
		</table>
</form>
</t:body>
</html>
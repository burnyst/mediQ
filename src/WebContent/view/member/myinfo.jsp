<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.MyinfoUpdateService" %>
<%@ page import="dao.MemberDAO" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="마이페이지">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
</t:head>
<t:body>
	<h2>마이페이지</h2>
	<hr />
	<form action="" method="post" id="member">
		<table>
			<tr>
				<td>아이디</td>
				<td>${member.mid}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.mname}</td>
			</tr>
			<tr>
				<td>생일</td>
				<td>${member.mbd}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.memail}</td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td>${member.mhp}</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<input type="reset" value="메인 화면으로" onclick="location.href='index.jsp'"/>
					<button type="button" onclick="location.href='xmember.do'">탈퇴하기</button>
					<button type="button" onclick="location.href='myinfoUpdate.do'">정보 변경하기</button>
				</td>
			</tr>
		</table>	
	</form>
</t:body>
</html>
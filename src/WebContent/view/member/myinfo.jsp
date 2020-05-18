<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.MyinfoService" %>
<%@ page import="dao.MemberDAO" %>
<% 
	String mid = request.getParameter("mid");
	String mname = request.getParameter("mname");
	String mbd = request.getParameter("mbd");
	String memail = request.getParameter("memail");
	String mhp = request.getParameter("mhp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<div>
	<h2>마이페이지</h2>
		<form action="myinfo.do" method="post">
			<table>
				<tr>
					<td class="var">아이디:</td>
					<td><%= mid%></td>
				</tr>
				<tr>
					<td class="var">이름:</td>
					<td><%= mname%></td>
				</tr>
				<tr>
					<td class="var">생년월일:</td>
					<td><%= mbd%></td>
				</tr>
				<tr>
					<td class="var">이메일:</td>
					<td><%= memail%></td>
				</tr>
				<tr>
					<td class="var">휴대전화:</td>
					<td><%=mhp%></td>
				</tr>
			</table>
				<tr>
					<a href="xmember.jsp">탈퇴하기</a>
					<a href="myinfoUpdate.jsp">정보 변경하기</a>
				</tr>
		</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="dao.MemberDAO" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="내정보 수정">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/join.js"></script>
</t:head>
<t:body>
	<iframe id="myinfoFrm" style="position:absolute; z-index:1;visibility : hidden;"></iframe>
	<h2>정보 수정</h2>
	<hr/>
	<form action="myinfoUpdate.do" method="post" id="myinfo">
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
				<td>비밀번호</td>
				<td><input type="password" id="mpwd" name="mpwd" value="${member.mpwd}"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="mpwd2" name="mpwd2" value="${member.mpwd2}"></td>
			</tr>
			<tr>
				<td>생일</td>
				<td>${member.mbd}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" id="memail" name="memail" style="width:80" value="${member.memail}"></td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><input type="text" id="mhp" name="mhp" style="width:80" value="${member.mhp}"></td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<button type="button" onclick="location.href='myinfo.do'">이전</button>&nbsp;
					<a href="#" onclick="frmChk1('this.form');return false;">
					<input type="submit" value="수정완료"/></a>
				</td>
			</tr>
		</table>
	</form>
</t:body>
</html>
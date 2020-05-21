<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/join.js"></script>
</head>
<body>
<iframe id="myinfoFrm" style="position:absolute; z-index:1;visibility : hidden;"></iframe>
<h2>정보 수정</h2>
	<form action="myinfoUpdate.do" method="post" id="myinfo">
		<p>
			*아이디:&nbsp;${member.mid}
		</p>
		<p>
			*이름:&nbsp;${member.mname}
		</p>
		<p>
			*비밀번호:&nbsp;<input type="password" id="mpwd" name="mpwd" value="${member.mpwd}">
		</p>
		<p>
			*비밀번호 확인:&nbsp;<input type="password" id="mpwd2" name="mpwd2" value="${member.mpwd2}">
		</p>
		<p>
			*생일:&nbsp;${member.mbd}
		</p>
		<p>
			*이메일:&nbsp;	<input type="email" id="memail" name="memail" style="width:80" value="${member.memail}">
		</p>
		<p>
			*핸드폰번호:&nbsp;
			<input type="text" id="mhp" name="mhp" style="width:80" value="${member.mhp}">
		</p>
		<p>
			<input type="button" onclick="location.href='<%= request.getContextPath()%>/myinfo.do'" value="취소"/>
			<a href="#" onclick="frmChk1('this.form');return false;">
			<input type="submit" value="수정완료"/></a>
		</p>
	</form>
</body>
</html>
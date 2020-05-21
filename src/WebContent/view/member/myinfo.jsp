<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.MyinfoUpdateService" %>
<%@ page import="dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h2>마이페이지</h2>
		<form action="" method="post" id="member">
			<p>
				*아이디:&nbsp;${member.mid}
			</p>
			<p>
				*이름:&nbsp;${member.mname}
			</p>
			<p>
				*생일:&nbsp;${member.mbd}
			</p>
			<p>
				*이메일:&nbsp;	${member.memail}
			</p>
			<p>
				*핸드폰번호:&nbsp;${member.mhp}
			</p>
			<p>
				<input type="reset" value="메인 화면으로" onclick="location.href='index.jsp'"/>
				<input type="button" onclick="location.href='view/member/xmember.jsp'"value="탈퇴하기"/>
				<input type="button" onclick="location.href='<%= request.getContextPath()%>/myinfoUpdate.do'" value="정보 변경하기"/>
			</p>
		</form>
</body>
</html>
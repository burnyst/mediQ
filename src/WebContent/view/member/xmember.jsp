<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴페이지</title>
</head>
<body>
<h1>회원 탈퇴</h1>
<form action="xmember.jsp" method="post">
	<p>
		<label for="memail">이메일:</label>
		<input type="email" id="memail" name="memail">
	</p>
	<p>
		<label for="mpwd">비밀번호:</label>
		<input type="password" id="mpwd" name="mpwd">
	</p>
	<p>
		<label for="xreason">탈퇴사유:</label>
		<textarea type="text" id="xreason" name="xreason" style="width:400px; height:100px;" placeholder="자유롭게 입력해 주세요"></textarea>
	</p>
	<p>
		<a href="myinfo.jsp">이전</a>
		<a href="xmemberSuccess.jsp">탈퇴하기</a>
	</p>
</form>
</body>
</html>
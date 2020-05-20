<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴페이지</title>
<script>
		
</script>
</head>
<body>
<h1>회원 탈퇴</h1>
<form action="<%= request.getContextPath()%>/xmember.do" method="post" onsubmit="return confirm('정말 탈퇴하시겠습니까? 되돌릴 수 없습니다.')">
	<p>
		*비밀번호 : &nbsp;
		<input type="password" id="mpwd" name="mpwd">
	</p>
	<p>
		*탈퇴사유 : &nbsp;
		<textarea type="text" id="xreason" name="xreason" style="width:400px; height:100px;" placeholder="자유롭게 입력해 주세요"></textarea>
	</p>
	<p>
		<input type="reset" value="취소" onclick="history.back()"/>
		<input type="submit" value="탈퇴하기"/>
		
	</p>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
<div align="center">
	<header id = "header">
		<h3>로그인 화면</h3>
  </header> 
	<section class="container" style="max=width: 560px">
		<form method="post" action="login.do">
				<div class="form-group">
					<label>아이디</label>
					<input type="text" class="form-control" name="mid" maxlength="20" required>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<input type="text" class="form-control" name="mid" maxlength="20" required>
				</div>
				<input type="submit" class="btn btn-primary form-control" value="로그인">
		</form>
	</section>
			<a href="findId.jsp">아이디 찾기</a>
			<a href="findPw.jsp">비밀번호 찾기</a>
			<a href="join.jsp">회원가입</a>
</div>
</body>
</html> 
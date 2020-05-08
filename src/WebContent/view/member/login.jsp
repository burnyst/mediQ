<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<link rel="stylesheet" href="style.css">
<script src="jquery-3.4.1.js"></script>
</head>
<body>
	<section class="login-form">
		<h1>로그인</h1>
		<form method="post" action="">
			<div class="int-area">
				<label for="mid">아이디:</label>
				<input type="text" name="mid" id="mid" autocomplete="off" required>
			</div>
			<div class="int-area">
				<label for="mpwd">비밀번호:</label>
				<input type="password" name="mpwd" id="mpwd" autocomplete="off" required>
			</div>
			<div class="btn-area">
				<button type="submit">LOGIN</button>
			</div>
		</form>
		<div class="caption">
			<a href="">아이디 찾기</a>
		</div>
		<div class="caption">
			<a href="">비밀번호 찾기</a>
		</div>
		<div class="caption">
			<a href="">회원가입</a>
		</div>
	</section>
</body>
</html>
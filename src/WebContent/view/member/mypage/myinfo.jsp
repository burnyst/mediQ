<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>마이페이지</title>
</head>
<body>
<div class="outer">
	<h2 align="center">마이페이지</h2>
		<form action="views/member/memverUpdateForm.jsp" method="post">
			<table>
				<tr>
					<td width="200px"><label id="must" for="mid">아이디:</label></td>
					<td width="250px"><input type="hidden" name="mid" value=""></td>
				</tr>
				<tr>
					<td><label id="must" for="mname">이름:</label></td>
					<td width="250px"><input type="hidden" name="mname" value=""></td>
				</tr>
				<tr>
					<td><label id="must" for="mbd">생년월일:</label></td>
					<td width="250px"><input type="hidden" name="mbd" value=""></td>
				</tr>
				<tr>
					<td><label id="must" for="mhp">휴대전화:</label></td>
					<td width="250px"><input type="hidden" name="mhp" value=""></td>
				</tr>
				<tr>
					<td><label id="must" for="memail">이메일:</label></td>
					<td width="250px"><input type="hidden" name="memail" value=""></td>
				</tr>
			</table>
			<tr>
				<input type="reset" value="탈퇴하기"/>
				<input type="submit" value="정보변경하기"/>
			</tr>
		</form>
</div>
</body>
</html>
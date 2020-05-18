<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정보 수정</h1>
<form action="myinfoUpdate.do" method="post">
		<table>
			<tr>
				<td>
				<label id="must" for="mid">아이디:</label>
				<input type="hidden" name="mid" value="">
				</td>
			</tr>
			<tr>
				<td>
				<label id="must" for="mname">이름:</label>
				<input type="hidden" name="mname" value="">
				</td>
			</tr>
			<tr>
				<td>
				<label id="must" for="mbd">생년월일:</label>
				<input type="hidden" name="mbd" value="">
				</td>
			</tr>
			<tr>
				<td>
				<label id="must" for="mhp">휴대전화:</label>
				<input type="hidden" name="mhp" value="">
				</td>
			</tr>
			<tr>
				<td>
				<label id="must" for="memail">이메일:</label>
				<input type="hidden" name="memail" value="">
				</td>
			</tr>
		</table>
			<ul>
				<a href="xmember.jsp">탈퇴하기</a>
				<a href="myinfoUpdate.jsp">정보 변경하기</a>
			</ul>
</form>
</body>
</html>
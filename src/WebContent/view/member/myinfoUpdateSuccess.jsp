<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${mname}님 회원 정보가 변경되었습니다.</h3>

<input type="reset" value="마이페이지로 돌아가기" onclick="location.href='<%= request.getContextPath()%>/myinfo.do'"/>
   
</body>
</html>
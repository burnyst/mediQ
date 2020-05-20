<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function check(){
	if(frm.mpwd.value != frm.mpwd2.value){
		alert('비밀번호가 일치하지 않습니다');
		frm.mpwd.focus();
		return false;
	}
}
</script>
</head>
<body>
<h2>정보 수정</h2>
	<form action="myinfoUpdate.do" method="post">
		<p>
			*아이디:&nbsp;${param.mid}
		</p>
		<p>
			*이름:&nbsp;${param.mname}
		</p>
		<p>
			*비밀번호:&nbsp;<input type="password" id="mpwd" name="mpwd" value="${param.mpwd}">
		</p>
		<p>
			*비밀번호 확인:&nbsp;<input type="password" id="mpwd2" name="mpwd2" value="${param.mpwd2}">
		</p>
		<p>
			*생일:&nbsp;${param.mbd}
		</p>
		<p>
			*이메일:&nbsp;	<input type="text" id="memail" name="memail" style="width:80" value="${param.memail}">@
			<select name="memail" >
		    <option value ="">선택하세요</option>
		    <option value ="naver.com" >naver.com</option>
		    <option value="gmail.com">gmail.com</option>
		    <option value ="hanmail.net">daum.net</option>
		    <option value ="nate.com">nate.com</option> 
		    <option value ="yahoo.com">yahoo.com</option>
	    </select>
		</p>
		<p>
			*핸드폰번호:&nbsp;
			<select id="mhp" name="mhp" value="${param.mhp}">
				<option selected>선택</option>
	       <option value="010">010</option>
	       <option value="011">011</option>
	       <option value="016">016</option>
	       <option value="017">017</option>
	       <option value="019">019</option>
			</select>-
			<input id="mhp1" type="text" name="mhp" maxlength="4" size="5" value="${param.mhp1}">-
			<input id="mhp2" type="text" name="mhp" maxlength="4" size="5" value="${param.mhp2}">
		</p>
		<p>
			<input type="button" onclick="location.href='myinfo.jsp'" value="취소"/>
			<input type="submit" value="수정완료"/>		
		</p>
	</form>
</body>
</html>
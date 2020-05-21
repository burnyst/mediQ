<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="회원가입">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/find.css" />
	<script src="${pageContext.request.contextPath}/js/join.js"></script>
	<script>
	var authCode2 = "";
	function check() {
		var midObj = document.getElementById("mid");
		if(midObj.value==''){	
			alert("아이디는 필수입니다");
			midObj.focus();
			return false;
		}
		
		location.href="./searchId.do?mid="+midObj.value;
		
		console.log('~~');
		return;
	}
	
	function sendMail() {
		var email = document.getElementById("memail");
		var email2 = document.getElementById("memail2");
		var content = document.getElementById("authCode");
		if(email.value==''){	
			alert("이메일은 필수입니다");
			email.focus();
			return false;
		}
		
		var mid = document.getElementById("mid");
		var memail = document.getElementById("memail");
		var authCode = document.getElementById("authCode");
		var code = "";
		for (var i=0; i < 6; i++) {
			code += Math.floor(Math.random() * 10);
		}
		
		authCode.value = code;

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("auth").className = "";
			}
		}
		xhttp.open("POST", "mail.do", true);
	  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xhttp.send("title=메디큐이메일인증&content="+content.value+"&email="+email.value+"@"+email2.value+"&authCode="+code);

		//location.href="mail.do?title=메디큐이메일인증"+"&content="+content.value+"&email="+email.value+"@"+email2.value+"&authCode="+code;
		//authCode2.hide();
		return false;
	}
	
	function checkAuthCode() {
		console.log("checkAuthCode()");
		var authCode = document.getElementById("authCode");
		console.log(authCode);
		authCode2 = document.getElementById("authCode2");
		console.log(authCode2);
		var checkAuthCodeResult = document.getElementById("checkAuthCodeResult");
		console.log(checkAuthCodeResult);
		if(authCode.value == authCode2.value){
			checkAuthCodeResult.innerHTML = "인증완료";
		} else {
			checkAuthCodeResult.innerHTML = "인증 번호가 다릅니다";
		}
	}
	</script>
</t:head>
<t:body>
	<iframe id="joinFrm" style="position:absolute; z-index:1;visibility : hidden;"></iframe>
	<h2>회원가입</h2>
	<hr />
<!-- req.setAttribute("RESULT", result); -->
	${result}
	<form action="join.do" id="join" method="post">
		<input type="hidden" id="reqMethod" name=reqMethod value="">
		<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="mid" name="mid" value="${param.mid}">
							<button type="button" onclick="check();">중복확인</button>
							<span>${RESULT}</span></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="mname" name="mname" value="${param.mname}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="mpwd" name="mpwd" value="${param.mpwd}"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="mpwd2" name="mpwd2" value="${param.mpwd2}"></td>
				</tr>
				<tr>
					<td>생일</td>
					<td><input type="date" id="mbd" name="mbd" value="${param.mbd}"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="memail" name="memail" style="width:80" value="${param.memail}">&nbsp;@
							<select id="memail2" name="memail2" >
						    <option value ="">선택하세요</option>
						    <option value ="naver.com" >naver.com</option>
						    <option value="gmail.com">gmail.com</option>
						    <option value ="hanmail.net">daum.net</option>
						    <option value ="nate.com">nate.com</option> 
						    <option value ="yahoo.com">yahoo.com</option>
					    </select>
		    			<button type="button" id="mverify" onclick="sendMail()" >이메일 인증</button>
		    			<input type="hidden" id="authCode" /></td>
		    </tr>
		    <tr>
		    	<td></td>
    			<td id="auth" class="hidden">
	    				<input type="text" id="authCode2" />
	    				<button type="button" id="mverify2" onclick="checkAuthCode()">인증하기</button>
    					<span id="checkAuthCodeResult"></span>
    			</td>
    		</tr>
				<tr>	
					<td>핸드폰번호</td>
					<td><select id="mhp" name="mhp" value="${param.mhp}" style="height:20">
								<option selected>선택</option>
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="019">019</option>
							</select>&nbsp;-
								<input id="mhp1" type="text" name="mhp1" maxlength="4" size="5" value="${param.mhp1}">&nbsp;-
								<input id="mhp2" type="text" name="mhp2" maxlength="4" size="5" value="${param.mhp2}">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="center">
						<input type="reset" value="취소" onclick="history.back()"/>&nbsp;	
						<a href="#" onclick="frmChk('this.form');return false;">
						<input type="submit" value="가입"/></a>
					</td>
				</tr>		
		</table>
	</form>
</t:body>
</html>
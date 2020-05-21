<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script src="${pageContext.request.contextPath}/js/join.js"></script>
		<script>
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
			var content = document.getElementById("authCode");
			if(email.value==''){	
				alert("이메일은 필수입니다");
				email.focus();
				return false;
			}
			
			location.href="./mail.do?title=메디큐 이메일 인증"+"&content="+content.value+"&email"+email.value;
			authCode2.hide();
			return;
		}
		function checkAuthCode() {
			var authCode = document.getElementById("authCode");
			var authCode2 = document.getElementById("authCode2");
			var checkAuthCodeResult = document.getElementById("checkAuthCodeResult");
			if(authCode.value == authCode2.value){
				checkAuthCodeResult.value = "인증완료";
			} else {
				checkAuthCodeResult.value = "인증 번호가 다릅니다";
			}
		}
		</script>
		
</head>
<body>
<iframe id="joinFrm" style="position:absolute; z-index:1;visibility : hidden;"></iframe>
<h1>회원가입</h1>

<!-- req.setAttribute("RESULT", result); -->
${result}
<form action="join.do" id="join" method="post">
<input type="hidden" id="reqMethod" name=reqMethod value="">
	<p>
		*아이디:&nbsp;<input type="text" id="mid" name="mid" value="${param.mid}">
		<!-- <input type="submit" value="중복확인" onclick="check();"/> -->
		<input type="button" value="중복확인" onclick="check();"/>
		
		 <span>${RESULT}</span>
		
	</p>
	<p>
		*이름:&nbsp;<input type="text" id="mname" name="mname" value="${param.mname}">
	</p>
	<p>
		*비밀번호:&nbsp;<input type="password" id="mpwd" name="mpwd" value="${param.mpwd}">
	</p>
	<p>
		*비밀번호 확인:&nbsp;<input type="password" id="mpwd2" name="mpwd2" value="${param.mpwd2}">
	</p>
	<p>
		*생일:&nbsp;<input type="date" id="mbd" name="mbd" value="${param.mbd}">
	</p>
	<p>
		*이메일:&nbsp;	<input type="text" id="memail" name="memail" style="width:80" value="${param.memail}">@
		<select name="memail2" >
	    <option value ="">선택하세요</option>
	    <option value ="naver.com" >naver.com</option>
	    <option value="gmail.com">gmail.com</option>
	    <option value ="hanmail.net">daum.net</option>
	    <option value ="nate.com">nate.com</option> 
	    <option value ="yahoo.com">yahoo.com</option>
    </select>
    <button type="button" id="mverify" onclick="sendMail()">이메일 인증</button><br/>
    <input type="hidden" id="authCode" />
    <input type="text" id="authCode2" />
    <button type="button" id="mverify" onclick="checkAuthCode()">인증</button>
    <span id="checkAuthCodeResult"></span>
		  <form action="post">
			  <script>
					$("#mverify").click(function()){
			    		if(verify.success){
			    			var msg = '인증이 완료되었습니다'
				    	}else{
				    		var msg = '인증이 실패하였습니다'
				    	}
			    	alert (msg);
					}
			   </script>
		   </form>
	</p>
	<p>
		*핸드폰번호:&nbsp;
		<select id="mhp" name="mhp" vlaue="${param.mhp}">
			<option selected>선택</option>
       <option value="010">010</option>
       <option value="011">011</option>
       <option value="016">016</option>
       <option value="017">017</option>
       <option value="019">019</option>
		</select>-
		<input id="mhp1" type="text" name="mhp1" maxlength="4" size="5" value="${param.mhp1}">-
		<input id="mhp2" type="text" name="mhp2" maxlength="4" size="5" value="${param.mhp2}">
	</p>
	<p>
    <a href='index.jsp'>돌아가기</a>
		<a href="#" onclick="frmChk('this.form');return false;"></a>
		<input type="submit" value="가입하기"/>
	</p>
</form>
</body>
</html>
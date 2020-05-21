window.addEventListener("load", function() {
	document.getElementById("sendMail").addEventListener("click", function() {
		var mid = document.getElementById("mid");
		var memail = document.getElementById("memail");
		var authCode = document.getElementById("authCode");
		var code = "";
		for (var i=0; i < 6; i++) {
			code += Math.floor(Math.random() * 10);
		}
		authCode.value = code;
		location.href = "findPwEmail.do?mid="+mid.value+"&memail="+memail.value+"&authCode="+code+"&title=메디큐 메일인증";
    });

	document.getElementById("pre").addEventListener("click", function() {
		location.href = this.value;
	});
	
	document.getElementById("next").addEventListener("click", function(e) {
		
		var authCode = document.getElementById("authCode");
		var authCodeCheck = document.getElementById("authCodeCheck");
		if (authCode === undefined || authCode.value == "") {
			alert("인증메일을 발송하지 않았습니다.");
			e.preventDefault();
		} else if (authCodeCheck === undefined || authCodeCheck.value == "") {
			alert("인증번호를 입력하지 않았습니다.");
			e.preventDefault();
		} else if (authCode.value != authCodeCheck.value) {
			alert("인증번호가 일치하지 않습니다.");
			e.preventDefault();
		}
	});
});
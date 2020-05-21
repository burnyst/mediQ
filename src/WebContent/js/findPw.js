window.addEventListener("load", function() {
	document.getElementById("pre").addEventListener("click", function() {
		location.href = this.value;
	});
	document.getElementById("next").addEventListener("click", function(e) {
		var mid = document.getElementById("mid");
		var memail = document.getElementById("memail");
		var authCode = document.getElementById("authCode");
		if (mid.value === undefined || mid.value == "") {
			alert("아이디를 입력하세요.");
			mid.focus();
			e.preventDefault();
		} else if (memail.value === undefined || memail.value == "") {
			alert("이메일을 입력하세요.");
			memail.focus();
			e.preventDefault();
		}
	});
});
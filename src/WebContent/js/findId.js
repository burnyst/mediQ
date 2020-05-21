window.addEventListener("load", function() {
	document.getElementById("pre").addEventListener("click", function() {
		location.href = this.value;
	});
	document.getElementById("next").addEventListener("click", function(e) {
		var name = document.getElementById("mname");
		var email = document.getElementById("memail");
		if (name === undefined || name.value == "") {
			alert("이름을 입력하세요.");
			name.focus();
			e.preventDefault();
		} else if (email === undefined || email.value == "") {
			alert("이메일을 입력하세요.");
			email.focus();
			e.preventDefault();
		}
	});
});
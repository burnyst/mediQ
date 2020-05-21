window.addEventListener("load", function() {
	document.getElementById("pre").addEventListener("click", function() {
		location.href = this.value;
	});
	document.getElementById("next").addEventListener("click", function(e) {
		var mpw1 = document.getElementById("mpw1");
		var mpw2 = document.getElementById("mpw2");
		if (mpw1 === undefined || mpw1.value == "") {
			alert("변경할 비밀번호를 입력하세요.");
			mpw1.focus();
			e.preventDefault();
		} else if (mpw2 === undefined || mpw2.value == "") {
			alert("변경할 비밀번호를 입력하세요.");
			mpw2.focus();
			e.preventDefault();
		} else if (mpw1.value != mpw2.value) {
			alert("입력한 비밀번호가 일치하지 않습니다.");
			mpw2.value = "";
			mpw2.focus();
			e.preventDefault();
		}
	});
});
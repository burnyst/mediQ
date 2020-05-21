window.addEventListener("load", function() {
	document.getElementById("login").addEventListener("click", function() {
		location.href = this.value;
	});
	document.getElementById("home").addEventListener("click", function() {
		location.href = this.value;
	});
});
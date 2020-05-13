window.addEventListener("load", function() {
	var form = document.querySelectorAll("div.search form");
	if (form[0]["productName"].value == "") {
		form[0]["productName"].focus();
	}
	form[0].addEventListener("submit", function() {
		if (form[0]["productName"].value.trim() == "") {
			form[0]["productName"].value = "";
			return false;
		} else {
			return true;
		}
	});
    var table = document.querySelectorAll("table.items");
    if (table.length > 0) {
	    var len = table[0].rows.length;
	    for (var i = 1; i < len; i+=2) {
	        table[0].rows[i].addEventListener("click", function() {
	            var desc = this.nextSibling.nextSibling;
	            var className = desc.className;
	            var table = document.querySelectorAll("table.items");
	            var len = table[0].rows.length;
	            for (var i = 2; i < len; i+=2) {
	                table[0].rows[i].className = "hidden";
	            }
	            if ("hidden" === className) {
	                desc.className = "";
	            }
	        });
	    }
    }
});
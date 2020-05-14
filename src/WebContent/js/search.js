window.addEventListener("load", function() {
	var form = document.querySelectorAll(".search form");
	form[0].addEventListener("submit", function(e) {
		this["searchWord"].value = this["searchWord"].value.trim();
		if (this["searchWord"].value == "") {
			this["searchWord"].value = "";
			e.preventDefault();
		}
	});
	if (form[0]["searchWord"].value == "") {
		form[0]["searchWord"].focus();
	}
    var hasDetail = document.querySelectorAll(".hasDetail");
    var len = hasDetail.length;
    for (var i = 0; i < len; i++) {
    	hasDetail[i].addEventListener("click", function() {
    		var detailRow = this.parentNode.nextSibling.nextSibling;
    		var className = detailRow.className;
    		var hasDetail = document.querySelectorAll(".hasDetail");
    		var len = hasDetail.length;
            for (var i = 0; i < len; i++) {
            	hasDetail[i].parentNode.nextSibling.nextSibling.className = "hidden";
            }
    		if ("hidden" === className) {
    			detailRow.className = "";
    		}
    	});
    }
});
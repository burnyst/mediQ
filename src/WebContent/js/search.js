window.addEventListener("load", function() {
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
    
    var selectAll = document.querySelectorAll(".selectAll");
    if (selectAll.length > 0) {
    	selectAll[0].addEventListener("click", function(e) {
    		var items = document.querySelectorAll('.items input[type="checkbox"]');
    		var len = items.length;
    		var check = true;
    		if (this.innerHTML === "전체 선택") {
    			this.innerHTML = "전체 해제";
    		} else {
    			check = false;
    			this.innerHTML = "전체 선택";
    		}
    		for (var i=0; i < len; i++) {
    			items[i].checked = check;
    		}
    		e.preventDefault();
    	});
    }
    
	var form = document.querySelectorAll(".search form");
	if (form.length > 0) {
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
	}
});
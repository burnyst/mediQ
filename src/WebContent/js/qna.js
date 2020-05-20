function resetf(frmq){	
	if(confirm("작성 내용을 삭제하시겠습니까?")== true)
	{
		//frmq.reset(); 
		location.href="qnalist.do"; 
	  }else{
	 return ; }
}

function onDownload(sn) {
	var o = document.getElementById("ifrm_filedown");
	o.src = "download.do?sn=" + sn;
}

window.addEventListener("load", function() {
	document.getElementById("writeQna").addEventListener("click", function() {
    		if (this.value == "true") {
    			alert("회원 전용 페이지입니다.  회원가입을 하신 뒤, 이용 부탁드립니다.");
    		} else {
    			location.href='qnaupdate.do';
    		}
    	});

});
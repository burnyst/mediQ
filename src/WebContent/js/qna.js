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

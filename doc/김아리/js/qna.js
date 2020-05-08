
function resetf( frmq ){	
	if(confirm("작성 내용을 삭제하시겠습니까?")== true)
	{
		//frmq=form객체
		frmq.reset();  
		location.href="../qna/qnalist.jsp"; ///cs/qna/qnalist.do 로 바꿔야함
	  }else{
	 return; }
	}

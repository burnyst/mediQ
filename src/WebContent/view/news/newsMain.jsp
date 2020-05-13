<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스게시판 메인페이지</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
h2{
text-align: center;
border:15px;
}
#register{
 float: right;
}
table {
	border-collapse: collapse;
	width: 500px;
	margin: auto;
  text-align: center;
  
	}

</style>
</head>
<body>
			<h2>뉴스 게시판</h2><br/> 
		<form>	
		<input type=text id="idResearch" value="제목을 검색해주세요" /><input type="button" id="research" value="검색" onclick=""/> 
		<a href="./newsInsert.jsp"><input type="button" id="register" value="등록" ></a>
		<hr>
		<table class="table table-striped" border="1">
			<tr>
						<th>번호</th>
						<th>제목</th>
						<th>기사요약정보</th>
						<th>언론사명</th>
						<th>아이디</th>
						<th>등록일자</th>
			</tr>
			<tr>
						<th>${news.sn }</th>
						<th><a href="read.do?no=${news.sn}&pageNo=${newsPAGE.currentPage}">${news.title }</a></th>
						<th>${news.summary }</th>
						<th>${news.press }</th>
						<th>${news.mid }</th>
						<th>${news.rdate }</th>
			</tr>
						

		</table>
		</form>				
</body>
</html>
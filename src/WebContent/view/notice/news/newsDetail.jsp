<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스게시판 상세페이지</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<style>

h2{
text-align: center;
border:15px;
}
#contents {
   border-collapse: collapse;
   width: 500px;
   margin: auto;
   padding: 50px;
  text-align: left;
   }
#info {
   width: 1000px;
   margin: auto;
   padding: 40px 20px;
  text-align: center;

}
input{
float:right;
}

</style>
</head>
<body>
         <form method="post" >
         <h2>뉴스게시판</h2>
         <table id= info>
         <tr>
         		<td>번호</td>
         		<td>${newd.sn}</td>
         </tr>
         <tr>
         		<td>제목</td>
         		<td>${newd.title}</td>
         </tr>
         
         <tr>
         		<td>언론사명</td>
         		<td>${newd.press}</td>
         		<td>아이디</td>
         		<td>${newd.mid}</td>
         		<td>등록일자</td>
         		<td>${newd.rdate}</td>
         </tr>
				 </table>	
				 <input type="button" id="modify" value="수정" onclick="location.href='newsmodify.do?${news.mid}'"><!-- 이영역은 관리자로 로그인할 경우만 보이는 버튼 -->
         <table border="1" id="contents" >
         <tr>
          <td><textarea name="contents" rows="20" cols="100"  >
          	<img src=${newd.nimage}>	
           ${newd.summary}
          </textarea></td>
         </tr>
         </table>
         <a href="/newslist.do"><input type=button  value="목록으로"   /></a>
	
					</form>
</body>
</html>
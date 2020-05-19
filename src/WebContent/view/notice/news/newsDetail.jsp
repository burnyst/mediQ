<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
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
		<%-- <form id="f" name="f" action="./newsmodify.do?sn=${newd.sn}" method="post">
				 	<input type="submit" id="modify" value="수정"/>
		</form> --%>

        <form method="post" action="./newsmodify.do?sn=${newsd.sn}">
        <%-- <form method="post" action="./newsmodify.do?sn=${newd.sn}&title=${newd.title}&summary=${newd.summary}">
         --%>
       <%--  <input type="hidden" name="press" id="press" value="${newd.press}"/> --%>
       
         <h2>뉴스게시판</h2>
         <table id= info>
         <tr>
         		<td>번호</td>
         		<td>${newsd.sn}</td>
         </tr>
         <tr>
         		<td>제목</td>
         		<td>${newsd.title}</td>
         </tr>
         
         <tr>
         		<td>언론사명</td>
         		<td>${newsd.press}</td>
         		<td>아이디</td>
         		<td>${newsd.mid}</td>
         		<td>등록일자</td>
         		<td>${newsd.rdate}</td>
         </tr>
				 </table>	
				 
         <table border="1" id="contents" >
         <tr>
          <td>
           ${newsd.summary}
         </tr>
         </table>
         <a href="./newslist.do"><input type=button  value="목록으로" /></a>
					<input type="hidden" id="modify" value=""/>
					</form>
        <%-- <form method="post" action="./newsmodify.do?sn=${newd.sn}&title=${newd.title}&summary=${newd.summary}">
         --%>
       <%--  <input type="hidden" name="press" id="press" value="${newd.press}"/> --%>
       <%----------------수정용-------------------------------------------------------------------------------- --%>
        <%-- <c:if test=""> --%>
					<form method="post" action="./newsmodify.do?sn=${newsd.sn}">
         <h2>뉴스게시판  수정 및 삭제</h2>
         <table id= info>
         <tr>
         		<td>번호</td>
         		<td>${newsd.sn}</td>
         </tr>
         <tr>
         		<td>제목</td>
         		<td><input type="text" name="title" value="${newsd.title}"></td>
         </tr>
         
         <tr>
         		<td>언론사명</td>
         		<td>${newsd.press}</td>
         		<td>아이디</td>
         		<td>${newsd.mid}</td>
         		<td>등록일자</td>
         		<td>${newsd.rdate}</td>
         </tr>
				 </table>	
				 
         <table border="1" id="contents" >
         <tr>
          <td><textarea name="summary" rows="20" cols="100"  >
           ${newsd.summary}
          </textarea></td>
         </tr>
         </table>
         <a href="./newslist.do"><input type=button  value="목록으로" /></a>
					<input type="submit" id="modify" value="수정하기"/>
					</form>
					<a href ="${pageContext.request.contextPath}/newsdelete.do?sn=${newsd.sn}">
					<input type="button" value="삭제"></a>
					<%-- <a href="${pageContext.request.contextPath}/faqdelete.do?sn=${faq.sn}">
	    						<input type="button" id="deleteBtn"  name="deleteBtn" value="삭제" onclick="f1()"/>
	    						</a> --%>
					
					<%-- </c:if> --%>
</body>
</html>
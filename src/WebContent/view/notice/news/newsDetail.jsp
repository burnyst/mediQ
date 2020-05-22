<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>      
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<t:head title="뉴스게시판 상세페이지">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<meta charset="UTF-8">
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
</t:head>
<t:body>
        <form method="post" action="./newsmodify.do?sn=${newsd.sn}">
        
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
         		<td><fmt:formatDate value="${newsd.rdate}" pattern="yyyy-MM-dd"/></td>
         </tr>
				 </table>	
				 
         <table border="1" id="contents" >
         <tr>
          <td>
          	<c:if test="${newsd.nimage !=null }">
								<img src="${pageContext.request.contextPath}/upload/${newsd.nimage}"></br>
								
						</c:if>
           ${newsd.summary}
         </tr>
         </table>
         <a href="./newslist.do"><input type=button  value="목록으로" /></a>
					<input type="hidden" id="modify" value=""/>
					</form>
        
       <%----------------수정용-------------------------------------------------------------------------------- --%>
			<c:if test="${user.mlevel==2}">
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
          <td><textarea name="summary" rows="20" cols="100">${newsd.summary}</textarea></td>
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
					
					 </c:if>
</t:body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>
<!DOCTYPE html>
<t:head title="뉴스게시판 수정 및 삭제">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<meta charset="UTF-8">
    <meta charset="UTF-8">
		<style>
		h2{
		text-align: center;
		border:15px;
		}
		table {
		   border-collapse: collapse;
		   width: 50%;
		   margin: auto;
		   padding: 50px;
		  text-align: left;
		   }
		span{
		padding: 0 0 0 200px;
		}
		
		</style>
</t:head>
<t:body>
    <form  action="./newsmodify.do?sn=${news.sn}" >
    <h2>뉴스게시판 수정 미리보기</h2>
	
    <span>제목</span>
    <input type="text" id="title" required="required" value="${modiREQ.title}"><br/>
    <span>언론사명</span>
    <%-- <input type="text" id="newsMedia" placeholder="언론사를 입력해주세요" >${modiReq.press}<br/> --%>
    <table border="1" >
         <tr>
          <td><textarea name="summary" rows="20" cols="100" required="required" > ${modiREQ.summary}</textarea>
          </td>         
          </tr>
    </table>
    <input type="hidden" id="submit" value="수정">
    <a href="./newslist.do"><input type="button"  value="수정"   /></a>
    
    </form>

</t:body>
</html>
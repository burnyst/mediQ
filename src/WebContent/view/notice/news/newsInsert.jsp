<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>
<!DOCTYPE html>
<html>
<t:head title="뉴스게시판 등록">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<meta charset="UTF-8">
		<style>
			h2{
			text-align: center;
			border:15px;
			}
			table {
			   border-collapse: collapse;
			   width: 500px;
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
    <form action="newswrite.do" method="POST" enctype="multipart/form-data">
    <h2>뉴스게시판 등록</h2>
    <span>제목</span>
    <input type="text" name="title" id="title" placeholder="제목을 입력해주세요" ><br/>
    <span>언론사명</span>
    <input type="text" name="press"id="press" placeholder="언론사를 입력해주세요" ><br/>
    <table border="1" >
         <tr>
				<td>
				<input type="file" name="nimage" id="nimage">
				</td>
				</tr>
        <tr>
         <td><textarea id="summary" name="summary" rows="20" cols="100" ></textarea></td>
        </tr>
					
				
    </table>
    <input type="submit" id="submit" value="등록">
    <!-- <input type="hidden" id="mid" name="mid" value="관리자"> -->
    <input type="reset" id="reset" value="취소" onclick="resetf('this.form')">
    </form>
</t:body>
</html>
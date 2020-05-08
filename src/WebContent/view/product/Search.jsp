<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
#Select {float:right;}
#SDelete {float:right;}
</style>

<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<br>의약품 검색 조회</br>
<p>의약품 검색
		<input type='text' id='Entry' value="품목명을 입력하세요"></input>
		<input type='button' id="Search" value="검색"></input>
		<hr>
		
		
		마이페이지-검색이력 조회
		
		<input type='button' id='Select' value="전체선택"></input> 
		<input type='button' id='SDelete' value="선택삭제"></input> 
	 </br>
</p>
<table border=1 width=100% >
	<tr>
		<td></td>
		<td>분류</td>
		<td>업체명</td>
		<td>품목명</td>
		<td>전문일반</td>
		<td>성상</td>
	</tr>
	<tr height=25>
		<td><input type="checkbox"></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
	</hr>
	<!-- 페이징처리 / 1 2 3 4 5 10-->
	<c:forEach var="pageNum" begin="1"	end="${viewData.pageTotalCount}"> <%--end=수정해야함 p463 50--%>
		<a href="list.jsp?page=${pageNum}">${pageNum}</a>
	</c:forEach>

	
</body>
</html>
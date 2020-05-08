<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
/* #Select,#SDelete
float:right */
</style>
<title>Insert title here</title>
</head>
<body>
<br>의약품 승인 목록</br>
<p>승인 의약품 검색
<input type='text'>품목명을 입력하세요</input>
<input type="button" value="검색"></input>
<hr>


</br>
	<table border=1 width=80% >
	<tr>
		<td>번호</td>
		<td>품목명</td>
		<td>업체명</td>
		<td>허가일자</td>
		<td>주의사항</td>
		<td>등록일자</td>
	</tr>
	
	<tr height=25>
		<td></td>
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
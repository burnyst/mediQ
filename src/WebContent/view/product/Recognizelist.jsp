<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    

</head>
<body>
<div class="search">
<form method='get' action="${pageContext.request.contextPath}/recognize.do">		

</div>

<br>의약품 승인 목록</br>
<p>승인 의약품 검색
<input type='text' id='MessageBox' class="text1" name="productName" value="${productName}"/>
<input type="submit" value="검색"/>
<hr>
</div>
	<c:if test="${page != null}">
		<div class="result">
		<h5>검색 결과</h5>
	<table border=1 width=80% name="result">
	<tr>
		<td>번호</td>
		<td>품목명</td>
		<td>업체명</td>
		<td>허가일자</td>
		<td>등록일자</td>
	</tr>
	 <c:if test="${page.totalCount == 0}">
		<tr>
			<td colspan="5">조회된 결과가 없습니다</td>
		</tr>
	 </c:if>
	 <c:forEach var="md" items="${page.content}">
	 	<tr class="i">
 	 		<td>번호</td>
			<td>${i.itemName}</td>
			<td>${i.entpName}</td>
			<td>${i.itemPermitDate}</td>
			<td>${i.Date}</td>
	 	</tr>
	 	<tr class="hidden">
	 		<td colspan="5">
	 			<table>
	 			<h4>주의사항</h4>
	 			<p>${md.nbDocData}</p>
	 			</table>
 			</td>
	 	</tr>
	 </c:forEach>
				<c:if test="${page.totalCount > 0}">
					<tr>
						<th colspan="5">
							<c:if test="${page.startPage > 5}">
								<a href="search.do?productName=${productName}&pageNo=${page.startPage - 5}">[이전]</a>
							</c:if>
							<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
								<a href="search.do?productName=${productName}&pageNo=${i}">[${i}]</a>
							</c:forEach>
							<c:if test="${page.endPage < page.totalPages}">
								<a href="search.do?productName=${productName}&pageNo=${page.startPage}">[다음]</a>
							</c:if>
						</th>
					</tr>
				</c:if>
		
		</table>
		
	</div>
</form>	
</c:if>
</body>
</html>
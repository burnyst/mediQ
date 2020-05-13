<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mediQ</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
</head>
<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
	<div class="search">
	    <form method="get" action="search.do">
	        <label>의약품 검색</label>
	        <input type="text" name="productName" value="${productName}" />
	        <input type="submit" value=" 조회 " />
	    </form>
	</div>
	<c:if test="${productName != null && !productName.isEmpty()}">
		<div class="items">
		    <h3>검색결과</h3>
		    <table class="items">
		    	<thead>
			        <tr>
			        	<th>선택</th>
			            <th>업체명</th>
			            <th>품목명</th>
			            <th>전문일반</th>
			            <th>성상</th>
			        </tr>
		        </thead>
		        <tbody>
			        <c:if test="${page == null || page.totalCount == 0}">
						<tr>
							<td colspan="5">조회된 결과가 없습니다</td>
						</tr>
					</c:if>
					<c:if test="${page != null && page.totalCount > 0}">
						<c:forEach var="i" items="${page.content}">
							<tr class="row">
								<td><input type="checkbox" name="" value="${i.itemSeq}" /></td>
								<td>${i.entpName}</td>
								<td>${i.itemName}</td>
								<td>${i.etcOtcCode}</td>
								<td>${i.chart}</td>
							</tr>
					        <tr class="hidden">
					            <td colspan="5">
					            	<table>
						                <h4>효능효과</h4>
						                <p>${i.eeDocData}</p>
						                <h4>용법용량</h4>
						                <p>${i.udDocData}</p>
						                <h4>주의사항(일반)</h4>
						                <p>${i.nbDocData}</p>
					                </table>
					            </td>
					        </tr>
						</c:forEach>
					</c:if>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="5">
							<c:if test="${page != null && page.totalCount > 0}">
								<c:if test="${page.startPage > 5}">
									<a href="search.do?productName=${productName}&pageNo=${page.startPage - 5}">[이전]</a>
								</c:if>
								<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
									<c:if test="${page.currentPage == i}">
										${i}
									</c:if>
									<c:if test="${page.currentPage != i}">
										<a href="search.do?productName=${productName}&pageNo=${i}">${i}</a>
									</c:if>
								</c:forEach>
								<c:if test="${page.endPage < page.totalPages}">
									<a href="search.do?productName=${productName}&pageNo=${page.startPage}">[다음]</a>
								</c:if>
							</c:if>
						</th>
					</tr>
				</tfoot>
		    </table>
		</div>
	</c:if>
	<jsp:include page="/view/footer.jsp"></jsp:include>
</body>
</html>
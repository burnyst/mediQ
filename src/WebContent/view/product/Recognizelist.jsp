<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mediQ</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mediq.css" />
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
   <script src="${pageContext.request.contextPath}/js/search.js"></script>
</head>
<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
	<div class="search">
		<form method='get' action="recognize.do">		
			<p>승인 의약품 검색</p>
			<input type='text' id='MessageBox' class="text" name="itemname" value="${itemname}"/>
			<input type="submit" value="검색"/>
		</form>
	</div>
	<c:if test="${itemname != null && !itemname.isEmpty()}">
		<div class="items">
	<br>승인의약품 검색 결과</br>
	<hr/>
		<div class="result">
		<h2>검색 결과</h2>
		<br/>
		  <form method="post" action="#">
			    <div class="clearfix">
				    <span class="float-right">
   				    </span>
			    </div>
			    <hr/>
  				<table border=1>
			    	<colgroup>
			    		<col class="col1" />
			    		<col class="col2" />
			    		<col class="col3" />
			    		<col class="col4" />
			    	</colgroup>
			    	<thead>
				        <tr>
				        	<td>업체명</td>
				            <td>품목명</td>
				            <td>전문일반</td>
				            <td>승인일자</td>

				        </tr>
			        </thead>	 
			        <c:if test="${page == null || page.totalCount == 0}">
						<tbody>
							<tr>
								<td colspan="4">조회된 결과가 없습니다</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th colspan="4">1</th>
							</tr>
						</tfoot>
 						</c:if>
 						<c:if test="${page != null && page.totalCount > 0}">
			        	<tbody>
	 				<c:forEach var="md" items="${page.content}">
	 				<tr>
						<td class="center">${md.entpName}</td>
						<td class="center">${md.itemName}</td>
						<td class="center">${md.etcOtcCode}</td>
						<td class="center">${md.itemPermitDate}</td>
           		
					</tr>
 						<!-- <tr class="hidden"> -->
 						<td colspan="4">
						<div class="content">
 						<table>
 						<colgroup>
           				</colgroup>
	 						<h4>주의사항</h4>
	 						<pre>${md.nbDocData}</pre>
 					  </table>
    	            </div>
	            </td>
	        </tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="5">
									<c:if test="${page.startPage > 5}">
										<a href="search.do?searchWord=${searchWord}&pageNo=${page.startPage - 5}">[이전]</a>&nbsp;
									</c:if>
									<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
										<c:if test="${page.currentPage == i}">
											${i}&nbsp;
										</c:if>
										<c:if test="${page.currentPage != i}">
											<a href="search.do?searchWord=${searchWord}&pageNo=${i}">${i}</a>&nbsp;
										</c:if>
									</c:forEach>
									<c:if test="${page.endPage < page.totalPages}">
										<a href="search.do?searchWord=${searchWord}&pageNo=${page.startPage + 5}">[다음]</a>
									</c:if>
								</th>
							</tr>
						</tfoot>
					</c:if>
				</table>
				</form>
			</div>
</c:if>
<jsp:include page="/view/footer.jsp"></jsp:include>
</body>
</html>
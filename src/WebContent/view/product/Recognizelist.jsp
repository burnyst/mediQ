<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
	     
	        <label>승인 의약품 검색</label>
			<input type='text' id='MessageBox' class="text" name="itemname" value="${itemname}"/>
			<input type="submit" value="검색"/>
		</form>
	</div>
	<c:if test="${itemname != null && !itemname.isEmpty()}">
		<div class="items">
	<br/>
	승인의약품 검색 결과
	<br/>
	<hr/>
		    <form method="post" action="#">
			    <div class="clearfix">
				    <span class="float-right">
   				    </span>
			    <hr/>
			    </div>
  				<table>
			    	<colgroup>
			    		
			    		<col class="col1" />
			    		<col class="col2" />
			    		<col class="col3" />
			    		<col class="col4" />
			    	</colgroup>
			    	<thead width=1024px>
				        <tr>
				        	<td class="center" colspan="2">업체명</td>
				            <td class="center">품목명</td>
				            <td class="center">전문일반</td>
				            <td class="center">승인일자</td>
				        </tr>
			        </thead>	 
			        <c:if test="${page == null || page.totalCount == 0}">
						<tbody>
							<tr>
								<td colspan="5">조회된 결과가 없습니다</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th colspan="5">1</th>
							</tr>
						</tfoot>
 						</c:if>
 						<c:if test="${page != null && page.totalCount > 0}">
			        	<tbody>
	 				<c:forEach var="i" items="${page.content}">
	 				<tr>
						<td class="center" colspan="2">${i.entpName}</td>
						<td class="center">${i.itemName}</td>
						<td class="center">${i.etcOtcCode}</td>
						<td class="center">${i.itemPermitDate}</td>
           		
					</tr>
 						<tr class="hidden">
 						<td colspan="5">
						<div class="content">
 						<table>
 						<colgroup>
           				</colgroup>
	 						<h4>주의사항</h4>
	 						<pre>${i.nbDocData}</pre>
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
										<a href="recognize.do?itemname=${itemname}&pageNo=${page.startPage - 5}">[이전]</a>
									</c:if>
									<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
										<c:if test="${page.currentPage == i}">
											${i}
										</c:if>
										<c:if test="${page.currentPage != i}">
											<a href="recognize.do?itemname=${itemname}&pageNo=${i}">${i}</a>
										</c:if>
									</c:forEach>
									<c:if test="${page.endPage < page.totalPages}">
										<a href="recognize.do?itemname=${itemname}&pageNo=${page.startPage + 5}">[다음]</a>
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
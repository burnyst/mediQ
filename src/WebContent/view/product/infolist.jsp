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
		<form method='get' action="infosearch.do">		
			<label>의약품 리스트</label>
			<input type='text' id='MessageBox' class="text" name="itemname" value="${itemname}"/>
			<input type="submit" value="검색"/>
		</form>
		</div>
		<c:if test="${itemname != null && !itemname.isEmpty()}">
		<div class="items">
		<hr/>
		<h2>의약품리스트 검색 결과</h2>
		<hr/>
			    <form method="post" action="#">
			    <div class="clearfix">
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
							<td colspan="2">품목명</td>
							<td>업체명</td>
							<td>전문일반</td>
							<td>성상</td>
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
			<tr >
			<td colspan="2"><a href="inforead.do?itemName=${i.itemName}">${i.itemName}</a></td>
			<td>${i.entpName}</td>
			<td>${i.etcOtcCode}</td>
			<td>${i.chart}</td>
			</tr>
        		<tr class="hidden">
					<td colspan="5">
						<div class="content">
 						<table>
	 					
	 					<colgroup>
           				</colgroup>

	 						<h4>품목기준코드</h4>
	 						<pre>${i.itemSeq}</pre>
	 						<h4>허가일자</h4>
	 						<pre>${i.itemPermitDate}</pre>
	 						<h4>주의사항</h4>
	 						<pre>${i.nbDocData}</pre>
	 						<h4>취소일자</h4>
	 						<pre>${i.cancelDate}</pre>
	 						<h4>효능효과</h4>
	 						<pre>${i.eeDocData}</pre>
	 						<h4>용법용량</h4>
	 						<pre>${i.udDocData}</pre>
	 						<h4>변경일자</h4>
	 						<pre>${i.changeDate}</pre>
	 						<h4>분류</h4>
	 						<pre>${i.classNo}</pre>
	 						<h4>성상</h4>
	 						<pre>${i.chart}</pre>
	 						<h4>포장단위</h4>
	 						<pre>${i.packUnit}</pre>
						</tr>
 					  </table>
			     </div>
	            </td>
	        </tr>
		</c:forEach>
			</tbody>



</hr>
<tr>
			<th colspan="5">
				<c:if test="${page.startPage > 5}">
					<a href="infosearch.do?itemname=${itemname}&pageNo=${page.startPage - 5}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
					<c:if test="${page.currentPage == i}">
						${i}
					</c:if>
					<c:if test="${page.currentPage != i}">
						<a href="infosearch.do?itemname=${itemname}&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${page.endPage < page.totalPages}">
					<a href="infosearch.do?itemname=${itemname}&pageNo=${page.startPage + 5}">[다음]</a>
				</c:if>
			</th>

		</tr>
	</tfoot>

	
</c:if>
</table>
</form>
</div>
</c:if>
<hr/>
<form method='get' action="plusinfo.do">
	<span class="float-right">
		<input type="submit" id="plus" name="plus" value="추가"/>
	</span>
</form>
<jsp:include page="/view/footer.jsp"></jsp:include>
</body>
</html>
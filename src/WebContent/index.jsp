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
	    <form method="get" action="search.do">
	        <label>의약품 검색</label>
	        <input type="text" name="searchWord" value="${searchWord}" />
	        <input type="submit" value="검색" />
	    </form>
	</div>
	<c:if test="${searchWord != null && !searchWord.isEmpty()}">
		<div class="items">
		    <label>검색결과</label>
		    <hr />
		    <form method="post" action="#">
			    <div class="clearfix">
				    <span class="float-right">
					    <button class="selectAll">전체 선택</button>
					    <input type="submit" value="선택 저장" />
				    </span>
			    </div>
			    <hr />
			    <table>
			    	<colgroup>
			    		<col class="col1" />
			    		<col class="col2" />
			    		<col class="col3" />
			    		<col class="col4" />
			    		<col class="col5" />
			    	</colgroup>
			    	<thead>
				        <tr>
				        	<th></th>
				            <th>업체명</th>
				            <th>품목명</th>
				            <th>전문일반</th>
				            <th>성상</th>
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
									<td class="center"><input type="checkbox" name="key" value="${i.itemSeq}" size="20" /></td>
									<td class="hasDetail">${i.entpName}</td>
									<td class="hasDetail">${i.itemName}</td>
									<td class="hasDetail">${i.etcOtcCode}</td>
									<td class="hasDetail">${i.chart}</td>
								</tr>
						        <tr class="hidden">
						            <td colspan="5">
						            	<div class="content">
							            	<table>
							            		<colgroup>
							            		</colgroup>
								                <h4>효능효과</h4>
								                <pre>${i.eeDocData}</pre>
								                <h4>용법용량</h4>
								                <pre>${i.udDocData}</pre>
								                <h4>주의사항(일반)</h4>
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
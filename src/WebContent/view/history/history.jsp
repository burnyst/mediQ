<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<t:head title="메디큐">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/history.js"></script>
</t:head>
<t:body>
	<h2>검색이력</h2>
	<hr />
	<div class="items">
	    <form method="post" action="${pageContext.request.contextPath}/history.do">
		    <div class="clearfix">
			    <span class="float-right">
				    <button class="selectAll">전체 선택</button>
				    <input type="submit" value="선택 삭제" />
			    </span>
		    </div>
		    <hr />
		    <table>
		    	<colgroup>
		    		<col class="productListCol1" />
		    		<col class="productListCol2" />
		    		<col class="productListCol3" />
		    		<col class="productListCol4" />
		    		<col class="productListCol5" />
		    		<col class="productListCol6" />
		    	</colgroup>
		    	<thead>
			        <tr>
			        	<th></th>
			            <th>업체명</th>
			            <th>품목명</th>
			            <th>전문일반</th>
			            <th>성상</th>
			            <th>등록일</th>
			        </tr>
		        </thead>
		        <c:if test="${page == null || page.totalCount == 0}">
					<tbody>
						<tr>
							<td colspan="6">조회된 결과가 없습니다</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th colspan="6">1</th>
						</tr>
					</tfoot>
				</c:if>
				<c:if test="${page != null && page.totalCount > 0}">
		        	<tbody>
						<c:forEach var="i" items="${page.content}">
							<tr>
								<td class="center"><input type="checkbox" name="itemSeq" value="${i.itemSeq}" size="20" /></td>
								<td class="hasDetail">${i.entpName}</td>
								<td class="hasDetail">${i.itemName}</td>
								<td class="hasDetail">${i.etcOtcCode}</td>
								<td class="hasDetail">${i.chart}</td>
								<td class="hasDetail">${i.rdate}</td>
							</tr>
					        <tr class="hidden">
					            <td colspan="6">
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
							<th colspan="6">
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
</t:body>
</html>
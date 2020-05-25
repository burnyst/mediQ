<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<t:head title="뉴스게시판 메인페이지">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<meta charset="UTF-8">
		<style>
		h2{
		text-align: center;
		border:15px;
		}
		#register{
		 float: right;
		}
		table {
			border-collapse: collapse;
			width: 80%;
			margin: auto;
		  text-align: center;
		  
			}
		th{
		background: gray;
		color: white;
		}		
		</style>
</t:head>
<t:body>
		<h2>뉴스 게시판</h2><br/> 
		<div class="search">
		<form method="get" action="newssearch.do">
		<label>제목을 검색하세요</label>	
		<input type=text id="keyword1" name="keyword1"  />
		<input type="submit" value="검색" > 
		</form>
		</div>
		<c:if test="${user.mlevel==2}">
		<div>
		<input type="button" id="register" value="등록" onclick="location.href='${pageContext.request.contextPath}/newswrite.do'">
		</div>
		</c:if>
		<div class="table">
		<form>
		<hr>
		<h4> 총 ${newsPAGE.totalCount} ${newsSearchPAGE.total} 건</h4>
		
			<table class="table table-striped" border="1" >
			<tr>
						<th width="10%">번호</th>
						<th width="25%">제목</th>
						<th width="25%">기사요약정보</th>
						<th width="10%">언론사명</th>
						<th width="15%">아이디</th>
						<th width="15%">등록일자</th>
			</tr>
			<c:if test="${newsPAGE.hasNoNews()}">
				<tr>
					<td colspan="6">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if> 
			<c:forEach  var="news" items="${newsPAGE.content}">
				<tr>
						<%-- ${news.sn} 은 News클래스의 get sn()메소드를 호출 --%>
						<td>${news.sn }</td>
						<td><a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/newsdetail.do?title=${news.title}&pageNo=${newsPAGE.currentPage}&sn=${news.sn}">${news.title}</a></td>
						<td style="border: 1px solid black; max-width: 300px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
						${news.summary }</td>
						<td>${news.press }</td>
						<td>${news.mid }</td>
						<td><fmt:formatDate value="${news.rdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach> 
			<c:if test="${newsPAGE.hasNews()}">
					<tr>
						<th  colspan="6" >
							<c:if test="${newsPAGE.startPage>10}">
							<a href="newslist.do?pageNo=${newsPAGE.startPage-10}">[이전]</a>
							</c:if>
							<c:forEach var="pNo" 
				           begin="${newsPAGE.startPage}" 
				           end="${newsPAGE.endPage}">
						<a href="newslist.do?pageNo=${pNo}">[${pNo}]</a>
						</c:forEach>
														
							<c:if test="${newsPage.endPage<newsPAGE.totalPages}">
							<a href="newslist.do?pageNo=${newsPAGE.startPage+10}">[다음]</a>
							</c:if>
						</th>
				</tr>
				</c:if> 
<!--research 영역  -->
			<c:if test="${newsSearchPAGE.hasNoNews()}">
				<tr>
					<td colspan="6">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if> 
			<c:forEach  var="news" items="${newsSearchPAGE.search}">
				<tr>
						<%-- ${news.sn} 은 News클래스의 get sn()메소드를 호출 --%>
						<td>${news.sn }</td>
						<td><a href="${pageContext.request.contextPath}/newsdetail.do?sn=${news.sn}">${news.title }</a></td>
						<td style="border: 1px solid black; max-width: 300px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
								${news.summary}</td>
						<td>${news.press }</td>
						<td>${news.mid }</td>
						<td><fmt:formatDate value="${news.rdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach> 
		</table>
		</form>
		</div>			
</t:body>
</html>
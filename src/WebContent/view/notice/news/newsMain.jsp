<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스게시판 메인페이지</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
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

</style>

</head>
<body>
		<h2>뉴스 게시판</h2><br/> 
		<div class="search">
		<form method="get" action="newssearch.do">
		<label>제목을 검색하세요</label>	
		<input type=text id="keyword1" name="keyword1"  />
		<input type="submit" value="검색" > 
		</form>
		</div>
		<div>
		<input type="button" id="register" value="등록" onclick="location.href='${pageContext.request.contextPath}/newswrite.do'">
		</div>
		<div class="items">
		<form>
		<hr>
		<h4> 총 ${newsPAGE.totalCount} ${newsSearchPAGE.total} 건</h4>
		
			<table class="table table-striped" border="1" >
			<tr>
						<th width="10%">번호</th>
						<th width="30%">제목</th>
						<th width="30%">기사요약정보</th>
						<th width="10%">언론사명</th>
						<th width="10%">아이디</th>
						<th width="10%">등록일자</th>
			</tr>
			<c:if test="${newsPAGE.hasNoNews()}">
				<tr>
					<td colspan="6">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if> 
			<c:forEach  var="news" items="${newsPAGE.content}">
				<tr>
						<%-- ${news.sn} 은 News클래스의 get sn()메소드를 호출 --%>
						<th>${news.sn }</th>
						<th><a href="${pageContext.request.contextPath}/newsdetail.do?title=${news.title}&pageNo=${newsPAGE.currentPage}&sn=${news.sn}">${news.title}</a></th>
						<th style="border: 1px solid black; max-width: 300px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
						${news.summary }</th>
						<th>${news.press }</th>
						<th>${news.mid }</th>
						<th>${news.rdate }</th>
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
			<c:if test="${newssearchPAGE.hasNoNews()}">
				<tr>
					<td colspan="6">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if> 
			<c:forEach  var="news" items="${newsSearchPAGE.search}">
				<tr>
						<%-- ${news.sn} 은 News클래스의 get sn()메소드를 호출 --%>
						<th>${news.sn }</th>
						<th><a href="${pageContext.request.contextPath}/newsdetail.do?sn=${news.sn}">${news.title }</a></th>
						<th style="border: 1px solid black; max-width: 300px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
								${news.summary}</th>
						<th>${news.press }</th>
						<th>${news.mid }</th>
						<th>${news.rdate }</th>
				</tr>
			</c:forEach> 



		</table>
		</form>
		</div>
						
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        .page_body{width:80%; margin:0px 10% 0px 10%;}
        #category{float:left;}
        #fsearch{float:right;}
        #fboard_list{clear:both;}
        th{padding:13px 0 12px 0; background:gray;}
        #pageBtn{text-align:center;}
        #writebtn{float:right; margin-top:25%;}
        tr{text-align:center;}
        a{text-decoration:none; color:black;}
        table{margin-top:30px;}
        #writeBtn{float:right;}
        .hidden{display:none;}
        .page{clear:both; text-align:center;}
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/faq.js" charset='euc-kr'></script>

</head>
<body>
<h1>FAQ</h1>
<hr/><br/>
<div class="page_body">
    <div class="board_search">
        <select name="category" id="category" onchange="if(this.value) location.href=(this.value);">
            <option value="선택">선택</option>
            <option value="${pageContext.request.contextPath}/faqcategory.do?category=로그인">로그인</option>
            <option value="${pageContext.request.contextPath}/faqcategory.do?category=약품 정보">약품 정보</option>
            <option value="${pageContext.request.contextPath}/faqcategory.do?category=기타">기타</option>
        </select>
        <form name="fsearch" id="fsearch" method="get" action="faqsearch.do">
            <input type="text" name="search" id="search">
            <input type="submit" value="검색" class="btn_submit">
        </form>
    </div>
    <div id="fboard_list"><br/>
    	<table cellpadding="0" cellspacing="0" board="1" width="100%" class="result">
    		<thead>
    			<tr>
    				<th width="10%">번호</th>
    				<th width="35%">제목</th>
    				<th width="10%">글쓴이</th>
    				<th width="10%">날짜</th>
    				<th width="10%">카테고리</th>
    				<th width="5%">조회</th>
    			</tr>
    		</thead>
    			<c:if test="${ faqSearchPage.hasNoFaq()}">
	    			<tr>
	    				<td colspan="6">게시글이 존재하지 않습니다</td>
	   				</tr>
    			</c:if>
				<c:forEach var="faq" items="${faqSearchPage.searchlist}">
	    			<tr class="row">
	    				<td>${faq.sn}</td>
	    				<td>${faq.title}</td>
	    				<td>${faq.mid}</td>
	    				<td>${faq.rdate}</td>
	    				<td>${faq.category}</td>
	    				<td>${faq.vcount}</td>
	    			</tr>
	    			<tr class="hidden">
	    				<td colspan="6">
	    					<p>${faq.contents}</p>
	    					<%-- <c:if test=""> --%>
	    						<form action="${pageContext.request.contextPath}/faqupdate.do">
		    						<input type="hidden" name="sn" value="${faq.sn}"/>
		    						<input type="hidden" name="title" value="${faq.title}"/>
		    						<input type="hidden" name="contents" value="${faq.contents}"/>
									<input type="hidden" name="category" value="${faq.category}"/>
									<input type="hidden" name="mid" value="${faq.mid}"/>
	    							<input type="submit" id="modifyBtn" name="modifyBtn" value="수정"/>
	    						</form>
	    						<a href="${pageContext.request.contextPath}/faqdelete.do">
	    						<input type="button" id="deleteBtn"  name="deleteBtn" value="삭제" onclick="f1()"/>
	    						</a>
	    					<%-- </c:if> --%>
	    				</td>
	   				</tr>
				</c:forEach>
				<%-- <c:if test=""> --%>
				<tr>
					<td colspan="6"><a href="${pageContext.request.contextPath}/faqinsert.do"><input type="button"  id="writeBtn" value="글쓰기"/></a></td>
				</tr>
			</table>
			<%-- </c:if> --%>
			<!--  페이징 처리 -->
			<c:if test="${faqSearchPage.hasFaq() }">
				<tr class="page">
					<td colspan="6">
						<c:if test="${faqSearchPage.startPage>5 }">
							<a href="${pageContext.request.contextPath}/faqsearch.do?pageNo=${ faqSearchPage.startpage-5 }&search=${faqSearchPage.search}">[이전]</a>
						</c:if>
					
						<c:forEach var="pNo" begin="${ faqSearchPage.startPage }" end="${ faqSearchPage.endPage }">
							<a href="${pageContext.request.contextPath}/faqsearch.do?pageNo=${pNo }&search=${faqSearchPage.search}">[${pNo}]</a>
						</c:forEach>
						
						<c:if test="${faqSearchPage.endPage<faqSearchPage.totalPages }">
							<a href="${pageContext.request.contextPath}faqsearch.do?pageNo=${faqSearchPage.startpage+5 }&search=${faqSearchPage.search}">[다음]</a>
						</c:if>
					</td>
				</tr>
			</c:if>
   	</div>
 </div>
</body>
</html>
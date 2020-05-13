<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="../js/faq.js" charset='euc-kr'></script>
</head>
<body>

<h1>FAQ</h1>
<hr/><br/>
<div class="page_body">
    <div class="board_search">
        <select name="category" id="category" onchange="if(this.value) location.href=(this.value);">
            <option value="선택">선택</option>
            <option value="faqList.jsp?category=로그인">로그인</option>
            <option value="faqList.jsp?category=약품 정보"><a href="#">약품 정보</a></option>
            <option value="faqList.jsp?category=기타"><a href="#">기타</a></option>
        </select>
        <form name="fsearch" id="fsearch" method="get" action="faqList.jsp">
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
    			<c:if test="${ faqPage.hasNoArticles() }">
	    			<tr>
	    				<td colspan="6">게시글이 존재하지 않습니다</td>
	   				</tr>
    			</c:if>
				<c:forEach var="faq" items="${faqPage.content }">
    			<tr class="row">
    				<td>${faq.sn }</td>
    				<td>${ faq.title }</td>
    				<td>${faq.writer }</td>
    				<td>${faq.rdate }</td>
    				<td>${faq.category }</td>
    				<td>${faq.vcount }</td>
    			</tr>
    			<tr class="hidden">
    				<td colspan="6">
    					<p>${faq.contents}</p>
    					<%-- <c:if test=""> --%>
    					<form method="post" action="./insertfaq.jsp">
    						<input type="submit" id="modifyBtn" name="modifyBtn" value="수정"/>
    						<input type="button" id="deleteBtn"  name="deleteBtn" value="삭제" onclick="f1()"/>
    					</form>
    					<%-- </c:if> --%>
    				</td>
   				</tr>
				</c:forEach>
   				<tr class="row">
    				<td>번호</td>
    				<td>제목</td>
    				<td>글쓴이</td>
    				<td>작성일</td>
    				<td>카테고리</td>
    				<td>조회수</td>
    			</tr>
    			<tr class="hidden">
    				<td colspan="6">
    					<p>내용</p>
    					<form method="post" action="./insertfaq.jsp">
    						<input type="submit" id="modifyBtn" name="modifyBtn" value="수정"/>
    						<input type="button" id="deleteBtn"  name="deleteBtn" value="삭제" onclick="f1()"/>
    					</form>
    				</td>
   				</tr>
				<%-- <c:if test=""> --%>
				<tr>
					<td colspan="6"><a href="./insertfaq.jsp"><input type="button"  id="writeBtn" value="글쓰기"/></a></td>
				</tr>
				<%-- </c:if> --%>
				<!--  페이징 처리 -->
				<c:if test="${ faqPage.hasAticles() }">
				<tr>
					<td colspan="6">
						<c:if test="${faqPage.startPage>5 }">
							<a href="faqlist.jsp?pageNo=${ faqPage.startpage-5 }">[이전]</a>
						</c:if>
						
						<c:forEach var="pNo" begin="${ faqPage.startPage }" end="${ faqPage.endPage }">
							<a href="faqlist.jsp?pageNo=${pNo }">[${pNo}]</a>
						</c:forEach>
						
						<c:if test="${faqPage.endPage<faqPage.totalPages }">
							<a href="faqlist.jsp?pageNo=${faqPage.startpage+5 }">[다음]</a>
						</c:if>
					</td>
				</tr>
			</c:if>
    	</table>
   	</div>
</body>
</html>
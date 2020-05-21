<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>
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
        .page{clear:both;}
        #modify{display:inline;}
        textarea{display:block; text-align:center;}
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/faq.js?version=20200519" type="text/javascript" charset='euc-kr'></script>
</head>
<body>
<%
	User authUser = null;
	try {
		authUser = Controller.getAuthUser(request);
		pageContext.setAttribute("authUser", authUser);
	} catch (NotLoginException e) {
	}
%>
<jsp:include page="../../header.jsp"></jsp:include>
<h1>FAQ</h1>
*총 ${faqCategoryPage.categorytotal}건<br/>
<hr/><br/>
 <div class="page_body">
    <div class="board_search">
        <select name="category" id="category" onchange="if(this.value) location.href=(this.value);">
            <c:if test="${faqCategoryPage.category == null}">
            	<option value="${pageContext.request.contextPath}/faqlist.do" selected>전체선택</option>
            	<option value="${pageContext.request.contextPath}/faqcategory.do?category=로그인">로그인</option>
            	<option value="${pageContext.request.contextPath}/faqcategory.do?category=약품 정보">약품 정보</option>
            	<option value="${pageContext.request.contextPath}/faqcategory.do?category=기타">기타</option>
            </c:if>
           <c:if test="${faqCategoryPage.category == '로그인'}">
           	<option value="${pageContext.request.contextPath}/faqlist.do">전체선택</option>
       		<option value="${pageContext.request.contextPath}/faqcategory.do?category=로그인" selected>로그인</option>
       		<option value=" ${pageContext.request.contextPath}/faqcategory.do?category=약품 정보" >약품 정보</option>
          	<option value="${pageContext.request.contextPath}/faqcategory.do?category=기타">기타</option>
          </c:if>
          <c:if test="${faqCategoryPage.category == '약품 정보'}">
          	<option value="${pageContext.request.contextPath}/faqlist.do">전체선택</option>
          	<option value="${pageContext.request.contextPath}/faqcategory.do?category=로그인" >로그인</option>
  			<option value="${pageContext.request.contextPath}/faqcategory.do?category=약품 정보" selected>약품 정보</option>
  			<option value="${pageContext.request.contextPath}/faqcategory.do?category=기타">기타</option>
          </c:if>
          <c:if test="${faqCategoryPage.category == '기타'}">
          	<option value="${pageContext.request.contextPath}/faqlist.do">전체선택</option>
          	<option value="${pageContext.request.contextPath}/faqcategory.do?category=로그인" >로그인</option>
          	<option value=" ${pageContext.request.contextPath}/faqcategory.do?category=약품 정보" >약품 정보</option>
          	<option value="${pageContext.request.contextPath}/faqcategory.do?category=기타" selected>기타</option>
          </c:if>
        </select>
        <form name="fsearch" id="fsearch" method="get" action="faqsearch.do?">
        	<input type="hidden" name="category" id="category" value="${faqCategoryPage.category}"/>
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
    		<c:if test="${ faqCategoryPage.hasNoFaq()}">
	    			<tr>
	    				<td colspan="6">게시글이 존재하지 않습니다</td>
	   				</tr>
    			</c:if>
				<c:forEach var="faq" items="${faqCategoryPage.categorylist}">
	    			<tr class="row">
	    				<td>${faq.sn}</td>
	    				<td><a href="faqccount.do?sn=${faq.sn}&category=${faq.category}&mid=${authUser.mid}">${faq.title}</a></td>
	    				<td>${faq.mid}</td>
	    				<td>${faq.rdate}</td>
	    				<td>${faq.category}</td>
	    				<td>${faq.vcount}</td>
	    			</tr>
	    			<tr class="hidden">
	    				<td colspan="6">
	    					<u:pre value="${faq.contents}"/><br/><br/>
	    					<c:if test="${authUser.mlevel>1}">
	    						<form id="modify" name="modify" action="${pageContext.request.contextPath}/faqupdate.do">
		    						<input type="hidden" name="sn" value="${faq.sn}"/>
		    						<input type="hidden" name="title" value="${faq.title}"/>
		    						<input type="hidden" name="contents" value="${faq.contents}"/>
									<input type="hidden" name="category" value="${faq.category}"/>
									<input type="hidden" name="mid" value="${authUser.mid}"/>
	    							<input type="submit" id="modifyBtn" name="modifyBtn" value="수정"/>
	    						</form>
	    						<a href="${pageContext.request.contextPath}/faqdelete.do">
	    						<input type="button" id="deleteBtn"  name="deleteBtn" value="삭제" onclick="f1()"/>
	    						</a>
	    					</c:if>
	    				</td>
	   				</tr>
	   				<c:if test="${faq.sn== faqVcount.sn}">
	    			<tr class="">
	    				<td colspan="6" class="contentView">
	    					<u:pre value="${faq.contents}"/><br/><br/>
	    					<c:if test="${authUser.mlevel>1}">
	    						<form id="modify" name="modify" action="${pageContext.request.contextPath}/faqupdate.do">
		    						<input type="hidden" name="sn" value="${faq.sn}"/>
		    						<input type="hidden" name="title" value="${faq.title}"/>
		    						<input type="hidden" name="contents" value="${faq.contents}"/>
									<input type="hidden" name="category" value="${faq.category}"/>
									<input type="hidden" name="mid" value="${authUser.mid}"/>
	    							<input type="submit" id="modifyBtn" name="modifyBtn" value="수정"/>
	    						</form>
	    						<a href="${pageContext.request.contextPath}/faqdelete.do?sn=${faq.sn}">
	    						<input type="button" id="deleteBtn"  name="deleteBtn" value="삭제" onclick="f1()"/>
	    						</a>
	    					</c:if>
	    				</td>
	   				</tr>
	   				</c:if>
				</c:forEach>
				<c:if test="${authUser.mlevel>1}">
				<tr>
					<td colspan="6"><a href="${pageContext.request.contextPath}/faqinsert.do?mid=${authUser.mid}"><input type="button"  id="writeBtn" value="글쓰기"/></a></td>
				</tr>
				</c:if>
				<%-- </c:if> --%>
				<!--  페이징 처리 -->
				<c:if test="${faqCategoryPage.hasFaq() }">
				<tr class="page">
					<td colspan="6">
						<c:if test="${faqCategoryPage.startPage>5 }">
							<a href="${pageContext.request.contextPath}/faqcategory.do?pageNo=${ faqCategoryPage.startpage-5 }&category=${faqCategoryPage.category}">[이전]</a>
						</c:if>
					
						<c:forEach var="pNo" begin="${ faqCategoryPage.startPage }" end="${ faqCategoryPage.endPage }">
							<a href="${pageContext.request.contextPath}/faqcategory.do?pageNo=${pNo }&category=${faqCategoryPage.category}">[${pNo}]</a>
						</c:forEach>
						
						<c:if test="${faqCategoryPage.endPage<faqCategoryPage.totalPages }">
							<a href="${pageContext.request.contextPath}faqcategory.do?pageNo=${faqPage.startpage+5 }&category=${faqCategoryPage.category}">[다음]</a>
						</c:if>
					</td>
				</tr>
			</c:if>
			<jsp:include page="../../footer.jsp"></jsp:include>
    	</table>
   	</div>
 </div>
</html>
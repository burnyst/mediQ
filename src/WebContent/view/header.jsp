<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
<%
	User authUser = null;
	try {
		authUser = Controller.getAuthUser(request);
		pageContext.setAttribute("authUser", authUser);
	} catch (NotLoginException e) {
	}
%>
<div class="nav">
	<h1>mediQ</h1>
	<a href="${pageContext.request.contextPath}/search.do">의약품검색</a>
	<div class="subnav">
		<div class="subnavbtn"><a href="${pageContext.request.contextPath}/history.do">마이페이지</a></div>
		<div class="subnav-content">
			<a href="${pageContext.request.contextPath}/history.do">검색이력</a>
			<a href="${pageContext.request.contextPath}/myinfo.do">내정보</a>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/faqlist.do">FAQ</a>
	<div class="subnav">
		<div class="subnavbtn"><a href="${pageContext.request.contextPath}/newslist.do">공지사항</a></div>
		<div class="subnav-content">
			<a href="${pageContext.request.contextPath}/newslist.do">뉴스레터</a>
			<a href="${pageContext.request.contextPath}/recognize.do">허가공고</a>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/qnalist.do">Q&A</a>
	<c:if test="${authUser == null}">
		<a class="small" href="${pageContext.request.contextPath}/join.do">회원가입</a>
		<a class="small" href="${pageContext.request.contextPath}/login.do">로그인</a>
	</c:if>
	<c:if test="${authUser != null}">
		<c:if test="${authUser.mlevel > 1}">
			<div class="subnav">
				<div class="subnavbtn"><a href="${pageContext.request.contextPath}/memberlist.do">관리자</a></div>
				<div class="subnav-content">
					<a href="${pageContext.request.contextPath}/memberlist.do">회원관리</a>
					<a href="${pageContext.request.contextPath}/infolist.do">의약품관리</a>
				</div>
			</div>
		</c:if>
		<a class="small" href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
	</c:if>
</div>
<br />
<br />
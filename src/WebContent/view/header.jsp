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
<header>
	<h1>mediQ</h1>
	<nav>
		<ul>
		    <li><a href="${pageContext.request.contextPath}/search.do">의약품검색</a></li>
		    <li><a href="${pageContext.request.contextPath}/history.do">마이페이지</a></li>
		    <li><a href="/mediq/faqlist.do">FAQ</a></li>
		    <li><a href="#">공지사항</a></li>
		    <li><a href="#">Q&A</a></li>
			<li class="small"><a href="#">회원가입</a></li>
			<li class="small">
				<c:if test="${authUser == null}"><a href="${pageContext.request.contextPath}/login.do">로그인</a></c:if>
				<c:if test="${authUser != null}"><a href="${pageContext.request.contextPath}/logout.do">로그아웃</a></c:if>
			</li>
		</ul>
	</nav>
</header>
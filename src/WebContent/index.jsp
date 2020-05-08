<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mediQ</title>
    <link rel="stylesheet" type="text/css" href="./css/search.css" />
    <script src="../js/search.js"></script>
</head>
<body>
	<ul>
		<li><h1>mediQ</h1></li>
	    <li><a href="#">의약품검색</a></li>
	    <li><a href="#">마이페이지</a></li>
	    <li><a href="#">FAQ</a></li>
	    <li><a href="#">공지사항</a></li>
	    <li><a href="#">Q&A</a></li>
	</ul>
	<div class="search">
	    <form method="get" action="#">
	        <label>의약품 검색</label>
	        <input type="text" name="pname" />
	        <input type="submit" value=" 조회 " />
	    </form>
	</div>
</body>
</html>
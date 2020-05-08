<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mediQ</title>
    <style>
    	body {
    		margin: 0;
    	}
    	h1 {
    		padding: 0px 40px;
    	}
        ul {
            background-color: DodgerBlue;
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        li {
            color: White;
            display: inline-block;
            font-size: 20px;
            padding: 0px 20px;
        }
        a {
            color: white;
            text-decoration: none;
        }
        .search {
        	padding: 40px 0px;
            text-align: center;
        }
        .search label {
        	padding: 40px;
        	font-weight: bold;
        	font-size: 24px;
        }
        .search input[type="text"] {
        	padding: 5px;
        	font-size: 20px;
        	margin: 0px;
        }
        .search input[type="submit"] {
        	font-size: 20px;
        	margin: 0px;
        	padding: 4px;
        }
    </style>
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
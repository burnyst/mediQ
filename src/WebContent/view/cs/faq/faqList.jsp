<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
    <style>
        .page_body{width:80%; margin:0px 10% 0px 10%;}
        #category{float:left;}
        #fsearch{float:right;}
        #fboard_list{clear:bo	th;}
        th{padding:13px 0 12px 0; background:gray;}
        #pageBtn{text-align:center;}
        #writebtn{float:right; margin-top:25%;}
        tr{text-align:center;}
        a{text-decoration:none; color:black;}
        table{margin-top:30px;}
    </style>
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
    	<table cellpadding="0" cellspacing="0" board="1" width="100%">
    		<thead>
    			<tr>
    				<th width="10%">번호</th>
    				<th width="35%">제목</th>
    				<th width="10%">카테고리</th>
    				<th width="10%">글쓴이</th>
    				<th width="10%">날짜</th>
    				<th width="5%">조회</th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>번호</td>
    				<td><a href="#">제목</a></td>
    				<td>로그인</td>
    				<td>글쓴이</td>
    				<td>날짜</td>
    				<td>조회수</td>
    			</tr>
    			<tr>
    				<td>번호</td>
    				<td><a href="#">제목</a></td>
    				<td>로그인</td>
    				<td>글쓴이</td>
    				<td>날짜</td>
    				<td>조회수</td>
    			</tr>
    		</tbody>
    	</table>
</body>
</html>
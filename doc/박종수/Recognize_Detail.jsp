<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<h2>header</h2><!-- header부분입니둥 -->
<body>
<br>의약품 승인 목록</br>
<p>승인 의약품 검색
<input type='text' placeholder="품목명을 입력하세요"></input>
<input type="button" id='Search' onclick='Search()' value="검색"></input>
<hr>


</br>
	<table border=1 width=100% >
	<tr>
		<td>번호</td>
		<td>품목명</td>
		<td>업체명</td>
		<td>허가일자</td>
		<td>주의사항</td>
		<td>등록일자</td>
	</tr>
	<tr height=25>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td>복용시 주의사항</td>
		<td></td>
	</tr>
		<tr>
			<td colspan="6" name="notice" id="notice" height=30px>1.조심히 드셔야 합니다</td>
		</tr>
	<tr height=25>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td>복용시 주의사항</td>
		<td></td>
	</tr>
			<tr>
				<td colspan="6" name="notice" id="notice" height=30px>1.식후 30분 이내에 드셔야 합니다</td>
			</tr>
	
	<!-- < -->
	<!-- 페이징 -->
	<!-- > -->
	
	
	
	</table>
</body>
<h2>footer</h2> <!-- Footer부분이 되어집니둥 -->
</html>
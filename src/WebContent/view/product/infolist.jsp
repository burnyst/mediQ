<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#all1 {float:right;}
#all2 {float:right;}
#SDelete {float:right;}
</style>
<script type="text/javascript">

function check_all() {
	for(i=0; i < my_form.mycheck.length; i++) {
		my_form.mycheck[i].checked = true;
	}
}
 
function uncheck_all() {
	for(i=0; i < my_form.mycheck.length; i++) {
		my_form.mycheck[i].checked = false;
	}
}

function msg(){
		alert('정말 삭제하시겠습니까?');
		location.href="infolist.jsp";
}
</script>

<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<h2>header</h2><!-- header부분입니둥 -->
<body>

<br>의약품 리스트</br>
<p>
		<input type='text' id='Entry' placeholder="품목명을 입력하세요"/>
		<input type="button" id='Search' onclick='Search()' value="검색"></input>
		<hr>
		

		
<input type='button' id='all1' name="all1" onclick='check_all();' value="전체선택" />
<input type='button' id='all2' nane="all2" onclick='uncheck_all();' value='모두해제' />
<input type='button' id='SDelete' onclick='msg()' value="삭제"/>
</br>
	<table border=1 width=100% >
	<tr>	
		<td>분류</td>
		<td>업체명</td>
		<td>품목명</td>
		<td>전문일반</td>
		<td>성상</td>
	</tr>
		<tr height=25>
		<td>${param.CLASS_NO}</td>
		<td>${param.ITEM_NAME}</td>
		<td>${param.ENTP_NAME}</td>
		<td>${param.EE_DOC_DATA}</td>
		<td>${param.CHART}</td>
		</tr>

			

</table>
<form method='get' action="modiinfo.do">
<input type="submit" id="modi" name="modi" value="수정"/>
</form>

<form method='get' action="plusinfo.do">
<input type="submit" id="plus" name="plus" value="추가"/>
</form>

</hr>
	<!-- 페이징처리 / 1 2 3 4 5 10-->

</body>
<h2>footer</h2> <!-- Footer부분이 되어집니둥 -->
</html>
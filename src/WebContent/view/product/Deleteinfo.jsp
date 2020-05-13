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
<script>
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
function msg() {
	 if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		 location.href="Search.jsp";
	 }else{   //취소
	     return false;
	 }
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h2>header</h2><!-- header부분입니다 -->
<body>
<form name='my_form' action="get">
<br>의약품 삭제</br>
<p>의약품 검색
<input type='text' name='Search1'  placeholder="품목명을 입력하세요"/>
<input type="button" id='Search2' onclick="go_such();" value="검색"/>
<hr>
의약품 정보 삭제
<input type='button' id='all1' name="all1" onclick='check_all();' value="전체선택" />
<input type='button' id='all2' nane="all2" onclick='uncheck_all();' value='모두해제' />
</br>
<p></p>
	<table border=1 width=100% >
	<tr>	
		<td></td>
		<td>분류</td>
		<td>업체명</td>
		<td>품목명</td>
		<td>전문일반</td>
		<td>성상</td>
	</tr>
		<tr height=25>
		<td><input type="checkbox" name="mycheck"  value='select'></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	<tr height=25>
		<td><input type="checkbox" name="mycheck"  value='select'></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	<tr height=25>
		<td><input type="checkbox" name="mycheck"  value='select'></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	<tr height=25>
		<td><input type="checkbox" name="mycheck"  value='select'></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
			</tr>

</form>
</table>
<br>
<input type='button' id='SDelete' onclick='msg()' value="삭제"/>
</body>
<h2>footer</h2> <!-- Footer부분이 되어집니다 -->
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#Cancel {float:right;}
#Add {float:right;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>관리자페이지입니다</br>
<hr>
<br>의약품 정보 추가</br>
<p></p>
<tr><td>
    <label class="catagory">분류    :</label>
</td><td>
    <select name="catagory">
    <option selected="">선택하세요</option>
    </select>
</td></tr>
</br>
<p></p>
<tr>
		<td>업 체 명    :  </td>
		<input type='text' id=" " value="업체명을 입력하세요">  </input>
		<td>품목명 :</td>
		<input type='text' id=" " value="품목명을 입력하세요"></input>
</tr></br>
<tr>
		<td>전문일반 :</td>
		<input type='text' id=" " value="전문일반을 입력하세요"></input>
		<td>성상 :</td>
		<input type='text' id=" " value="성상을 입력하세요"></input>
</tr></br>
<tr>
		<td>상세정보 :</td>
		<input type='text' id=" " value="상세정보를 입력하세요"></input>
</tr>
</br>
<hr>
<input type='button' id='Cancel' value="취소"></input> <!-- //오른쪽 -->
<input type='button' id='Add' value="추가"></input> <!-- //오른쪽 -->

</body>
</html>
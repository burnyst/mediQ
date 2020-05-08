<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>관리자페이지입니다</br>
<hr>
<br>의약품 정보 수정</br>

<table border=1 width=80% >
	<tr>
		<td>분류</td>
		<td>업체명</td>
		<td>품목명</td>
		<td>전문일반</td>
		<td>성상</td>
	</tr>
	<tr height=25>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
<tr><td>
        	<label class="catagory">분류    :</label>
        </td>
     		<td>
          <select name="catagory">
          <option selected="">선택하세요</option>
          </select>
</td></tr></br>
<tr>
		<td>업체명 :</td>
		<input type='text' value="업체명을 입력하세요"></input>
		<td>품목명 :</td>
		<input type='text' value="품목명을 입력하세요"></input>
</tr></br>
<tr>
		<td>전문일반 :</td>
		<input type='text' value="전문일반을 입력하세요"></input>
		<td>성상 :</td>
		<input type='text' value="성상을 입력하세요"></input>
</tr></br>
<tr>
		<td>상세정보 :</td>
		<input type='text' value="상세정보를 입력하세요"></input>
</tr>
</br>

<input type='button' id='Select' value="취소"></input>
<input type='button' id='SModify' value="수정"></input> 
</body>
</html>
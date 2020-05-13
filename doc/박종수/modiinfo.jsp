<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">

function msg1() {
	 if (confirm("취소 하시겠습니까?") == true){    //확인
		 location.href="Search.jsp";
	 }else{   //취소
	     return false;
	 }
	}function msg2() {
		 if (confirm("정말 수정하시겠습니까?") == true){    //확인
			 location.href="Search.jsp";
		 }else{   //취소
		     return false;
		 }
		}
</script>
<h2>header</h2><!-- header부분입니둥 -->
<body>
<form name='my_form' action="get">
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
</td><td>
    <select name="catagory">
    <option selected="">선택하세요</option>
    </select>
</td></tr>
</br>
<p></p>
<tr>
		<td>품목기준코드 :</td>
		<input type='text' id="ITEM_SEQ " name="ITEM_SEQ " placeholder="품목기준코드를 입력하세요"></input>
		<td>업 체 명    :  </td>
		<input type='text' id="ITEM_NAME " name="ITEM_NAME " placeholder="업체명을 입력하세요">  </input>
		<td>품목명 :</td>
		<input type='text' id="ENTP_NAME " name="ENTP_NAME " placeholder="품목명을 입력하세요"></input>
		<td>허가일자 :</td>
		<input type='text' id="ITEM_PERMIT_DATE " name="ITEM_PERMIT_DATE " placeholder="허가일자를 입력하세요"></input>
</tr></br></br>
<tr>
		<td>주의사항 :</td>
		<input type='text' id="NB_DOC_DATA " name="NB_DOC_DATA " placeholder="주의사항을 입력하세요"></input>
		<td>취소일자 :</td>
		<input type='text' id="CANCEL_DATE " name="CANCEL_DATE " placeholder="취소일자를 입력하세요"></input>
		<td>전문일반 :</td>
		<input type='text' id="EE_DOC_DATA " name="EE_DOC_DATA " placeholder="전문일반을 입력하세요"></input>
		<td>용법용량 :</td>
		<input type='text' id="ETC_OTC_CODE " name="ETC_OTC_CODE " placeholder="용법용량을 입력하세요"></input>
</tr></br></br>
<tr>
		<td>변경일자 :</td>
		<input type='text' id="UD_DOC_DATA " name="UD_DOC_DATA" placeholder="변경일자를 입력하세요"></input>
		<td>분류 :</td>
		<input type='text' id="CLASS_NO " name="CLASS_NO" placeholder="분류를 입력하세요"></input>
		<td>성상 :</td>
		<input type='text' id="CHART " name="CHART" placeholder="성상를 입력하세요"></input>
		<td>포장단위 :</td>
		<input type='text' id="PACK_UNIT " name="PACK_UNIT" placeholder="포장단위를 입력하세요"></input>
</tr></br></br>
<tr>
		<td>상세정보 :</td>
		<input type='text' id=" " name="" placeholder="상세정보를 입력하세요"></input>
</tr>
</br></br></br>
</form>
<input type='button' id='Select' onclick='msg1()' value="취소"></input>
<input type='button' id='SModify' onclick='msg2()' value="수정"></input> 
</body>
<h2>footer</h2> <!-- Footer부분이 되어집니둥 -->
</html>
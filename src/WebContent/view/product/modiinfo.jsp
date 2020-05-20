 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mediQ</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mediq.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
	

<script type="text/javascript">

</script>
<h2>header</h2><!-- header부분입니둥 -->
<body>
<form method="get" action="infolist.do">
<br>관리자페이지입니다</br>
<hr>
<br>의약품 정보 수정</br>
<form name="success" method="get" action="infolist.do">
<table border=1 width=1024px >
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
<p></p>
<tr>
		<td>품목기준코드 :</td>
		<input type='text' id="ITEM_SEQ " name="ITEM_SEQ" />
		<td>품목명:</td>
		<input type='text' id="ITEM_NAME " name="ITEM_NAME" />
		<td>업체명 :</td>
		<input type='text' id="ENTP_NAME " name="ENTP_NAME " />
		<td>허가일자 :</td>
		<input type='text' id="ITEM_PERMIT_DATE " name="ITEM_PERMIT_DATE" />
</tr></br></br>
<tr>
		<td>주의사항 :</td>
		<input type='text' id="NB_DOC_DATA " name="NB_DOC_DATA" />
		<td>취소일자 :</td>
		<input type='text' id="CANCEL_DATE " name="CANCEL_DATE"/>
		<td>전문일반 :</td>
		<input type='text' id="EE_DOC_DATA " name="EE_DOC_DATA"/>
		<td>용법용량 :</td>
		<input type='text' id="ETC_OTC_CODE " name="ETC_OTC_CODE"/>
</tr></br></br>
<tr>
		<td>변경일자 :</td>
		<input type='text' id="UD_DOC_DATA " name="UD_DOC_DATA"/>
		<td>분류 :</td>
		<input type='text' id="CLASS_NO " name="CLASS_NO"/>
		<td>성상 :</td>
		<input type='text' id="CHART " name="CHART"/>
		<td>포장단위 :</td>
		<input type='text' id="PACK_UNIT " name="PACK_UNIT"/>
</tr></br></br>
<tr>
</tr>
</br></br></br>
</form>
<input type='reset' id='Select'  value="취소"/>
<input type='submit' id='SModify' value="수정"/> 
</body>
<h2>footer</h2> <!-- Footer부분이 되어집니둥 -->
</html>
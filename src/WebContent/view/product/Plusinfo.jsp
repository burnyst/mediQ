<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<style>
#Cancel {float:right;}
#Add {float:right;}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mediQ</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mediq.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
	
<form action="plusinfo.do" method="post">
<br>관리자페이지입니다</br>
<hr>
<br>의약품 정보 추가</br>
<hr>
<p>

</p>
</td><td>
</td></tr>
</br>
<p></p>
<tr>
		<td>품목기준코드 :</td>
		<input type='text' id="ITEM_SEQ" name="ITEM_SEQ" />
		<td>품목명:</td>
		<input type='text' id="ITEM_NAME" name="ITEM_NAME" />
		<td>업체명 :</td>
		<input type='text' id="ENTP_NAME" name="ENTP_NAME"/>
		<td>허가일자 :</td>
	<input type='text'id="ITEM_PERMIT_DATE"name="ITEM_PERMIT_DATE" />
</tr></br></br>
<tr>
		<td>주의사항 :</td>
		<input type='text' id="NB_DOC_DATA" name="NB_DOC_DATA" />
		<td>취소일자 :</td>
		<input type='text' id="CANCEL_DATE" name="CANCEL_DATE"/>
		<td>전문일반 :</td>
		<input type='text' id="EE_DOC_DATA" name="EE_DOC_DATA"/>
		<td>용법용량 :</td>
		<input type='text' id="ETC_OTC_CODE" name="ETC_OTC_CODE"/>
</tr></br></br>
<tr>
		<td>변경일자 :</td>
		<input type='text' id="UD_DOC_DATA" name="UD_DOC_DATA"/>
		<td>분류 :</td>
		<input type='text' id="CLASS_NO"  name="CLASS_NO"/>
		<td>성상 :</td>
		<input type='text' id="CHART" name="CHART"/>
		<td>포장단위 :</td>
		<input type='text' id="PACK_UNIT" name="PACK_UNIT"/>
</tr></br></br>
<tr>
		<td>효능효과 :</td>
		<input type="text" cols=30/>
</tr>
</br></br></br>
<hr>
<input type='reset' id='Cancel'  value="취소"/>
<input type='submit' id='Add'  value="추가"/> 
</form>
</body>
<jsp:include page="/view/footer.jsp"></jsp:include>
</html>
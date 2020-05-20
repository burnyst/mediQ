<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
	<div class="divcss">
					<form name="frmq" id="frmq" method="post"  action="Infodelete.do?no=${qm.sn}" accept-charset="utf-8">
					<table class="tablecss"  border=1 >
	<tr>
		<th>분류</th>
		<th>업체명</th>
		<th>품목명</th>
		<th>전문일반</th>
		<th>성상</th>
	</tr>
		<tr height=25>
		<td>${param.CLASS_NO}</td>
		<td>${param.ITEM_NAME}</td>
		<td>${param.ENTP_NAME}</td>
		<td>${param.EE_DOC_DATA}</td>
		<td>${param.CHART}</td>
		</tr>
		
		
		<tr colspan=5>세부정보가 됨	
		
		<pre>${im.itemSeq}</pre>

		<pre>${im.itemPermitDate}</pre>

		<pre>${im.nbDocData}</pre>
		
		<pre>${im.cancelDate}</pre>
		
		<pre>${im.etcOtcCode}</pre>
		
		<pre>${im.changeDate}</pre>
		
		<pre>${im.packUnit}</pre>
	 	</tr>
			


		<td><input  type="submit" value="삭제"  />
		<input type="button" value="목록"  onclick='view/product/infolist.jsp'>
							
		</td>
		</tr>
		</table>
	</form>
	</div>
	<jsp:include page="/view/footer.jsp"></jsp:include>
</body>
</html>
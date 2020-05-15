<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"> </script>
	<script  src="../../../js/qna.js"></script> 
</head>
<body>
	<div class="divcss">
		<h1>답변 등록</h1>
	</div>
	<div class="divcss">
		<form name="frmq" id="frmq" method="post"  action="mqupdateaction.jsp" accept-charset="utf-8">
			<table class="tablecss">
					<tr>
							<th>제목:</th>
							<td><input type="text"  name="title" id="title" value="답변입니다."/></td>						
					</tr>			
						<%
							Date nowTime = new Date();
							SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
						%>
					<tr>
							<td colspan="4" ><textarea type="text"  name="answer" id="answer" style="width:500px; height:500px;">작성일자 <%= sf.format(nowTime) %></textarea></td>
					</tr>				
					<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><input  type="button" value="취소"  onclick="resetf(this.form)"/>
							<input type="submit" value="등록"></td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>
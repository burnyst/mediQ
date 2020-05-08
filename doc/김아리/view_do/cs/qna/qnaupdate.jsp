<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script  src="../../../js/qna.js"></script> 
</head>
<body>
	<div class="divcss">
		<h1>질문 등록</h1>
	</div>
	<div class="divcss">
		<form name="frmq" id="frmq" method="post"  action="qnaAction.do" accept-charset="utf-8"> 
		<!--  action=qupdateaction.jsp -->
			<table class="tablecss">
					<tr>
							<th>제목:</th>
							<td><input type="text"  name="title" id="title"/></td>
							<th>유형:</th>
							<td><select name="category" id="category" >
							<option value="none">=질문 유형을 선택하세요=</option>
							<option value="약물정보">약물 정보</option>
							<option value="데이터사용">데이터 사용</option>
							<option value="사이트이용">사이트 이용</option>
							</select>
							</td>
					</tr>
					<tr>
							<th>공개여부:</th>
							<td><input type="radio"  name="qpublic" id="Y"  value="0">공개</input>
							<input type="radio"  name="qpublic" id="N"  value="1" checked>비공개</input></td>
							<td></td>
					</tr>
					<tr>
							<td colspan="4" ><textarea type="text"  name="question" id="question" style="width:500px; height:500px;"
							placeholder="내용을 입력해주세요"></textarea></td>
					</tr>
					<tr>
							<th>파일 첨부:</th>
							<td><input type="file"  name="image" id="image" ></td>
					</tr>
					<tr>
							<td><input type="hidden" name="vcount" value="0"/></td>
							<td><input type="hidden" name="id" value="세션연결"/></td>
							<td><input type="hidden" name="rdate" value="데이트연결"/></td>
							<td><input type="hidden" name="qstate" value="0"/></td>
							<td><input  type="button" value="취소"  onclick="resetf(this.form)"/>
							<input type="submit" value="등록"></td>
					</tr>
				</table>
		</form>
	</div>
	
	
</body>
</html>
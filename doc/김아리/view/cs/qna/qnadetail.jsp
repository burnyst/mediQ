<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="divcss">
					<form name="frmq" id="frmq" method="post"  action="deleteaction.jsp" accept-charset="utf-8">
					<table class="tablecss"  border=1 >
						<tr>
							<th>번호</th>
							<td>n</td>
							<th>조회건수</th>
							<td>n</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>n</td>
							<th>작성자</th>
							<td>n</td>
						</tr>
						<tr>
							<th>유형</th>
							<td>n</td>
							<th>등록일자</th>
							<td>n</td>
						</tr>
						<tr>
							<th>공개여부</th>
							<td>n</td>
							<th>답변상태</th>
							<td>n</td>
						</tr>
						<tr>
							<th>내용</th>
						</tr>
						<tr>
							<td>n</td>
						</tr>
						<tr>
							<th>파일 첨부 목록:</th>
							<td> n</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><input  type="submit" value="삭제"  />
							<input type="button" value="목록"  onclick="location.href='qnalist.jsp'"></td>
							<!-- 경로/cs/qna/qnalist.do 로 바꿔야함 -->
					</tr>
					</table>
			</form>
	</div>
</body>
</html>
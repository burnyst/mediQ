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
	<div class="divcss">
					<form name="frmq" id="frmq" method="post"  action="QnaDeleteService.do" accept-charset="utf-8">
					<table class="tablecss"  border=1 >
						<tr>
							<th>번호</th>
							<td>${qm.sn}</td>
							<th>조회건수</th>
							<td>${qm.vcount}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${qm.title}</td>
							<th>작성자</th>
							<td>${qm.mid}</td>
						</tr>
						<tr>
							<th>유형</th>
							<td>${qm.category}</td>
							<th>등록일자</th>
							<td>${qm.rdate}</td>
						</tr>
						<tr>
							<th>공개여부</th>
							<td>${qm.qpublic}</td>
							<th>답변상태</th>
							<td>${qm.qstate}</td>
						</tr>
						<tr>
							<th >내용</th>
						</tr>
						<tr>
							<td>${qm.question}</td>
						</tr>
						<tr>
							<th>파일 첨부 목록:</th>
							<td>${qm.image}</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><input  type="submit" value="삭제"  />
							<input type="button" value="목록"  onclick="location.href='qnalist.do'">
							<!-- {%if 관리자 해서 버튼 보이기%} -->
							<button type="button" onclick="location.href='manageupdate.do?no=${qm.sn}' ">답변 쓰기</button>
							</td>
					</tr>
					</table>
			</form>
	</div>
</body>
</html>
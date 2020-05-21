<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<t:head title="메디큐">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/items.css" />
<script src="${pageContext.request.contextPath}/js/qna.js"></script>
</t:head>
<t:body>
<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe>
	<div class="items">
					<form name="frmq" id="frmq" method="post"  action="qnadelete.do?no=${qm.sn}" accept-charset="utf-8">
					<table >
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
							<td><fmt:formatDate value="${qm.rdate}" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr>
							<th>공개여부</th>
							<td>${qm.qpublic}</td>
							<th>답변상태</th>
							<td>${qm.qstate}</td>
						</tr>
						<tr>
							<th  colspan="4">내용</th>
						</tr>
						<tr>
							<td colspan="4"><textarea style="width:100%;height:100;border:1;overflow:visible;text-overflow:ellipsis;">${qm.question}</textarea></td>
						</tr>
						
						<tr>
							<th>파일 첨부 목록:</th>
							<td colspan="3">
							<c:if test="${qm.image !=null }">
								<img src="${pageContext.request.contextPath}/upload/${qm.image}"></br>
							${qm.image}<a href="#"  onclick="onDownload(${qm.sn})" >  ▽다운로드</a>
							</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="4"   style="text-align:right;"><input  type="submit" value="삭제"  />
							<button type="button"  onclick="location.href='qnalist.do'">목록</button>
							<c:if test="${user.mlevel==2}"> 
							<button type="button" onclick="location.href='manageupdate.do?no=${qm.sn}&pageNo=${qnaPAGE.currentPage}' ">답변 쓰기</button>
							</c:if>
							</td>
					</tr>
					</table>
			</form>
	</div>
</t:body>
</html>
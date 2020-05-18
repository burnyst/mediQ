<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="qinfo">
		<table class="tablecss" >
			<tr>
				<td>Q&A</td>
				<td><li>Q&A 게시판은 약물 정보, 데이터 이용, 사이트 이용 과 관련한 질문에 대해서 답변드리는 곳입니다.</li>
				<li>개인정보는 삭제하여 게시해주시기 바라며, 특정 개인 및 단체에 대한 비방, 비난, 상업성 광고, 욕설, 비속어, 종교 비방, 선거운동 등 본 코너 운영의 취지에 맞지 않거나 타인의 이름이나 전화번호 사용 또는 연락처가 불분명한 경우에는 별도 통보 없이 자동 삭제됩니다</li>
				</td>
			</tr>
		</table>
		<hr>
		</div>
		<form name="search" id="search" method="post"  action="qnasearch.do" accept-charset="utf-8">
		<div class="divcss">
			<table class="tablecss" >
				<tr>
					<th>제목:</th>
					<td><input type="text"  name="keyword1" /></td>
					<th>등록일자:</th>
					<td><input type="text" name="keyword2"  placeholder="(예: YY/MM/DD -> 20/05/14)" /></td>
				</tr>
				<tr>
					<th>작성자:</th>
					<td><input type="text" name="keyword3" /></td>
					<th>유형:</th>
					<td><select name="keyword4" >
					<option value="">=질문 유형을 선택하세요=</option>
					<option value="약물정보">약물정보</option>
					<option value="데이터사용">데이터 사용</option>
					<option value="사이트이용">사이트 이용</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4"  align="right">
					<input type="submit"  value="검색" />
					</td>
				</tr>
			</table>				 
			</div>
			</form>
			<div class="divcss">
				<h4>총${qnaPAGE.total} ${qnaSearchPAGE.total }건</h4>
			</div>
			<div class="divcss">
			    <table class="tablecss"  border="1"  style="width:1000px; height:700px ">
			        <thead>
			        <tr>
			            <th >번호</th>
			            <th style="width:40%; ">제목</th>
			            <th width="100">유형</th>
			            <th>공개여부</th>
			            <th>조회 건수</th>
			            <th>작성자</th>
			            <th>등록일자</th>
			            <th>답변상태</th>
			        </tr>
			        </thead> 			        
			        <tbody>
			        	<c:if test="${qnaPAGE.hasNoQuestions()} ">
									<tr>
										<th colspan="4">게시글이 존재하지 않습니다.</th>
									</tr>
								</c:if>    
			        	<c:forEach  var="qm" items="${qnaPAGE.question}">
										<tr>
										  <%-- ${qm.sn} 은 Qnamodel클래스의 getSn()메소드를 호출 --%>
											<td >${qm.sn} </td>																	
											<td style="width:40%;"><a  style="text-decoration:none; color:black;" href="qnadetail.do?no=${qm.sn}&pageNo=${qnaPAGE.currentPage}">${qm.title}</a></td>
											<td >${qm.category}</td>
											<td >${qm.qpublic}</td>
											<td>${qm.vcount}</td>
					        		<td>${qm.mid}</td>
					        		<td>${qm.rdate}</td>
					        		<td>${qm.qstate}</td>
									</tr>
							</c:forEach> 
							<c:set var="qm"  value="${Qnamodel.qstate}"/>
							<c:if test="${qm.qstate}==1">
									<tr>
											<td> ▼</td>
											<td colspan="7">RE: 답변입니다.</td>
									</tr>		
								</c:if>	
			        </tbody>			       
			    </table>
			     <!-- SearchList------------------------------------------------------------------------------ -->
					<div class="divcss">
			    <table class="tablecss"  border="1"  style="width:1000px; height:700px ">	          
			        <tbody>
			        	<c:if test="${qnaSearchPAGE.hasNoQuestions()} ">
									<tr>
										<th colspan="4">게시글이 존재하지 않습니다.</th>
									</tr>
								</c:if>    
			        	<c:forEach  var="qms" items="${qnaSearchPAGE.search}">
										<tr>
											<td >${qms.sn} </td>																	
											<td style="width:40%;"><a  style="text-decoration:none; color:black;" href="qnadetail.do?no=${qms.sn}">${qms.title}</a></td>
											<td >${qms.category}</td>
											<td >${qms.qpublic}</td>
											<td>${qms.vcount}</td>
					        		<td>${qms.mid}</td>
					        		<td>${qms.rdate}</td>
					        		<td>${qms.qstate}</td>
									</tr>
							</c:forEach> 		
			        </tbody>		
			    </table>
			    
			    <%-- 페이징 부분 --%>
		<c:if test="${qnaPAGE.hasQuestions() }">
			<tr>
				<th colspan="8">
					<%-- [이전prev]출력 --%>
					<c:if test="${qnaPAGE.startPage>10}">
					<a href="qnalist.do?pageNo=${qnaPAGE.startPage-10}">◁</a>
					</c:if>
					
					<c:forEach var="pNo" 
					           begin="${qnaPAGE.startPage}" 
					           end="${qnaPAGE.endPage}">
					<a href="qnalist.do?pageNo=${pNo}">[${pNo}]</a>
					</c:forEach>
					
					<%-- [다음next]출력 --%>
					<c:if test="${qnaPAGE.endPage<qnaPAGE.totalPages}">
					<a href="qnalist.do?pageNo=${qnaPAGE.startPage+10}">▷</a>
					</c:if>
				</th>
			</tr>
		</c:if>
		
	<button type="button" onclick="location.href='qnalist.do' ">전체 목록</button>
	<!--  session 연결해서 해야함-->
	<%-- if  (mlevel == [회원]){ --%>
	<button type="button" onclick="location.href='qnaupdate.do' ">글쓰기</button>
	<%-- } --%>
	<%-- else { --%>
		<button onclick="javascript:btn()">글쓰기</button>
		<%	out.println
		("<script>function btn(){alert('회원 전용 페이지입니다.  회원가입을 하신 뒤, 이용 부탁드립니다.');}</script>");
		%> <%-- }--%>
	</div>
	<script src="https:code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
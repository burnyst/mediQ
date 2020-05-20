<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
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
			    <table class="tablecss"  border="1"  style="width:1024px; ">
			        <thead>
			        <tr>
			            <th  style="width:5%;">번호</th>
			            <th style="width:30%; ">제목</th>
			            <th style="width:10%;">유형</th>
			            <th style="width:10%;">공개여부</th>
			            <th style="width:10%;">조회 건수</th>
			            <th style="width:10%;">작성자</th>
			            <th style="width:15%;">등록일자</th>
			            <th style="width:10%;">답변상태</th>
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
											<td style="width:5%;">${qm.sn} </td>																	
											<td style="width:30%;"><a  style="text-decoration:none; color:black;" href="qnadetail.do?no=${qm.sn}&pageNo=${qnaPAGE.currentPage}&id=${qm.mid}">${qm.title}</a></td>
											<td style="width:10%;" >${qm.category}</td>
											<c:if test="${qm.qpublic==1}">
											<td  style="width:10%;">비공개</td>
											</c:if>
											<c:if test="${qm.qpublic==0}">
											<td style="width:10%;">공개</td>
											</c:if>
											<td style="width:10%;">${qm.vcount}</td>
					        		<td style="width:10%;">${qm.mid}</td>
					        		<td style="width:15%;">${qm.rdate}</td>
					        		<td style="width:10%;">${qm.qstate}</td>
									</tr>	
			        		<c:if test="${qm.qstate ==1}">
											<tr>
													<td> ▼</td>
													<td colspan="6"  style="padding-left:10px"><a  style="text-decoration:none; color:black;" href="qnamanagedetail.do?no=${qm.sn}&pageNo=${qnaPAGE.currentPage}&id=${qm.mid}">RE: 답변입니다</a></td>
													<td><input type=button  value="답변삭제" onclick="location.href='qnadelete.do?no=${qm.sn}'"></td>
											</tr>		
										</c:if>		
										<c:if test="${qm.sn==qma.sn}">
											<tr>
													<td colspan="8"  style="text-align:center;"><textarea cols="120" rows="5" >${qma.answer}</textarea></td>
											</tr>
										</c:if>											
									</c:forEach> 
			        </tbody>			       
			    </table>
			     <!-- SearchList------------------------------------------------------------------------------ -->
					<div class="divcss">
			    <table class="tablecss"  border="1"  style="width:1024px; ">	          
			        <tbody>
			        	<c:if test="${qnaSearchPAGE.hasNoQuestions()} ">
									<tr>
										<th colspan="4">게시글이 존재하지 않습니다.</th>
									</tr>
								</c:if>    
			        	<c:forEach  var="qms" items="${qnaSearchPAGE.search}">
										<tr>
											<td style="width:5%;">${qms.sn} </td>																	
											<td style="width:30%;"><a  style="text-decoration:none; color:black;" href="qnadetail.do?no=${qms.sn}">${qms.title}</a></td>
											<td style="width:10%;" >${qms.category}</td>
											<c:if test="${qms.qpublic==1}">
											<td style="width:10%;">비공개</td>
											</c:if>
											<c:if test="${qms.qpublic==0}">
											<td style="width:10%;">공개</td>
											</c:if>
											<td style="width:10%;">${qms.vcount}</td>
					        		<td style="width:10%;">${qms.mid}</td>
					        		<td style="width:15%;">${qms.rdate}</td>
					        		<td style="width:10%;">${qms.qstate}</td>
									</tr>
								<c:if test="${qms.qstate ==1}">
											<tr>
													<td> ▼</td>
													<td colspan="6"  style="padding-left:10px"><a  style="text-decoration:none; color:black;" href="qnamanagedetail.do?no=${qms.sn}">RE: 답변입니다</a></td>
													<td><input type=button  value="답변삭제" onclick="location.href='qnadelete.do?no=${qms.sn}'"></td>
											</tr>		
										</c:if>		
										<c:if test="${qms.sn==qma.sn}">
											<tr>
													<td colspan="8"  style="text-align:center;"><textarea cols="120" rows="5" >${qma.answer}</textarea></td>
											</tr>
										</c:if>											
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
	<c:if test="${user.mid != null}">
	<button type="button" onclick="location.href='qnaupdate.do' ">글쓰기</button>
	</c:if>
	<c:if test="${user.mid==null}">
		<button onclick="javascript:btn()">글쓰기</button>
		<%	out.println
		("<script>function btn(){alert('회원 전용 페이지입니다.  회원가입을 하신 뒤, 이용 부탁드립니다.');}</script>");
		%>
		</c:if>
	</div>
	<script src="https:code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<script src="<%= request.getContextPath()%>/js/qna.js?v=<%=System.currentTimeMillis() %>"></script> 
<t:head title="메디큐">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/items.css" />
<meta charset="UTF-8">
</t:head>
<t:body>
	<div>
		<table >
			<tr>
				<td><h1>Q&A</h1></td>
				<td style="padding:30px;"><li>Q&A 게시판은 약물 정보, 데이터 이용, 사이트 이용 과 관련한 질문에 대해서 답변드리는 곳입니다.</li>
				<li>개인정보는 삭제하여 게시해주시기 바라며, 특정 개인 및 단체에 대한 비방, 비난, 상업성 광고, 욕설, 비속어, 종교 비방, 선거운동 등 본 코너 운영의 취지에 맞지 않거나 타인의 이름이나 전화번호 사용 또는 연락처가 불분명한 경우에는 별도 통보 없이 자동 삭제됩니다</li>
				</td>
			</tr>
		</table>
		<hr>
		</div>
		<div class="items">
		<form name="search" id="search" method="post"  action="qnasearch.do" accept-charset="utf-8">
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
					</form>
						<h4>총${qnaPAGE.total} ${qnaSearchPAGE.total }건</h4>
					    <table class="tablecss"  id="tablecss">
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
					        	<c:forEach  var="qm" items="${qnaPAGE.question}">
												<tr>
													<td >${qm.sn} </td>																	
													<td ><a  style="text-decoration:none; color:black;" href="qnadetail.do?no=${qm.sn}&pageNo=${qnaPAGE.currentPage}&id=${qm.mid}">${qm.title}</a></td>
													<td >${qm.category}</td>
													<c:if test="${qm.qpublic==1}">
													<td >비공개</td>
													</c:if>
													<c:if test="${qm.qpublic==0}">
													<td >공개</td>
													</c:if>
													<td >${qm.vcount}</td>
							        		<td >${qm.mid}</td>							       			
							        		<td><fmt:formatDate value="${qm.rdate}" pattern="yyyy-MM-dd"/></td>
							        		<td >${qm.qstate}</td>
											</tr>	
					        		<c:if test="${qm.qstate ==1}">
													<tr>
															<td> ▼</td>
															<td colspan="6"  style="padding-left:10px"><a  style="text-decoration:none; color:black;" href="qnamanagedetail.do?no=${qm.sn}&pageNo=${qnaPAGE.currentPage}&id=${qm.mid}">RE: 답변입니다</a></td>
															<td><c:if test="${user.mlevel==2 }">
															<input type=button  value="답변삭제" onclick="location.href='qnadelete.do?no=${qm.sn}'">
																				</c:if></td>
													</tr>		
												</c:if>		
												<c:if test="${qm.sn==qma.sn}">
													<tr>
															<td colspan="8"  style="text-align:center;"><textarea style="width:100%;border:1;overflow:visible;text-overflow:ellipsis;">${qma.answer}</textarea></td>
													</tr>
												</c:if>											
											</c:forEach> 
					        </tbody>			       
					  
					     <!-- SearchList------------------------------------------------------------------------------ -->
					            
					        <tbody>
					        	<c:forEach  var="qms" items="${qnaSearchPAGE.search}">
												<tr>
													<td >${qms.sn} </td>																	
													<td ><a  style="text-decoration:none; color:black;" href="qnadetail.do?no=${qms.sn}">${qms.title}</a></td>
													<td >${qms.category}</td>
													<c:if test="${qms.qpublic==1}">
													<td >비공개</td>
													</c:if>
													<c:if test="${qms.qpublic==0}">
													<td >공개</td>
													</c:if>
													<td >${qms.vcount}</td>
							        		<td >${qms.mid}</td>
							        		<td ><fmt:formatDate value="${qms.rdate}" pattern="yyyy-MM-dd"/></td>
							        		<td >${qms.qstate}</td>
											</tr>
										<c:if test="${qms.qstate ==1}">
													<tr>
															<td> ▼</td>
															<td colspan="6"  style="padding-left:10px"><a  style="text-decoration:none; color:black;" href="qnamanagedetail.do?no=${qms.sn}">RE: 답변입니다</a></td>
															<td><c:if test="${user.mlevel==2 }">
															<input type=button  value="답변삭제" onclick="location.href='qnadelete.do?no=${qm.sn}'">
																				</c:if></td>
													</tr>		
												</c:if>		
												<c:if test="${qms.sn==qma.sn}">
													<tr>
															<td colspan="8"  style="text-align:center;"><textarea style="width:100%;border:1;overflow:visible;text-overflow:ellipsis;">${qma.answer}</textarea></td>
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
				</div>
			<button type="button" onclick="location.href='qnalist.do' ">전체 목록</button>
			<button type="button"  id="writeQna" value="${user.mid == null}" >글쓰기</button>
	<script src="https:code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</t:body>
</html>
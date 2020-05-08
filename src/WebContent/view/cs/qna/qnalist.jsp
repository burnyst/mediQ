<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		</div>
		<div class="divcss">
			<table class="tablecss">
				<tr>
					<th>제목:</th>
					<td><input type="text"  name="title" id="title"/></td>
					<th>등록일자:</th>
					<td><input type="date" name="rdate" id="rdate"/></td>
				</tr>
				<tr>
					<th>작성자:</th>
					<td><input type="text" name="mid" id="mid"/></td>
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
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
					<button type="button" onclick="location.href='#' ">검색</button>
					</td>
				</tr>
			</table>
			</div>
			<div class="divcss">
				<h4>총 n 건</h4>
			</div>
			<div class="divcss">
			    <table class="tablecss"  border="1"  style="width:1000px; ">
			        <thead>
			        <tr>
			            <th >번호</th>
			            <th style="width:40%; ">제목</th>
			            <th>유형</th>
			            <th>공개여부</th>
			            <th>조회 건수</th>
			            <th>작성자</th>
			            <th>등록일자</th>
			            <th>답변상태</th>
			        </tr>
			        </thead>
			        <tbody>
			        		<tr>
			        		<td>예시</td>
			        		<td><a href="qnadetail.jsp"  style="text-decoration: none; color:black;">예시</a></td>
			        		<td>예시</td>
			        		<td>예시</td>
			        		<td>예시</td>
			        		<td>예시</td>
			        		<td>예시</td>
			        		<td>예시</td>
			        		</tr>
			        </tbody>
			
			    </table>
	<!--  session 연결해서 해야함-->
	<%-- if  (mlevel == [회원]){ --%>
	<button type="button" onclick="location.href='qnaupdate.jsp' ">글쓰기</button>
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
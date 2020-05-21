<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mediQ</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mediq.css" />
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
   <script src="${pageContext.request.contextPath}/js/search.js"></script>
</head>
<body>
 						<form method='get' action="modiinfo.do">
			    <div class="clearfix">
			    <hr/>
			    </div>
       			  <h2>의약품 상세보기 게시판</h2>
  				<table border="1" width=1024px>
			    		    	
						<tr>	
							<td colspan="2">품목명</td>
							<td>업체명</td>
							<td>전문일반</td>
							<td>성상</td>
						</tr>
						<tr>
						<td colspan="2">${im.itemName}</td>
						<td>${im.entpName}</td>
						<td>${im.etcOtcCode}</td>
						<td>${im.chart}</td>
						</tr>
					
						<tr>
						<td colspan="5">
						<div class="content">
 						<table>
	 				
	 					<colgroup>
           				</colgroup>
					
	 						<h4>품목기준코드</h4>
	 						<pre>${im.itemSeq}</pre>
	 						<h4>주의사항</h4>
	 						<pre>${im.nbDocData}</pre>
	 						<h4>취소일자</h4>
	 						<pre>${im.cancelDate}</pre>
	 						<h4>효능효과</h4>
	 						<pre>${im.eeDocData}</pre>
	 						<h4>용법용량</h4>
	 						<pre>${im.udDocData}</pre>
	 						<h4>변경일자</h4>
	 						<pre>${im.changeDate}</pre>
	 						<h4>분류</h4>
	 						<pre>${im.classNo}</pre>
	 						<h4>성상</h4>
	 						<pre>${im.chart}</pre>
	 						<h4>포장단위</h4>
	 						<pre>${im.packUnit}</pre>
	 						
						
				         
						
						</tfoot>
						


						</tr>
 					  </table>
			     </div>
	            </td>
	        </tr>

			</tbody>
	<tfoot>



	</tfoot>

</table>

<a href="modiinfo.do?itemName=${im.itemName}">
<input type="button" id="update" value="수정"/></a><!-- 이영역은 관리자로 로그인할 경우만 보이는 버튼 -->


<a href="infolist.do">
<input type=button  value="목록으로"   /></a>
</form>

<a href="infodelete.do?itemName=${im.itemName}">
<input type=submit  value="삭제"   /></a>
</form>


<jsp:include page="/view/footer.jsp"></jsp:include>

</body>
</html>
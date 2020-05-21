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
<jsp:include page="/view/header.jsp"></jsp:include>
	

<script type="text/javascript">

</script>

<body>
<form method="post" action="infoupdate.do">


			    <div class="clearfix">
			    <hr/>
			    </div>
       			  <h2>의약품 수정 게시판</h2>
  				<table border="1" width=1024px>
			    		    	
						<tr>	
							<td colspan="2">품목명</td>
							<td>업체명</td>
							<td>전문일반</td>
							<td>성상</td>
						</tr>
						<tr>
						<td colspan="2"><input type="text" id="itemName" name="itemName" value="${updateReq.itemName}"/></td>
						<td><input type="text" id="entpName" name="entpName" value="${updateReq.entpName}"/></td>
						<td><input type="text" id="etcOtcCode" name="etcOtcCode" value="${updateReq.etcOtcCode}"/></td>
						<td><input type="text" id="chart" name="chart" value="${updateReq.chart}"/></td>
						</tr>
						<tr>
							<td>품목기준코드</td>
							<td colspan="4"><input type="text" id="itemSeq" name="itemSeq" value="${updateReq.itemSeq}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>주의사항</td>
	 						<td colspan="4"><input type="text" id="nbDocData" name="nbDocData" value="${updateReq.nbDocData}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>취소일자</td>
	 						<td colspan="4"><input type="text" id="cancelDate" name="cancelDate" value="${updateReq.cancelDate}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>효능효과</td>
	 						<td colspan="4"><input type="text" id="eeDocData" name="eeDocData" value="${updateReq.eeDocData}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>용법용량</td>
	 						<td colspan="4"><input type="text" id="udDocData" name="udDocData" value="${updateReq.udDocData}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>변경일자</td>
	 						<td colspan="4"><input type="text" id="changeDate" name="changeDate" value="${updateReq.changeDate}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>분류</td>
	 						<td colspan="4"><input type="text" id="classNo" name="classNo" value="${updateReq.classNo}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>성상</td>	
	 						<td colspan="4"><input type="text" id="chart" name="chart" value="${updateReq.chart}"/></td>
	 					</tr>
	 					<tr>	
	 						<td>포장단위</td>	
	 						<td colspan="4"><input type="text" id="packUnit" name="packUnit" value="${updateReq.packUnit}"/></td>
 						</tr>
 					  </table>
			     </div>
	            </td>
	        </tr>

			</tbody>
	<tfoot>



	</tfoot>

</table>
<input type='reset' id='Select'  value="초기화"/>

<input type='submit' id='SModify' value="저장"/>

</form>
<br/>

 
</body>
<jsp:include page="/view/footer.jsp"></jsp:include>
</html>
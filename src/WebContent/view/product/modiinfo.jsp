 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>header</h2><!-- header부분입니둥 -->
<body>
<form method="get" action="infolist.jsp">
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
						<td colspan="2">${im.itemName}</td>
						<td>${im.entpName}</td>
						<td>${im.etcOtcCode}</td>
						<td>${im.chart}</td>
						</tr>
						<tr>
							<td>품목기준코드</td>
							<td colspan="4"><input type="text" id="modi" value="${im.itemSeq}"/>${im.itemSeq}</td>
	 					</tr>
	 					<tr>	
	 						<td>주의사항</td>
	 						<td colspan="4"><input type="text" id="modi" value="${im.nbDocData}"/>${im.nbDocData}</td>
	 					</tr>
	 					<tr>	
	 						<td>취소일자</td>
	 						<td colspan="4"><input type="text" id="modi" value="${im.cancelDate}"/>${im.cancelDate}</td>
	 					</tr>
	 					<tr>	
	 						<td>효능효과</td>
	 						<td colspan="4"><input type="text" id="modi" value="${im.eeDocData}"/>${im.eeDocData}</td>
	 					</tr>
	 					<tr>	
	 						<td>용법용량</td>
	 						<td colspan="4"><input type="text" id="modi" value="${im.udDocData}"/>${im.udDocData}</td>
	 					</tr>
	 					<tr>	
	 						<td>변경일자</td>
	 						<td colspan="4"><input type="text" id="modi" value="${im.changeDate}"/>${im.changeDate}</td>
	 					</tr>
	 					<tr>	
	 						<td>분류</td>
	 						<td colspan="4"><input type="text" id="modi" value="${im.classNo}"/>${im.classNo}</td>
	 					</tr>
	 					<tr>	
	 						<td>성상</td>	
	 						<td colspan="4"><input type="text" id="modi" value="${im.chart}"/>${im.chart}</td>
	 					</tr>
	 					<tr>	
	 						<td>포장단위</td>	
	 						<td colspan="4"><input type="text" id="modi" value="${im.packUnit}"/>${im.packUnit}</td>
 						</tr>
 					  </table>
			     </div>
	            </td>
	        </tr>

			</tbody>
	<tfoot>



	</tfoot>

</table>
</form>
<br/>
<input type='reset' id='Select'  value="이전페이지로"/>
<input type='submit' id='SModify' value="저장"/> 
</body>
<h2>footer</h2> <!-- Footer부분이 되어집니둥 -->
</html>
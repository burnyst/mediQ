<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.User" %>
<%@ page import="controller.Controller" %>
<%@ page import="controller.NotLoginException" %>       
<t:head title="회원관리">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css" />
    <script src="${pageContext.request.contextPath}/js/search.js"></script>
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<meta charset="UTF-8">
		<style>
		h2{
		text-align: center;
		border:15px;
		}
		table {
		   border-collapse: collapse;
		   width:80% px;
		   margin: auto;
		  text-align: center;
		   }
		#move,#delete {
		    float: right;
		}
		</style>
<script>
/* $(document).ready(function(){
 	  
 			$("#delete").click(function(){
	 		alert($("#xmember").text());
		 	//if($("#xreason").text()=="")
			//alert("탈퇴여부가 변경되지 않았습니다.")
			return false; 
	});  
	 
	
}); */
</script>
</t:head>
<t:body>
      <br/>
      <h2>회원관리</h2>
      <form method="post" action="memberdelete.do" >
     
			<input type="submit" id="delete"value="삭제">
		
      <hr>
      <br/>
            <table border="1" id="memberM" >
    
               <tr>
               		<th width="5%">선택</th>
                  <th width="10%">아이디</th>
                  <th width="10%">이름</th>
                  <th width="15%">이메일</th>
                  <th width="15%">핸드폰 번호</th>
                  <th width="10%">생년월일</th>
                  <th width="5%">권한</th>
                  <th width="10%">탈퇴여부</th>
                  <th width="20%">탈퇴사유</th>
               </tr>
               <c:if test="${listmemberPAGE.hasNoMember()}">
								<tr>
									<td colspan="9">회원이 존재하지 않습니다.</td>
								</tr>
							 </c:if> 
               <c:forEach  var="member" items="${listmemberPAGE.content}">
               <tr>
               		<th><input type="checkbox" name="mid" value="${member.mid}"size="20" /></th>
                  <th>${member.mid}</th>
                  <th>${member.mname}</th>
                  <th>${member.memail}</th>
                  <th>${member.mhp}</th>
                  <th>${member.mbd}</th>
                  <th>${member.mlevel}</th>
                  <th id="xmember" >${member.xmember}</th>
                  <th id="xreason">${member.xreason}</th>
                  <%-- <input type="hidden" name="member" value="${member}" /> --%>
               </tr>
               </c:forEach>
               <!--페이지처리  -->
            	 <c:if test="${listmemberPAGE.hasMember()}">
					<tr>
						<th  colspan="9" >
							<c:if test="${listmemberPAGE.startPage>10}">
							<a href="newslist.do?pageNo=${listmemberPAGE.startPage-10}">[이전]</a>
							</c:if>
							<c:forEach var="pNo" 
				           begin="${listmemberPAGE.startPage}" 
				           end="${listmemberPAGE.endPage}">
						<a href="memberlist.do?pageNo=${pNo}">[${pNo}]</a>
						</c:forEach>
														
							<c:if test="${listmemberPage.endPage<listmemberPAGE.totalPages}">
							<a href="memberlist.do?pageNo=${listmemberPAGE.startPage+10}">[다음]</a>
							</c:if>
						</th>
				</tr>
				</c:if> 	
            </table>
         </form>
</t:body>
</html>
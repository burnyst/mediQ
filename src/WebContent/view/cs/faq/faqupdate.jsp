<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mediq.css" />
<style>
        fieldset{margin:0 20% 0 20%; }
        .irum{text-align:center;}
        #title{padding: 5px 0 5px 0;}
        .btn{text-align:right;}
        select{padding: 3px 0 5px 0 ;}
        #titletd{padding-top: 7px; padding-bottom:10px;}
    </style>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>
	<h1>FAQ</h1>
<hr/><br/>
    <form method="post" id="frm1" action="${pageContext.request.contextPath}/faqupdate.do">
        <fieldset>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td width="150" height="30" class="irum">유형</td>
                    <td>
	                        <select required="required" name="category" id="category">
	                            <option  value="">선택</option>
	                            <c:if test="${updateReq.category == '로그인'}">
	                            	<option value="로그인" selected>로그인</option>
	                            	<option value="약품 정보">약품 정보</option>
	                            	<option value="기타">기타</option>
	                            </c:if>
	                            <c:if test="${updateReq.category == '약품 정보'}">
	                           		<option value="로그인" >로그인</option>
	                    			<option value="약품 정보" selected>약품 정보</option>
	                    			<option value="기타">기타</option>
	                            </c:if>
	                            <c:if test="${updateReq.category == '기타'}">
	                            	<option value="로그인" >로그인</option>
	                            	<option value="약품 정보">약품 정보</option>
	                            	<option value="기타" selected>기타</option>
	                            </c:if>
	                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="150" height="30" class="irum">제목</td>
                    <td id="titletd">
                    	<input type="text" id="title" name="title" size="50" placeholder="제목을 입력하세요" required="required" value="${updateReq.title}" />
                    	<input type="hidden" id="sn" name="sn" value="${updateReq.sn}"/>
                     </td>
                <tr>
                    <td class="irum">내용</td>
                    <td>
                   	 <textarea cols="70" rows="10" id="contents" name="contents" placeholder="내용을 입력하세요" required="required">${updateReq.contents}</textarea>
                   	 <input type="hidden" id="mid" name="mid" value="관리자" />
                    </td>
                <tr>
                    <td colspan="2" class="btn"><br/>
                    	<input type="hidden" id="mid" name="mid" value="${authUser.mid}"/>
                        <input type="submit" id="submitBtn" name="submitBtn" value="확인"/>
                        <input type="reset" id="resetBtn" name="resetBtn" value="취소"/>
                    </td>
                </tr>
                <jsp:include page="../../footer.jsp"></jsp:include>
            </table>
        </fieldset>
    </form>
</body>
</html>
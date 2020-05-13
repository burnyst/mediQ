<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<style>
h2{
text-align: center;
border:15px;
}
table {
   border-collapse: collapse;
   width: 1500px;
   margin: auto;
  text-align: center;
   }
#move,#delete {
    float: right;
}
</style>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#move").click(function(){
		 alert("정말 이동하시겠습니까?")
	});	
	$("#delete").click(function(){
		 alert("정말 삭제하시겠습니까?")
	});	
});


</script>
</head>
<body>
      <br/>
      <h2>회원관리</h2>
      <form name="memberM" id="memberM"  method="get">
      <input type=text id="idResearch" value="아이디를 검색해주세요" />
      <input type="button" id="research" value="검색" onclick=""/>
      <input type="button" id="move" value="이동" >
         <hr>
            <table border="1" id="memberM"  width="100%">
               <tr>
               		<th></th>
                  <th width="20%">아이디</th>
                  <th width="10%">이름</th>
                  <th width="15%">이메일</th>
                  <th width="15%">핸드폰 번호</th>
                  <th width="10%">생년월일</th>
                  <th width="5%">권한</th>
                  <th width="5%">탈퇴여부</th>
                  <th width="20%">탈퇴사유</th>
               </tr>
               <tr>
               		<th><input type="checkbox"/></th>
                  <th>1593647</th>
                  <th>나이수</th>
                  <th>1593647@hanmail.net</th>
                  <th>010-9116-3657</th>
                  <th>1990.03.29</th>
                  <th>1</th>
                  <th>f</th>
                  <th></th>
               </tr>
            </table>
         </form>
         
         <span>삭제회원관리</span>
         <form name="xmember" id="xmember"  method="get">
         <input type="button" id="delete" value="완전삭제" ><br/>
         <hr>
            <table border="1" >
               <tr>
               		<th></th>	
                  <th>아이디</th>
                  <th>이름</th>
                  <th>이메일</th>
                  <th>핸드폰 번호</th>
                  <th>생년월일</th>
                  <th>권한</th>
                  <th>탈퇴여부</th>
                  <th>탈퇴사유</th>
               </tr>
            </table>
         </form>
</body>
</html>
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
   width: 500px;
   margin: auto;
  text-align: center;
   }
#move,#delete {
    float: right;
}
</style>
</head>
<body>
      <br/>
      <h2>회원관리</h2>
      <form name="memberM" id="memberM" action="" method="get">
      <input type=text id="idResearch" value="아이디를 검색해주세요" />
      <input type="button" id="research" value="검색" onclick=""/>
      <input type="button" id="move" value="이동" action="">
         <hr>
            <table border="1" id="memberM">
               <tr>
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
         
         <span>삭제회원관리</span>
         <form>
         <input type="button" id="delete" value="완전삭제" action=""><br/>
         <hr>
            <table border="1" >
               <tr>
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
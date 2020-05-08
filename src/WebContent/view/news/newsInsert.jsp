<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>뉴스게시판 등록</title>
</head>
<style>
h2{
text-align: center;
border:15px;
}
table {
   border-collapse: collapse;
   width: 500px;
   margin: auto;
   padding: 50px;
  text-align: left;
   }
span{
padding: 0 0 0 200px;
}


</style>
<body>
    <form>
    <h2>뉴스게시판 등록</h2>
    <span>제목</span>
    <input type="text" id="newsTitle" value="제목을 입력해주세요" ><br/>
    <span>언론사명</span>
    <input type="text" id="newsMedia" value="언론사를 입력해주세요" ><br/>
    <table border="1" >
         <tr>
          <td><textarea name="contents" rows="20" cols="100" ></textarea></td>
         </tr>

    </table>
    <p><input type="submit" id="submit" value="등록"></p>
    <p><input type="reset" id="reset" value="취소"></p>
    </form>
</body>
</html>
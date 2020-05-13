<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>뉴스게시판 등록</title>
</head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
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
<script>


</script>
<body>
    <form action="newsMain.jsp">
    <h2>뉴스게시판 수정 및 삭제</h2>
    <span>제목</span>
    <input type="text" id="newsTitle" placeholder="제목을 입력해주세요" ><br/>
    <span>언론사명</span>
    <input type="text" id="newsMedia" placeholder="언론사를 입력해주세요" ><br/>
    <table border="1" >
         <tr>
          <td><textarea name="contents" rows="20" cols="100" ></textarea></td>
         </tr>

    </table>
    <a href="./newsMain.jsp"><input type="submit" id="submit" value="수정"></a>
    <input type="reset" id="reset" value="취소">
    <input type="reset" id="reset" value="삭제">
    </form>
</body>
</html>
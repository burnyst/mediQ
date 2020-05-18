<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1>FAQ</h1>
<hr/><br/>
    <form method="post" id="frm1" >
        <fieldset>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td width="150" height="30" class="irum">유형</td>
                    <td>
                        <select required="required" name="category" id="category">
                            <option value="">선택</option>
                            <option value="로그인">로그인</option>
                            <option value="약품 정보">약품 정보</option>
                            <option value="기타">기타</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="150" height="30" class="irum">제목</td>
                    <td id="titletd">
                    	<input type="text" id="title" name="title" size="50" placeholder="제목을 입력하세요" required="required" />
                     </td>
                <tr>
                    <td class="irum">내용</td>
                    <td>
                   	 <textarea cols="70" rows="10" id="contents" name="contents" placeholder="내용을 입력하세요" required="required"></textarea>
                   	 <input type="hidden" id="mid" name="mid" value="관리자" />
                    </td>
                <tr>
                    <td colspan="2" class="btn"><br/>
                        <input type="submit" id="submitBtn" name="submitBtn" value="확인"/>
                        <input type="reset" id="resetBtn" name="resetBtn" value="취소"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
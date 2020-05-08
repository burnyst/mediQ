<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mediQ</title>
    <style>
    	body {
    		margin: 0;
    	}
    	h1 {
    		padding: 0px 40px;
    	}
        ul {
            background-color: DodgerBlue;
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        li {
            color: White;
            display: inline-block;
            font-size: 20px;
            padding: 0px 20px;
        }
        a {
            color: white;
            text-decoration: none;
        }
        .search {
        	padding: 40px 0px;
            text-align: center;
        }
        .search label {
        	padding: 40px;
        	font-weight: bold;
        	font-size: 24px;
        }
        .search input[type="text"] {
        	padding: 5px;
        	font-size: 20px;
        	margin: 0px;
        }
        .search input[type="submit"] {
        	font-size: 20px;
        	margin: 0px;
        	padding: 4px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        table, th, td {
            border: 1px solid LightGray;
        }
        tr[class="row"]:hover {
            background-color: LightBlue;
        }
        th {
            text-align: left;
            background: Gray;
            color: White;
            padding: 5px;
        }
        td {
            padding: 5px;
        }
        .hidden {
            display: none;
        }
    </style>
    <script>
        window.addEventListener("load", function() {
            var table = document.querySelectorAll("table.result");
            var len = table[0].rows.length;
            for (var i = 1; i < len; i+=2) {
                table[0].rows[i].addEventListener("click", function() {
                    var desc = this.nextSibling.nextSibling;
                    var className = desc.className;
                    var table = document.querySelectorAll("table.result");
                    var len = table[0].rows.length;
                    for (var i = 2; i < len; i+=2) {
                        table[0].rows[i].className = "hidden";
                    }
                    if ("hidden" === className) {
                        desc.className = "";
                    }
                });
            }
        });
    </script>
</head>
<body>
	<ul>
		<li><h1>mediQ</h1></li>
	    <li><a href="#">의약품검색</a></li>
	    <li><a href="#">마이페이지</a></li>
	    <li><a href="#">FAQ</a></li>
	    <li><a href="#">공지사항</a></li>
	    <li><a href="#">Q&A</a></li>
	</ul>
	<div class="search">
	    <form method="get" action="#">
	        <label>의약품 검색</label>
	        <input type="text" name="pname" />
	        <input type="submit" value=" 조회 " />
	    </form>
	</div>
    <br />
    <hr />
    <h3>검색결과</h3>
    <table class="result">
        <tr>
            <th>분류</th>
            <th>업체명</th>
            <th>품목명</th>
        </tr>
        <tr class="row">
            <td>[35000]기타 이와 유사한 물품</td>
            <td>신용코리아</td>
            <td>레이욘부직포드레싱거즈</td>
        </tr>
        <tr class="hidden">
            <td colspan="3">
                <h4>효능효과</h4>
                <p>창상 및 수술후 처치용</p>
                <h4>용법용량</h4>
                <p>창상 및 수술전후 적의 사용.</p>
                <h4>주의사항(일반)</h4>
                <p>보관 및 취급시 오염방지</p>
            </td>
        </tr>
        <tr class="row">
            <td>[35000]기타 이와 유사한 물품</td>
            <td>신용코리아</td>
            <td>레이욘부직포드레싱거즈</td>
        </tr>
        <tr class="hidden">
            <td colspan="3">
                <h4>효능효과</h4>
                <p>창상 및 수술후 처치용</p>
                <h4>용법용량</h4>
                <p>창상 및 수술전후 적의 사용.</p>
                <h4>주의사항(일반)</h4>
                <p>보관 및 취급시 오염방지</p>
            </td>
        </tr>
        <tr class="row">
            <td>[35000]기타 이와 유사한 물품</td>
            <td>신용코리아</td>
            <td>레이욘부직포드레싱거즈</td>
        </tr>
        <tr class="hidden">
            <td colspan="3">
                <h4>효능효과</h4>
                <p>창상 및 수술후 처치용</p>
                <h4>용법용량</h4>
                <p>창상 및 수술전후 적의 사용.</p>
                <h4>주의사항(일반)</h4>
                <p>보관 및 취급시 오염방지</p>
            </td>
        </tr>
        <tr class="row">
            <td>[35000]기타 이와 유사한 물품</td>
            <td>신용코리아</td>
            <td>레이욘부직포드레싱거즈</td>
        </tr>
        <tr class="hidden">
            <td colspan="3">
                <h4>효능효과</h4>
                <p>창상 및 수술후 처치용</p>
                <h4>용법용량</h4>
                <p>창상 및 수술전후 적의 사용.</p>
                <h4>주의사항(일반)</h4>
                <p>보관 및 취급시 오염방지</p>
            </td>
        </tr>
        <tr class="row">
            <td>[35000]기타 이와 유사한 물품</td>
            <td>신용코리아</td>
            <td>레이욘부직포드레싱거즈</td>
        </tr>
        <tr class="hidden">
            <td colspan="3">
                <h4>효능효과</h4>
                <p>창상 및 수술후 처치용</p>
                <h4>용법용량</h4>
                <p>창상 및 수술전후 적의 사용.</p>
                <h4>주의사항(일반)</h4>
                <p>보관 및 취급시 오염방지</p>
            </td>
        </tr>
        <tr class="row">
            <td>[35000]기타 이와 유사한 물품</td>
            <td>신용코리아</td>
            <td>레이욘부직포드레싱거즈</td>
        </tr>
        <tr class="hidden">
            <td colspan="3">
                <h4>효능효과</h4>
                <p>창상 및 수술후 처치용</p>
                <h4>용법용량</h4>
                <p>창상 및 수술전후 적의 사용.</p>
                <h4>주의사항(일반)</h4>
                <p>보관 및 취급시 오염방지</p>
            </td>
        </tr>
    </table>
</body>
</html>
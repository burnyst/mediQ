<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="join.do" method="post">
			*은 필수입력 항목입니다.<br/>
			<p>
				*<label for="mid">아이디:</label>
				<input id="mid" type="text" name="mid" required>
				<input type="button" name="id1" value="중복확인" onclick="check1()" class="btn btn-warning">최소 3글자 이상 입력하세요.
				<input type="hidden" name="checked" value="0"> 
			</p>
			<p>
				*<label for="mpwd">비밀번호:</label>
				<input id="mpwd" type="password" name="mpwd" required>
			</p>
			<p>
				*<label for="mpwd2">비밀번호 확인:</label>
				<input id="mpwd2" type="password" name="mpwd1" required>
			</p>
			<p>
				*<label for="mname">이름:</label>
				<input id="mname" type="text" name="mname" required style="width:80px;height:15px;">
			</p>
			<p>
				<label for="mbd">생년월일:</label>
				<input type="text" id="mbd" name="mbd" maxlength="4" style="width:50px;height:15px;">년
				<select>
					<option>1</option><option>2</option><option>3</option><option>4</option>
					<option>5</option><option>6</option><option>7</option><option>8</option>
					<option>9</option><option>10</option><option>11</option><option>12</option>
				</select>월
				<select>
					<option>1</option><option>2</option><option>3</option><option>4</option>
					<option>5</option><option>6</option><option>7</option><option>8</option>
					<option>9</option><option>10</option><option>11</option><option>12</option>
					<option>13</option><option>14</option><option>15</option><option>16</option>
					<option>17</option><option>18</option><option>19</option><option>20</option>
					<option>21</option><option>22</option><option>23</option><option>24</option>
					<option>25</option><option>26</option><option>27</option><option>28</option>
					<option>29</option><option>30</option><option>31</option>
				</select>일
			</p>
			<p>
				<label for="memail">이메일:</label>
				<input type="email" id="memail" name="memail" style="width:80">@
				<select name="domain" onchange="domainCheck();">
		    <option value ="선택하세요" selected="selected">선택하세요</option>
		    <option value ="naver.com" >naver.com</option>
		    <option value ="hanmail.net">hanmail.net</option>
		    <option value ="nate.com">nate.com</option> 
		    <option value ="yahoo.com">yahoo.com</option>
		    </select>
			</p>
			<p>
				<label for="mhp">핸드폰번호:</label>
				<select name="mhp">
					<option selected="selected">010</option>
					<option>011</option>
					<option>016</option>
					<option>017</option>
					<option>018</option>
					<option>019</option>
				</select>
				<input id="mhp" type="text" name="mhp" maxlength="4" style="width:50px;height:15px;">-
				<input id="mhp2" type="text" name="mhp" maxlength="4" style="width:50px;height:15px;">
			</p>
			<ul>
       	<button type="button" onclick="location.href='index.jsp'">돌아가기</button>
				<input type="submit" onclick="location.href='joinSuccess.jsp'" value="가입하기"/>
			</ul>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	  <!-- <script>
			  $( function() {
			    $( "#datepicker" ).datepicker();
			  } );
		</script> -->
</head>
<body>
<h1>회원가입</h1>
<form action="#" method="post">
			<p>
				<label for="mid">아이디:</label>
				<input id="mid" type="text" name="mid">
			</p>
			<p>
				<label for="mpwd">비밀번호:</label>
				<input id="mpwd" type="password" name="mpwd">
			</p>
			<p>
				<label for="mpwd2">비밀번호 확인:</label>
				<input id="mpwd2" type="password" name="mpwd2">
			</p>
			<p>
				<label for="mname">이름:</label>
				<input id="mname" type="text" name="mname">
			</p>
			<p>
				<label for="datepicker">생년월일:</label>
				<!--<input type="text" id="datepicker" name="mbd"> -->
				<input type="text" id="mbd" name="mbd">년
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
				<input type="email" id="memail" name="memail">
			</p>
			<p>
				<label for="mhp">핸드폰번호:</label>
				<select name="mhp">
					<option>010</option>
					<option>011</option>
					<option>017</option>
					<option>019</option>
				</select>
				<input id="mhp" type="text" name="mhp">-
				<input id="mhp2" type="text" name="mhp2">
			</p>
			<p>
				<input type="reset" value="취소"/>
				<input type="submit" value="가입하기"/>
			</p>
</form>
</body>
</html>
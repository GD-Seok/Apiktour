<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="member.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="logo"></div>
		</div>
		<div class="main">
			<h4>회원가입</h4>
			<div>
				<form action="#">
					<label for="fname"></label> <input type="text" id="fname"
						name="firstname" placeholder="이메일 ( ex@apiktour.com)"> 
					<label for="lname"></label> <input type="text" id="lname"
						name="lastname" placeholder="비밀번호"> 
						<label for="lname"></label> <input type="text" id="lname"
						name="lastname" placeholder="비밀번호 확인">
						<label for="lname"></label> <input type="text" id="lname"
						name="lastname" placeholder="이름"> 
						<button>남자</button>
						<button>여자</button>						
					<select id="country" name="country">
						<option value="australia">20대</option>
						<option value="canada">30대</option>
						<option value="usa">40대</option>
					</select> 
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
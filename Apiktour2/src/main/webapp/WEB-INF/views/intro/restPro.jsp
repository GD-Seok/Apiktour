<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/intro/rest.css">

	
	<meta charset="UTF-8">
	<title>쉴래? 놀래?</title>
	
	<script type="text/javascript">

	</script>
</head>

<body>
<%
 	request.setCharacterEncoding("utf-8");
	String slider_val=request.getParameter("sliderVal");
%>
    <div class="wrap">
		<div class="container">
			<div class="textOne"><%=slider_val %>...</div>
		</div>

		<div id="container2">
			<span class="textTwo">Level 을</span><br> 
			<span class="textThree">선택하셨습니다.</span>
		</div>
		<!-- container -->
		<button onclick="location.href='result.html'">다음</button>
	</div> <!-- wrap-->
 </body>

</html>
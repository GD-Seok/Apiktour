<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/intro/intro.css"> --%>
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/intro/intro_event.css"> --%>	
	<script src='https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.10.1/lodash.min.js'></script>
	<%-- <script src="${pageContext.request.contextPath}/web/js/slideEvent.js"></script> --%>
	
	<!--  -->
	<link href="<c:url value='/resources/css/intro/intro.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/intro/intro_event.css' />" rel="stylesheet"></link>
	<script type="text/javascript" src="<c:url value='/resources/js/intro/slideEvent.js' />"></script>
	
	<title>쉴래? 놀래?</title>

</head>
<body>

<%
 	request.setCharacterEncoding("utf-8");
%>
	<div id="wrap">
		<div id="container">
			<!-- 1번째 인트로 부분 -->
			<div id="slide01" class="background">
				<div class="content-wrapper">
					<h1 class="content-title">
						<p class="bgimg">
							<img src="${pageContext.request.contextPath}/resources/images/icon/balloon.png">
						</p>
						<p class="textTitle">
							나는<br>아무것도<br>하기싫다...
						</p>
					</h1>
					<p class="content-p"></p>
				</div>
			</div>

			<!-- 2번째 인트로 부분 -->
			<div id="slide02" class="background">
				<div class="content-wrapper2">
					<section class="flexTxt"> 
						<figure class="reatSection">
							<img src="${pageContext.request.contextPath}/resources/images/icon/rest_ring.png" class="restRing" alt="restRing" /> 
							<img src="${pageContext.request.contextPath}/resources/images/icon/rest.png" class="rest" alt="rest" /> 
						</figure> 
						<figure class="restafter"> 
							<a href="choiceRest.do" class="clickRest"></a> 
							<img src="${pageContext.request.contextPath}/resources/images/bg/rest_change.jpg" class="change" alt="change" />
						</figure> 
					</section>

					<section class="flexTxt"> 
						<figure class="playSection">
							<img src="${pageContext.request.contextPath}/resources/images/icon/play_ring.png" class="playRing" alt="playRing" /> 
							<img src="${pageContext.request.contextPath}/resources/images/icon/play.png"	class="play" alt="play" /> 
						</figure> 
						<figure class="playafter"> 
							<a href="choicePlay.do" class="clickPlay"></a> 
							<img	src="${pageContext.request.contextPath}/resources/images/bg/play_change.jpg" class="change" alt="change" />
						</figure> 
					</section>
				</div>
			</div>
		</div>
		<!-- container -->
	</div>
</body>

<script>    
	$(".reatSection").mousemove(function(){
	    setTimeout(function(){
	        $(".restRing").hide();
	        $(".restSelect").hide();
	        $(".restafter").css("display","block");
	    },1050);
	});
	$("section:nth-child(2)").mousemove(function(){
	    $(".restafter").hide();
	    $(".restRing").show();
	});
    
	$(".playSection").mousemove(function(){
	    setTimeout(function(){
	        $(".playRing").hide();
	        $(".playSelect").hide();
	        $(".playafter").css("display","block");
	    },1050);    
	}); 
	$("section:first-child").mousemove(function(){
	    $(".playafter").hide();
	    $(".playRing").show();
	});    
</script>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<table width="600" border="0" cellspacing="0" cellpagging="0" align="center">
	<tr>
		<td colspan="2"><h3>지도 정보 </h3></td>	
	</tr>
	<tr>
		<td>코스 아이디</td>				
		<td>${listmap.locnum }</td>		
	</tr>
	<tr>
		<td>코스명</td>
		<td>${listmap.locname }</td>
	</tr>
	<tr>
		<td>경도 값</td>		
		<td>${listmap.locationx }</td>		
	</tr>
	<tr>
		<td>위도 값</td>		
		<td>${listmap.locationy }</td>		
	</tr>
	<tr>
		<td>장소 type 값</td>
		<td>${listmap.loctype }</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="수정" 
			   onclick="location.href='updatemap.do?locnum=${listmap.locnum}'">
			<input type="button" value="삭제" 
			   onclick="location.href='deletemap.do?locnum=${listmap.locnum}'">
			<input type="button" value="목록" onclick="location.href='05_admin_map_se.do'">
		</td>
	</tr>
</table>
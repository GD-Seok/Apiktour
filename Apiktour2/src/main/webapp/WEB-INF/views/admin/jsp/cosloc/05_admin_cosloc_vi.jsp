<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<table width="600" border="0" cellspacing="0" cellpagging="0" align="center">
	<tr>
		<td colspan="2"><h3>코스 장소 정보 </h3></td>	
	</tr>
	<tr>
		<td>코스 id 값</td>				
		<td>${listcosloc.cosnum }</td>		
	</tr>
	<tr>
		<td>지도 id 값</td>
		<td>${listcosloc.locnum }</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="수정" 
			   onclick="location.href='updatecosloc.do?cosnum=${listcosloc.cosnum}&locnum=${listcosloc.locnum}'">
			<input type="button" value="삭제" 
			   onclick="location.href='deletecosloc.do?ccosnum=${listcosloc.cosnum}&locnum=${listcosloc.locnum}'">
			<input type="button" value="목록" onclick="location.href='05_admin_cosloc_se.do'">
		</td>
	</tr>
</table>
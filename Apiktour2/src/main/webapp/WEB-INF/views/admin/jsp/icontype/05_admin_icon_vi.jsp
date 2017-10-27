<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<table width="600" border="0" cellspacing="0" cellpagging="0" align="center">
	<tr>
		<td colspan="2"><h3>아이콘 정보 </h3></td>	
	</tr>
	<tr>
		<td>장소 타입</td>				
		<td>${listicontype.loctype }</td>		
	</tr>
	<tr>
		<td>타입 설명</td>		
		<td>${listicontype.type }</td>		
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="수정" 
			   onclick="location.href='updateicontype.do?loctype=${listicontype.loctype}'">
			<input type="button" value="삭제" 
			   onclick="location.href='deleteicontype.do?loctype=${listicontype.loctype}'">
			<input type="button" value="목록" onclick="location.href='05_admin_icon_se.do'">
		</td>
	</tr>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<form action="list.do" name="search" method="get" onsubmit="return searchCheck()">
	<table align="center" width="200" border="0" cellspacing="0" cellpagging="2">
		<tr>
			<td align="center">
				<select name="keyField">
					<option value="loctype">장소 타입</option>
					<option value="type">장소 정보</option>
				</select>
			</td>
			<td>
				<input type="text" size="16" name="keyWord">
			</td>
			<td>
				<input type="submit" value="찾기">
			</td>
		</tr>
	</table>
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="right" colspan="5" >
			<input type = "button" value="아이콘 등록" onclick="location.href='05_admin_icon_in.do'">
		</td>
	</tr>
	<tr>
		<td>총 아이콘 개수 : ${count}</td>
	</tr>
	
	<tr bgcolor="#F3F3F3">
		<td width="100">장소 타입</td>
		<td width="70">장소 정보</td>
	</tr>
	<!-- 데이터의 유무에 따라서 -->
	<c:if test="${count==0}">
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="article" items="${listicontype}">	
		<tr>
			<td><a href="detailsicontype.do?loctype=${article.loctype }">${article.loctype }</a></td>
			<td>${article.type }</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td align="center" colspan="5"></td>
	</tr>
</table>
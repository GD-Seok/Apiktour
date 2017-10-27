<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function inputCheck(){
		if(document.getElementsByName("locnum")[0].value==""){
			alert("지도 id값을 입력해주세요");
			return false;
		}else if(document.getElementsByName("locationx")[0].value==""){
			alert("locationx을입력해주세요");
			return false;
		}else if(document.getElementsByName("locationy")[0].value==""){
			alert("locationy을입력해주세요");
			return false;
		}else{
		document.forms.regForm.submit();
		}
	}
</script>
<!--게시판의 글쓰기와 동일하다. -->
<form name="regForm" action="updatemap.do" method="post">
	<table width="600" border="0" cellspacing="0" cellpagging="0"
		align="center">
		<tr>
			<td colspan="2"><h3>코스 수정</h3></td>
		</tr>
		<tr>
			<td>지도 아이디</td>
			<td><input type="text" name="locnum"
				value="${listmap.locnum }" readonly="true"></td>
		</tr>
		<tr>
			<td>장소명</td>
			<td><input type="text" name="locname"
				value="${listmap.locname }"></td>
		</tr>
		<tr>
			<td>경도 값</td>
			<td><input type="text" name="locationx" value="${listmap.locationx }">
		</td>
		<tr>
			<td>위도 값</td>
			<td><input type="text" name="locationy" value="${listmap.locationy }">
		</td>
		</tr>
		<tr>
			<td>장소 type 값</td>
			<td><input type="text" name="loctype" value="${listmap.loctype }">
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2"><input type="button" value="수정완료"
				onclick="inputCheck()"> <input type="reset" value="다시쓰기">
				<input type="button" value="목록"
				onclick="location.href='05_admin_map_se.do'"></td>
		</tr>
	</table>
</form>


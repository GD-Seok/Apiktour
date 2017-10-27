<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function inputCheck() {
		if (document.getElementsByName("cosnum")[0].value == "") {
			alert("코스 id값을 입력해주세요");
			return false;
		} else if (document.getElementsByName("locnum")[0].value == "") {
			alert("지도 id 값을 입력해주세요");
			return false;
		} else {
			document.forms.regForm.submit();
		}
	}
</script>
<!--게시판의 글쓰기와 동일하다. -->
<form name="regForm" action="updatecosloc.do" method="post">
	<table width="600" border="0" cellspacing="0" cellpagging="0"
		align="center">
		<tr>
			<td colspan="2"><h3>코스 장소 정보</h3></td>
		</tr>
		<tr>
			<td>코스 id 값</td>
			<td><input type="text" name="cosnum" value="${listcosloc.cosnum }"> </td>
		</tr>	
		<tr>
			<td>지도 id 값</td>
			<td><input type="text" name="locnum" value="${listcosloc.locnum }"> </td>
		</tr>
		<tr>
			<td align="right" colspan="2"><input type="button" value="수정완료"
				onclick="inputCheck()"> <input type="reset" value="다시쓰기">
				<input type="button" value="목록"
				onclick="location.href='05_admin_cosloc_se.do'"></td>
		</tr>
	</table>
</form>


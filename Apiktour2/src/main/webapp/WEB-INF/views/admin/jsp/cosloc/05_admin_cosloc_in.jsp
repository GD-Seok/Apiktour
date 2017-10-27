<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>코스 장소 관리</title>
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
</head>
<body onLoad="regForm.id.focus()">
	<br>
	<br>
	<table class="container">
		<tr>
			<td align="center" valign="middle" bgcolor="#FFFFCC">
				<table border="1" cellspacing="0" cellpadding="2" align="center">
					<form name="regForm" method="post" action="insertcosloc.do">
						<tr align="center" bgcolor="#996600">
							<td colspan="3"><font color="#FFFFFF"><b>코스 장소 등록
										페이지</b></font></td>
						</tr>
						<tr>
							<td width="16%">선택할 코스 id</td>
							<td width="57%"><input type="text" name="cosnum" size="15">
								<input type="button" value="코스 검색 "
								onClick="idCheck(this.form.id.value)"></td>
							<td width="27%">선택할 코스를 검색해주세요 (1~999)</td>
						</tr>					
						<tr>
							<td>등록할 장소 id값</td>
							<td><input type="text" name="locnum" size="15"></td>
							<td>등록할 지도 id값을 입력해주세요. (1~999) </td>
						</tr>						
					<tr>
						<td colspan="3" align="center"><input type="button"
							value="코스 장소 등록" onclick="inputCheck()"> &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; <input type="reset" value="다시쓰기"></td>
					</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
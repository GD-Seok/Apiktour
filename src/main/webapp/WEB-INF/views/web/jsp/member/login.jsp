<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/web/css/member/login.css?ver=1" type="text/css" rel="stylesheet">
<div class="titbox case1">
			<h2>회원계정으로 로그인하기</h2>
		</div><!-- //titbox -->

		<div class="contents member">
			<div class="wrap">
				<div class="memberbox">
					<div class="loginbox">
						<p>
							<input type="text" name="" id="" class="icon_id" placeholder="이메일 아이디 입력"  />
						</p>
						<p>
							<input type="text" name="" id="" class="icon_pw" placeholder="비밀번호 입력" />
						</p>
			
						<a href="#" class="btn1">로그인</a>
			
						<div class="logincheck">
							<input type="checkbox" id="loginck" name="loginck" value="로그인" checked="">
							<label for="loginck">로그인 상태 유지</label>
						</div>

						<div class="login_txt">
							<p>아이디 또는 비밀번호를 잊어버리셨나요?</p>
							<a href="#">아이디 / 비밀번호 찾기</a>
						</div>
						<span><a href="javascript:void(0)" onclick="closePopup()">close</a></span>
					</div>
				</div>
			</div><!-- //wrap -->
		</div><!-- //contents  -->
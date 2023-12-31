<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<body>
	<div class="wrap gray">

		<div class="membership_box">

			<!-- 타이틀 -->
			<div class="title">
				<h1>
					<img src="/jdgr/resources/user/images/logo.svg" alt="로고">
					<!-- <strong>회원가입</strong> -->
				</h1>
			</div>

			<div>
				<h1>비밀번호 찾기</h1>
			</div>

			<form action="/jdgr/member/changepwd" method="post">
				<!-- 아이디 찾기 영역 -->
				<div class="membership_area">

					<div class="form_box ico_pwd">
						<input type="password" name="newPwd" placeholder="새 비밀번호"> <span
							class="txt_msg">영문 + 숫자 포함하여 7자 이상이어야 합니다.</span>
					</div>
					<div class="form_box ico_pwd">
						<input type="password" name="newPwd2" placeholder="비밀번호 확인"> <span
							class="txt_msg">비밀번호가 서로 다릅니다.</span>
					</div>

				</div>


				<!-- 버튼 -->
				<div class="btn_area">
					<div class="btn_box btn_group">
						<button type="submit" class="modal_open change_pwd"
							>변경 완료</button>
<!-- 							data-target="#pop_complete" -->
					</div>
					<ul class="etc_btn">
						<li><a href="/jdgr/member/join">회원가입</a></li>
						<li><a href="/jdgr/member/findid">아이디 찾기</a></li>
					</ul>
				</div>
			</form>

		</div>

		<footer>Copyright © KH Group3 PowerBloger. All Rights
			Reserved.</footer>

<!-- 		<!-- 이메일 팝업 --> -->
<!-- 		<div id="pop_complete" class="modal_bg complete"> -->
<!-- 			<div class="modal_box"> -->
<!-- 				<div class="modal_header"> -->
<!-- 					<button class="modal_close">닫기</button> -->
<!-- 				</div> -->
<!-- 				<div class="modal_container"> -->

<!-- 					<div class="modal_content"> -->
<!-- 						<div class="img"></div> -->
<!-- 						<div class="txt"> -->
<!-- 							<strong>비밀번호 변경 완료</strong> -->
<!-- 						</div> -->
<!-- 					</div> -->

<!-- 				</div> -->
<!-- 				<div class="modal_footer"> -->
<!-- 					<button class="modal_close btn_black">로그인 하러가기</button> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>

	<%@include file="../common/footer.jsp"%>
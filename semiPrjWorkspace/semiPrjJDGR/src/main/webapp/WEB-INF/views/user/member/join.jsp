<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../common/header.jsp"%>
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
            <h1>관리자</h1>
        </div>
        <!-- 로그인/회원가입 영역 -->
        <form action="/jdgr/admin/login" method="post">
			<!-- 로그인/회원가입 영역 -->
			<div class="membership_area">
				<div class="form_box ico_id">
					<input type="text" name="memberId" placeholder="아이디를 입력해주세요.">
				</div>
				<div class="form_box ico_pwd">
					<input type="password" name="memberPwd" placeholder="비밀번호를 입력해주세요.">
				</div>
			</div>

			<!-- 버튼 -->
			<div class="btn_area">
				<button type="submit">로그인</button>
			</div>
		</form>

<%@include file = "../common/footer.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>

<div class="wrap gray">

	<div class="membership_box">

		<!-- 타이틀 -->
		<div class="title">
			<h1>
				<img src="/jdgr/resources/user/images/logo.svg" alt="로고">
				<!-- <strong>회원가입</strong> -->
			</h1>
		</div>
		<form action="/jdgr/member/join" method="post"
			onsubmit="return checkValidate();">
			<!-- 회원가입 영역 -->
			<div class="membership_area">
				<!-- 아이디 입력, 중복 확인 -->
				<div class="form_box login_div">
					<div class="inp_btn ico_id">
						<input type="text" name="joinId" placeholder="아이디를 입력해주세요.">
						<button type="button" onclick="checkIdDup()">중복확인</button>
					</div>
					<span class="txt_msg">아이디 중복확인이 완료되었습니다.</span>
				</div>

				<!-- 이름 입력 -->
				<div class="form_box ico_id">
					<input type="text" name="joinName" placeholder="이름을 입력해주세요.">
				</div>

				<!-- 이메일 인증 버튼 -->
				<div class="btn_box btn_group">
					<button class="btn_black modal_open" data-target="#pop_email"
						type="button">이메일 인증하기</button>
				</div>

				<!-- 닉네임, 중복 확인 -->
				<div class="form_box login_div">
					<div class="inp_btn ico_id">
						<input type="text" name="joinNick" placeholder="닉네임을 입력해주세요.">
						<button type="button" onclick="checkNickDup()">중복확인</button>
					</div>
					<span class="txt_msg">닉네임 중복확인이 완료되었습니다.</span>
				</div>


				<!-- 비번 입력 -->
				<div class="form_box ico_pwd">
					<input type="password" name="joinPwd" placeholder="비밀번호를 입력해주세요.">
					<span class="txt_msg">비밀번호 형식이 맞지 않습니다.</span>
				</div>

				<!-- 비번 확인 -->
				<div class="form_box ico_pwd">
					<input type="password" name="joinPwd2" placeholder="비밀번호 확인">
					<span class="txt_msg">비밀번호가 다릅니다.</span>
				</div>

				<!-- 전화번호 입력 -->
				<div class="form_box ico_tel">
					<input type="tel" name="joinTel"
						placeholder="전화번호를 입력해주세요.(숫자만 입력)"> <span class="txt_msg">아이디
						중복확인이 완료되었습니다.</span>
				</div>
			</div>
		<input type="hidden" id ="checkNum">
		<input type="hidden" id ="nowEmail" name="nick">

			<!-- 버튼 -->
			<div class="btn_area">
				<button type="submit">가입하기</button>
				<ul class="etc_btn">
					<li><a href="">회원가입</a></li>
					<li><a href="">아이디 찾기</a></li>
					<li><a href="">비밀번호 찾기</a></li>
				</ul>
			</div>
		</form>
	</div>
	<footer>Copyright © KH Group3 PowerBloger. All Rights
		Reserved.</footer>


</div>

<!-- 이메일 팝업 -->
<div id="pop_email" class="modal_bg">
	<div class="modal_box">
		<div class="modal_header">
			<h2>이메일 인증</h2>
			<button class="modal_close">닫기</button>
		</div>
		<div class="modal_container">
			<!-- 이메일 입력 -->
			<div class="form_box">
				이메일 <input class="input_email" type="email" name="email1">@
				<input class="input_email" type="email" name="email2"> <select
					class="selet_addr" name="">
					<option value="">직접입력</option>
					<option value="naver.com">naver.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="daum.net">daum.net</option>
				</select>
			</div>
			<!-- 이메일 전송 버튼 -->
			<div class="btn_box btn_group">
				<button class="btn_black modal_open" data-target="#pop_email"
					onclick="sendEmail()">인증번호 전송</button>
			</div>

			<!-- 인증번호 입력 -->
			<div class="form_box">
				<div class="form_box inp_btn ">
					인증번호 <input type="text" name="inputCheckNum" class="input_num">
					<button onclick="certification()">인증하기</button>
				</div>
				<span class="txt_msg">닉네임 중복확인이 완료되었습니다.</span>
			</div>
		</div>

		<div class="modal_footer">
			<button class="modal_close btn_black">확인</button>
		</div>
	</div>
</div>

</body>
</html>

<script>
	function checkValidate(){
		//중복검사 통과 여부
		if(!window.idOk){
			alert("아이디 중복검사를 완료하세요");
			document.querySelector("input[name=joinId]").focus();
			return false;
		}
		if(!window.nickOk){
			alert("닉네임 중복검사를 완료하세요");
			document.querySelector("input[name=joinNick]").focus();
			return false;
		}
		return true;
	}
	
	
	//아이디 중복체크
	function checkIdDup(){
		const joinIdValue = document.querySelector("input[name=joinId]").value;
		console.log(joinIdValue);
		fetch("/jdgr/member/check/id?joinId=" + joinIdValue)
		.then( (resp) => { return resp.json() } )
		.then( (data) => { 
			const result = data.msg;
			const isOk = result === "ok";
			if(isOk){
				alert("사용가능");
				window.idOk = true;
			}else{
				alert("사용불가");
				window.idOk = false;
			}
		} );
	}
	
	//닉네임 중복체크
	function checkNickDup(){
		const joinNickValue = document.querySelector("input[name=joinNick]").value;
		console.log(joinNickValue);
		fetch("/jdgr/member/check/nick?joinNick=" + joinNickValue)
		.then( (resp) => { return resp.json() } )
		.then( (data) => { 
			const result = data.msg;
			const isOk = result === "ok";
			if(isOk){
				alert("사용가능");
				window.nickOk = true;
			}else{
				alert("사용불가");
				window.nickOk = false;
			}
		} );
	}
	
	function sendEmail(){
		const email1 = document.querySelector("input[name=email1]").value;
		const email2 = document.querySelector("input[name=email2]").value;
		const email = email1+"@"+email2
		const checkNum = Math.floor(Math.random() *(900000) +100000 );
		
		console.log(checkNum);
		console.log(email);
		fetch("/jdgr/member/sendemail?email=" + email+"&checkNum=" + checkNum )
		.then( (resp) => { return resp.json() } )
		.then( (data) => { 
			const result = data.msg;
			const isOk = result === "ok";
			if(isOk){
				document.getElementById("checkNum").value = checkNum;
				
			}else{
				alert("인증실패");
			}
		} );
		
		console.log(document.querySelector("#checkNum").value);
	}

		function certification(){
		const nowCeckNum = document.querySelector("#checkNum").value;
		const inputCheckNum = document.querySelector("input[name=inputCheckNum]").value;
		

		if(nowCeckNum === inputCheckNum){
			
		const email1 = document.querySelector("input[name=email1]").value;
		const email2 = document.querySelector("input[name=email2]").value;
		const email = email1+"@"+email2;
			document.getElementById("nowEmail").value = email;
		}
		else{
			alert("인증실패");
			
		}
	}
</script>

<!-- <div class="form_box ico_pwd">
	                <div class="inp_btn">
	                    <input type="text" name="" id="">
	                    <button>인증하기</button>
	                </div>
	                <span class="txt_msg">전화번호 형식이 맞지 않습니다.</span>
	            </div> -->


<!-- <div class="form_box ico_pwd err">
	                <input type="password" name="" placeholder="hresgfer">
	                <span class="txt_msg">아이디 중복확인이 완료되었습니다.</span>
	            </div>
	
	            <div class="form_box ico_pwd err">
	                <input type="password" name="" placeholder="hresgfer">
	                <span class="txt_msg">아이디 중복확인이 완료되었습니다.</span>
	            </div>
	            
	            <div class="form_box ico_pwd com">
	                <input type="password" name="" placeholder="hresgfer">
	                <span class="txt_msg">아이디 중복확인이 완료되었습니다.</span>
	            </div> -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../common/header.jsp"%>
<%
	MemberVo printIdVo = (MemberVo)request.getAttribute("printIdVo");
%>
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
            <h1>아이디 찾기</h1>
        </div>

        <div class="print_id">
            <div><strong><%= printIdVo.getMemName() %></strong>님의 아이디는</div>
            <br>
            <div> "<%=printIdVo.getMemId() %>"</div>
            <br>
            <div>입니다. </div>
        </div>
       

        <!-- 버튼 -->
        <div class="btn_area">
            <a href="/jdgr/member/login">로그인 하러가기</a>
            <ul class="etc_btn">
                <li><a href="/jdgr/member/join">회원가입</a></li>
                <li><a href="/jdgr/member/findpwd">비밀번호 찾기</a></li>
            </ul>
        </div>

    </div>
<%@include file = "../common/footer.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <%@ include file="/WEB-INF/views/user/blogSet/side.jsp" %>

            <div class="right">
                <h2>블로그 정보</h2>

                <div class="content">

                    <div class="data_dl">
                        <dl>
                            <dt>블로그명</dt>
                            <dd>
                                <div class="inp_box">
                                    <input type="text">
                                    <span>한글, 영문, 숫자 혼용가능 (한글기준 25자 이내)</span>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>블로그 닉네임</dt>
                            <dd>
                                <div class="inp_box">
                                    <input type="text">
                                    <span>한글, 영문, 숫자 혼용가능 (한글기준 25자 이내)</span>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>블로그 프로필 이미지</dt>
                            <dd>
                                <div class="profile_box">
                                    <div class="img"><img src="/jdgr/resources/user/images/ico/ico_profile.svg" alt=""></div>
                                    <div class="profile_btn">
                                        <input type="file" id="blogImg" name="blogImg">
                                        <label for="blogImg">등록</label>
                                        <span class="txt">프로필 이미지는 가로 200px, 세로 200px로 생성됩니다.</span>
                                    </div>
                                </div>
                            </dd>
                        </dl>
                    </div>

                    <div class="blog_set_btn">
                        <a href="">저장</a>
                    </div>

                </div>

            </div>

        </div>

    </div>
</main>
<!-- //main -->

<%@ include file="/WEB-INF/views/user/common/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <%@ include file="/WEB-INF/views/user/blogSet/side.jsp" %>

            <div class="right">
                <h2>레이아웃-위젯 설정</h2>

                <div class="content">

                    <div class="data_dl">
                        <dl>
                            <dt>레이아웃 선택</dt>
                            <dd>
                                <div class="layout_select">
                                    <ul>
                                        <li>
                                            <input type="radio" id="layout1" name="layoutSelect" checked="">
                                            <label for="layout1"><span></span></label>
                                        </li>
                                        <li>
                                            <input type="radio" id="layout2" name="layoutSelect">
                                            <label for="layout2"><span></span></label>
                                        </li>
                                        <li>
                                            <input type="radio" id="layout3" name="layoutSelect">
                                            <label for="layout3"><span></span></label>
                                        </li>
                                    </ul>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>최근댓글 보이기</dt>
                            <dd>
                                <div class="show_chk">
                                    <input type="checkbox" id="show1">
                                    <label for="show1"></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>구독블로그 보이기</dt>
                            <dd>
                                <div class="show_chk">
                                    <input type="checkbox" id="show2">
                                    <label for="show2"></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>방문자수 보이기</dt>
                            <dd>
                                <div class="show_chk">
                                    <input type="checkbox" id="show3">
                                    <label for="show3"></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>시계 보이기</dt>
                            <dd>
                                <div class="show_chk">
                                    <input type="checkbox" id="show4">
                                    <label for="show4"></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>지도 보이기</dt>
                            <dd>
                                <div class="show_chk">
                                    <input type="checkbox" id="show5">
                                    <label for="show5"></label>
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
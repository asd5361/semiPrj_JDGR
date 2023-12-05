<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <%@ include file="/WEB-INF/views/user/blogSet/side.jsp" %>

            <div class="right">
                <h2>스킨 선택</h2>

                <div class="content">

                    <div class="blogSkin_select">
                        <ul>
                            <li>
                                <input type="radio" id="skin1" name="skinSelect">
                                <label for="skin1">
                                    <div class="color">#FFC1C1</div>
                                    <div class="txt">
                                        배경색 #FFC1C1
                                        글자색 #333333
                                    </div>
                                </label>
                            </li>
                            <li>
                                <input type="radio" id="skin2" name="skinSelect">
                                <label for="skin2">
                                    <div class="color">#333333</div>
                                    <div class="txt">
                                        배경색 #333333
                                        글자색 #FFFFFF
                                    </div>
                                </label>
                            </li>
                            <li>
                                <input type="radio" id="skin3" name="skinSelect">
                                <label for="skin3">
                                    <div class="color">#1F34EF</div>
                                    <div class="txt">
                                        배경색 #1F34EF
                                        글자색 #FFFFFF
                                    </div>
                                </label>
                            </li>
                            <li>
                                <input type="radio" id="skin4" name="skinSelect" checked="">
                                <label for="skin4">
                                    <div class="color">#FFFFFF</div>
                                    <div class="txt">
                                        배경색 #FFFFFF
                                        글자색 #333333
                                    </div>
                                </label>
                            </li>
                            <li>
                                <input type="radio" id="skin5" name="skinSelect">
                                <label for="skin5">
                                    <div class="color">#FFEAC1</div>
                                    <div class="txt">
                                        배경색 #FFEAC1
                                        글자색 #333333
                                    </div>
                                </label>
                            </li>
                            <li>
                                <input type="radio" id="skin6" name="skinSelect">
                                <label for="skin6">
                                    <div class="color">#DEFFE5</div>
                                    <div class="txt">
                                        배경색 #DEFFE5
                                        글자색 #333333
                                    </div>
                                </label>
                            </li>
                        </ul>
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
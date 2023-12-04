<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <%@ include file="/WEB-INF/views/user/blogSet/side.jsp" %>

            <div class="right">
                <h2>구독한 블로그</h2>

                <div class="content">

                    <div class="gd_tbl">
                        <table>
                            <colgroup>
                                <col width="50px">
                                <col width="">
                                <col width="10%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th colspan="col">
                                        <div class="chk_box solo chk_All">
                                            <span>
                                                <input type="checkbox" id="chk_All">
                                                <label for="chk_All">&nbsp;</label>
                                            </span>
                                        </div>
                                    </th>
                                    <th colspan="col">구독블로그</th>
                                    <th colspan="col">구독삭제</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <div class="chk_box solo">
                                            <span>
                                                <input type="checkbox" id="chk_02">
                                                <label for="chk_02">&nbsp;</label>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="info">
                                            <a href="">
                                                <strong>구독한사람닉네임</strong>
                                                <span>블로그명입니다.</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="gd_btn">
                                            <button>구독삭제</button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="chk_box solo">
                                            <span>
                                                <input type="checkbox" id="chk_03">
                                                <label for="chk_03">&nbsp;</label>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="info">
                                            <a href="">
                                                <strong>구독한사람닉네임</strong>
                                                <span>블로그명입니다.</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="gd_btn">
                                            <button>구독삭제</button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="chk_box solo">
                                            <span>
                                                <input type="checkbox" id="chk_04">
                                                <label for="chk_04">&nbsp;</label>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="info">
                                            <a href="">
                                                <strong>구독한사람닉네임</strong>
                                                <span>블로그명입니다.</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="gd_btn">
                                            <button>구독삭제</button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="chk_box solo">
                                            <span>
                                                <input type="checkbox" id="chk_05">
                                                <label for="chk_05">&nbsp;</label>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="info">
                                            <a href="">
                                                <strong>구독한사람닉네임</strong>
                                                <span>블로그명입니다.</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="gd_btn">
                                            <button>구독삭제</button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="chk_box solo">
                                            <span>
                                                <input type="checkbox" id="chk_06">
                                                <label for="chk_06">&nbsp;</label>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="info">
                                            <a href="">
                                                <strong>구독한사람닉네임</strong>
                                                <span>블로그명입니다.</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="gd_btn">
                                            <button>구독삭제</button>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="chk_box solo">
                                            <span>
                                                <input type="checkbox" id="chk_07">
                                                <label for="chk_07">&nbsp;</label>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="info">
                                            <a href="">
                                                <strong>구독한사람닉네임</strong>
                                                <span>블로그명입니다.</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="gd_btn">
                                            <button>구독삭제</button>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="gd_chk_btn">
                            <a href="" class="allchk_Btn">전체선택</a>
                            <a href="">선택삭제</a>
                        </div>
                    </div>

                    <div class="paging_box mt30">
                        <ul>
                            <li class="prev_all"><a href="" title="최신페이지로 이동"></a></li>
                            <li class="prev"><a href="" title="이전페이지로 이동"></a></li>
                            <li class="on"><a href="">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href="">4</a></li>
                            <li><a href="">5</a></li>
                            <li><a href="">6</a></li>
                            <li><a href="">7</a></li>
                            <li><a href="">8</a></li>
                            <li><a href="">9</a></li>
                            <li><a href="">10</a></li>
                            <li class="next"><a href="" title="다음페이지로 이동"></a></li>
                            <li class="next_all"><a href="" title="마지막페이지로 이동"></a></li>
                        </ul>
                    </div>

                </div>

            </div>

        </div>

    </div>
</main>
<!-- //main -->

<%@ include file="/WEB-INF/views/user/common/footer.jsp" %>
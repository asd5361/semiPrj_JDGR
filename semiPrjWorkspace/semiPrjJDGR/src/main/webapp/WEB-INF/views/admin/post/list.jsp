<%@page import="java.util.Map"%>
<%@page import="com.semi.jdgr.page.vo.PageVo"%>
<%@page import="com.semi.jdgr.post.vo.PostVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<PostVo> postVoList = (List<PostVo>)request.getAttribute("postVoList");
//     	PageVo pvo = (PageVo)request.getAttribute("pvo");
//     	Map<String, String> searchMap = (Map<String,String>)request.getAttribute("searchMap");
    
    %>

<%@include file = "/WEB-INF/views/admin/common/header.jsp" %>
                
            <!-- container -->
            <div class="container">
                <!-- 제목 -->
                <div class="tit_box">
                    <h2>포스트 관리 목록</h2>
                </div>
                <form action="/jdgr/admin/post/list" method="post">
                <!-- 검색박스 예시 -->
                <div class="search_box">
                    <div class="search_item">
                        <label for="sel_01">작성자</label>
                        <div class="form_box">
                            <input type="text" id="inp_02" name="memNick">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">제목</label>
                        <div class="form_box">
                            <input type="text" id="inp_02" name="aa">
                        </div>
                    </div>

                   
                </div>
                
                <!-- 버튼 -->
                <div class="btn_box_group right">
                    <div class="btn_box">
                        <button class="btn_gray">초기화</button>
                    </div>
                    <div class="btn_box">
                        <button type="submit" class="btn_black">검색</button>
                    </div>
                </div>

                </form>

                <!-- 테이블 -->
                <div class="tbl_box data mt40">
                    <table>
                        <caption>회원가입 테이블</caption>
                        <colgroup>
                            <col width="">
                            <col width="">
                            <col width="">
                            <col width="">
                            <col width="">
                            <col width="">
                            <col width="">
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col">작성자</th>
                                <th scope="col">블로그 번호</th>
                                <th scope="col">포스트 번호</th>
                                <th scope="col">카테고리명</th>
                                <th scope="col">제목</th>
                                <th scope="col">조회수</th>
                                <th scope="col">공감수</th>
                                <th scope="col">댓글수</th>
                                <th scope="col">등록일자</th>
                                <th scope="col">수정일자</th>
                                <th scope="col">공개여부</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for(PostVo vo : postVoList){ %>
                            <tr>
                                <td><%= vo.getUserNick() %></td>
                                <td><%= vo.getBlogNo() %></td>
                                <td><%= vo.getPostNo() %></td>
                                <td><%= vo.getCategoryNo() %></td>
                                <td><%= vo.getTitle() %></td>
                                <td><%= vo.getInquiry() %></td>
                                <td><%= vo.getHeartCnt() %></td>
                                <td><%= vo.getReplyCnt() %></td>
                                <td><%= vo.getEnrollDate() %></td>
                                <td><%= vo.getModifyDate() %></td>
                                <td><%= vo.getOpen() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>

                <div class="paging_box mt30">
                    <ul>
                        <li class="prev_all"><a href="/jdgr/admin/post/list" title="최신페이지로 이동"></a></li>
                        <li class="prev"><a href="/jdgr/admin/post/list" title="이전페이지로 이동"></a></li>
                        <li class="on"><a href="/jdgr/admin/post/list">1</a></li>
                        <li><a href="/jdgr/admin/post/list">2</a></li>
                        <li><a href="/jdgr/admin/post/list">3</a></li>
                        <li><a href="/jdgr/admin/post/list">4</a></li>
                        <li><a href="/jdgr/admin/post/list">5</a></li>
                        <li class="next"><a href="/jdgr/admin/post/list" title="다음페이지로 이동"></a></li>
                        <li class="next_all"><a href="/jdgr/admin/post/list" title="마지막페이지로 이동"></a></li>
                    </ul>
                </div>

            </div>
            <!-- //container -->
<%@include file = "/WEB-INF/views/admin/common/footer.jsp" %>

<script>
	

</script>
            
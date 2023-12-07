<%@page import="com.semi.jdgr.admin.blame.vo.AdminReplyBlameVo"%>
<%@page import="java.util.Map"%>
<%@page import="com.semi.jdgr.page.vo.AdminBlamePageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	List<AdminReplyBlameVo> blameVoList = (List<AdminReplyBlameVo>) request.getAttribute("blameVoList");
    	AdminBlamePageVo pvo = (AdminBlamePageVo)request.getAttribute("pvo");
    	Map<String, String> searchMap = (Map<String, String>)request.getAttribute("searchMap");
    %>
    
    <%@ include file="/WEB-INF/views/admin/common/header.jsp" %>
 
     <!-- container -->
            <div class="container">
                <!-- 제목 -->
                <div class="tit_box">
                    <h2>신고 목록 조회</h2>
                </div>
                
                <!-- 검색박스 예시 -->
                <div class="search_box">
                    <div class="search_item">
                        <label for="sel_01">신고자</label>
                        <div class="form_box">
                            <input type="text" id="inp_02">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">작성자</label>
                        <div class="form_box">
                            <input type="text" id="inp_02">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">댓글 내용</label>
                        <div class="form_box">
                            <input type="text" id="inp_02">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">신고 일자</label>
                        <div class="form_box">
                            <input type="text" id="inp_02">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">신고 구분</label>
                        <div class="form_box">
                            <select class="sel_box">
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                            </select>
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">제재 여부</label>
                        <div class="form_box">
                            <select class="sel_box">
                                <option value="">어떻게 구현하지</option>
                                <option value="">로그인 3일 정지</option>
                                <option value="">로그인 7일 정지</option>
                            </select>
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">답변 일자</label>
                        <div class="form_box">
                                <input type="text" id="inp_02">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">처리 일자</label>
                        <div class="form_box">
                                <input type="text" id="inp_02">
                        </div>
                    </div>
                </div>
                
                <!-- 버튼 -->
                <div class="btn_box_group right">
                    <div class="btn_box">
                        <button class="btn_gray">답변 일자</button>
                    </div>
                    <div class="btn_box">
                        <button class="btn_black">검색</button>
                    </div>
                </div>

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
                            <col width="">
                            <col width="">
                            <col width="">
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col">번호</th>
                                <th scope="col">신고자</th>
                                <th scope="col">작성자</th>
                                <th scope="col">댓글 내용</th>
                                <th scope="col">신고 일자</th>
                                <th scope="col">신고 구분</th>
                                <th scope="col">제재 여부</th>
                                <th scope="col">답변 일자</th>
                                <th scope="col">처리 일자</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for(AdminReplyBlameVo vo : blameVoList){ %>
                            <tr>
                                <td><%= vo.getrBlaNo() %></td>
                                <td><%= vo.getrBlamerNo() %></td>
                                <td><%= vo.getrWriterNo() %></td>
                                <td><%= vo.getrBlaCon() %></td>
                                <td><%= vo.getrBlaDate() %></td>
                                <td><%= vo.getrBlaList() %></td>
                                <td><%= vo.getrSancYn() %></td>
                                <td><%= vo.getrAnsDate() %></td>
                                <td><%= vo.getrDelYn() %></td>
                            </tr>
                        <%} %>
                            
                        </tbody>
                    </table>
                    
                </div>

                <div class="paging_box mt30">
                    <ul>
                        <%if(pvo.getStartPage() != 1) {%>
                        <li class="prev_all"><a href="/jdgr/admin/blame/r_blame_list/list?pno=1" title="최신페이지로 이동"></a></li>
                        <li class="prev"><a href="/jdgr/admin/blame/r_blame_list/list?pno=<%=pvo.getStartPage()-1 %>" title="이전페이지로 이동"></a></li>

<%} %>

<%for(int i = pvo.getStartPage(); i<=pvo.getEndPage(); i++) {%>
	<%if(i == pvo.getCurrentPage()) {%>
						<li class="on"><a href="/jdgr/admin/blame/r_blame_list/list?pno=<%=i%>"><%=i %></a></li>
	<%}else{ %>
						<li><a href="/jdgr/admin/blame/r_blame_list/list?pno=<%=i%>"><%=i %></a></li>
<%} } %>
<%if(pvo.getEndPage() != pvo.getMaxPage()) {%>
                        <li class="next"><a href="/jdgr/admin/blame/r_blame_list/list?pno=<%=pvo.getEndPage()+1 %>" title="다음페이지로 이동"></a></li>
                        <li class="next_all"><a href="/jdgr/admin/blame/r_blame_list/list?pno=<%=pvo.getMaxPage() %>" title="마지막페이지로 이동"></a></li>
<%} %>
                    </ul>
                </div>

            </div>
            <!-- //container -->
    <%@ include file="/WEB-INF/views/admin/common/footer.jsp" %>
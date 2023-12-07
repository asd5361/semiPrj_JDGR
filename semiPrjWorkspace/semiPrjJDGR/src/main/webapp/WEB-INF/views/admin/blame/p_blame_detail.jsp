<%@page import="com.semi.jdgr.admin.blame.vo.AdminPostBlameVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       

       
       <%
       		AdminPostBlameVo vo = (AdminPostBlameVo)request.getAttribute("vo");
    		String currPage = (String)request.getAttribute("currPage");
    		if(currPage == null){
    			currPage = "1";
    		}
    	%>
<%@ include file="/WEB-INF/views/admin/common/header.jsp" %>
       
<!-- container -->
        <div class="container">

            <!-- 내용 -->
            

            <!-- 제목 -->
            <div class="tit_box">
                <h2>신고 / 제재 상세 조회</h2>
            </div>

            <!-- 가로 테이블 -->
            <div class="detail_box">
                <!-- 테이블 -->
                <div class="tbl_group">
            
                    <div class="tbl_box">
                        <table>
                            <caption>신고 / 제재</caption>
                            <colgroup>
                                <col width="15%"/>
                                <col width="35%"/>
                                <col width="15%"/>
                                <col width="35%"/>
                            </colgroup>
                            <tbody>
                            	<tr>
                                    <th scope="row"><label for="">신고번호</label></th>
                                    <td><%= (vo != null) ? vo.getpBlaNo() : "" %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">포스트 번호</label></th>
                                    <td><%= vo.getpNo() %></td>
                                    <th scope="row"><label for="">신고 구분</label></th>
                                    <td><%= vo.getpBlaList() %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">신고자</label></th>
                                    <td><%= vo.getpBlamerNo() %></td>
                                    <th scope="row"><label for="">작성자</label></th>
                                    <td><%= vo.getpWriterNo() %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">포스트 제목</label></th>
                                    <td><%= vo.getpBlaTit() %></td>
                                    <th scope="row"><label for="">신고 일자</label></th>
                                    <td><%= vo.getpBlaDate() %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">제재 여부</label></th>
                                    <td>
                                        <div class="form_box">
                                            <select class="sel_box">
                                                <option value="">이건 어떻게 가져오지</option>
                                                <option value="">로그인 정지 3일</option>
                                                <option value="">로그인 정지 7일</option>
                                            </select>
                                        </div>
                                    </td>
                                    <th scope="row"><label for="">답변 일자</label></th>
                                    <td><%= vo.getpAnsDate() %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">처리일자</label></th>
                                    <td><%= vo.getpDelYn() %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="inp_03">세부 신고 사유</label></th>
                                    <td colspan="3"><%= vo.getpBlaDetail() %></td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="inp_03">답변 내용</label></th>
                                    <td colspan="3">
                                         <div class="form_box">
                                            <textarea placeholder="<%= vo.getpAnsDate()%>"></textarea>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                </div>

                <div class="btn_box_group right mt20">
                    <div class="btn_box">
                        <a href="/jdgr/admin/blame/p_blame_list" class="btn_grayline">목록가기</a>
                    </div>
                    <div class="btn_box">
                        <a href="" class="btn_grayline">저장</a>
                    </div>
                    <div class="btn_box">
                        <a href="" class="btn_blue">처리완료</a>
                    </div>
                </div>

            </div>
        </div>
        <!-- //container -->

   <%@ include file="/WEB-INF/views/admin/common/footer.jsp" %>
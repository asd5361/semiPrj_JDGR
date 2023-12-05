<%@page import="com.semi.jdgr.post.vo.PostVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/admin/common/header.jsp" %>

<%
PostVo adminPostDetailVo = (PostVo) request.getAttribute("adminPostDetailVo");
PostVo heartCnt = (PostVo) request.getAttribute("heartCnt");
PostVo replyCnt = (PostVo) request.getAttribute("replyCnt");
%>

        <!-- container -->
        <div class="container">

            <!-- 내용 -->
            

            <!-- 제목 -->
            <div class="tit_box">
                <h2>포스팅 상세 관리</h2>
            </div>

            <!-- 가로 테이블 -->
            <div class="detail_box">
                <!-- 테이블 -->
                <div class="tbl_group">
            
                    <div class="tbl_box">
                    <form action="/jdgr/admin/post/detail"  method="POST">
                        <table>
                            <caption>회원목록 상세 테이블</caption>
                            <colgroup>
                                <col width="15%"/>
                                <col width="35%"/>
                                <col width="15%"/>
                                <col width="35%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th rowspan="4" scope="row"><label for="">포스트 대표 이미지</label></th>
                                    <td rowspan="4" scope="row"><img src= <%= adminPostDetailVo.getPostImg() %> alt="이미지없음"></td>
                                </tr>
                                <tr>
                                    <th><label for="">블로그 번호</label></th>
                                    <td><%= adminPostDetailVo.getBlogNo() %></td>
                                </tr> 
                                <tr>
                                    <th scope="row"><label for="">회원ID</label></th>
                                    <td><%= adminPostDetailVo.getUserId() %></td>
                                   
                                </tr>
                                <tr>

                                    <th scope="row"><label for="">공개여부</label></th>
                                    <td>
                                        <div class="form_box">
                                            <select class="sel_box" id="open">
                                                <option value="N">N</option>
                                                <option value="Y">Y</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">조회수</label></th>
                                    <td><%= adminPostDetailVo.getInquiry() %></td>
                                    <th scope="row"><label for="">삭제여부</label></th>
                                    <td>
                                        <div class="form_box">
                                            <select class="sel_box">
                                                <option value="">N</option>
                                                <option value="">Y</option>
                                            </select>
                                        </div>
                                    </td>

                                </tr>
                                <tr>
                                    <th scope="row"><label for="">수정일자</label></th>
                                    <td><%= adminPostDetailVo.getModifyDate() %></td>
                                    <th scope="row"><label for="">공감수</label></th>
                                    <td>
                                        <%=heartCnt.getPostNo() %>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">등록일자</label></th>
                                    <td><%= adminPostDetailVo.getEnrollDate() %></td>
                                    <th scope="row"><label for="">댓글수</label></th>
                                    <td><%= replyCnt.getPostNo() %></td>
                                </tr>
                                <tr>
                                    <th colspan="1" scope="row"><label for="" name="">제목</label></th>
                                    <td colspan="3">
                                        <%= adminPostDetailVo.getPostTitle() %>
                                    </td>                                    
                                </tr>
                                <tr>
                                    <th colspan="1" scope="row"><label for="" name="">내용</label></th>
                                    <td colspan="3">
                                        <%= adminPostDetailVo.getContent() %>
                                    </td>                                    
                                </tr>
                            </tbody>
                        </table>
                        </form>
                    </div>
                    
                </div>

                <div class="btn_box_group right mt20">
                    <div class="btn_box">
                        <a href="" class="btn_grayline">목록보기</a>
                    </div>
                    <div class="btn_box">
                        <a href="" class="btn_blue">수정하기</a>
                    </div>
                </div>

            </div>
        </div>
        <!-- //container -->

<%@include file = "/WEB-INF/views/admin/common/footer.jsp" %>


<script>

    const openArr = document.querySelectorAll("#open option");
    const openType = "<%= adminPostDetailVo.getOpen() %>";
    for(let i = 0; i < openArr.length; ++i){
        if( openArr[i].value === openType ) {
            openArr[i].selected = true;
            console.log(aa);
            break;
        };
    };

</script>

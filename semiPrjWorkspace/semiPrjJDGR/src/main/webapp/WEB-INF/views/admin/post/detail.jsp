<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/admin/common/header.jsp" %>

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
                                    <td rowspan="4" scope="row"><img src="" alt=""></td>
                                </tr>
                                <tr>
                                    <th><label for="">블로그 번호</label></th>
                                    <td>01</td>
                                </tr> 
                                <tr>
                                    <th scope="row"><label for="">회원ID</label></th>
                                    <td>id</td>
                                   
                                </tr>
                                <tr>

                                    <th scope="row"><label for="">공개여부</label></th>
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
                                    <th scope="row"><label for="">조회수</label></th>
                                    <td>50</td>
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
                                    <td>2023.11.26 00:00</td>
                                    <th scope="row"><label for="">공감수</label></th>
                                    <td>
                                        공감수
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row"><label for="">등록일자</label></th>
                                    <td>2023.11.26 00:00</td>
                                    <th scope="row"><label for="">댓글수</label></th>
                                    <td>20</td>
                                </tr>
                                <tr>
                                    <th colspan="1" scope="row"><label for="" name="">제목</label></th>
                                    <td colspan="3">
                                        하기시로
                                    </td>                                    
                                </tr>
                                <tr>
                                    <th colspan="1" scope="row"><label for="" name="">내용</label></th>
                                    <td colspan="3">
                                        아아악아각ㄱㄱㄱ
                                    </td>                                    
                                </tr>
                            </tbody>
                        </table>
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
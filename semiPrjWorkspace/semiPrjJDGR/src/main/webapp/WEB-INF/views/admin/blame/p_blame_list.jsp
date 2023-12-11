<%@page import="com.semi.jdgr.admin.blame.vo.AdminPostBlameVo"%>
<%@page import="java.util.Map"%>
<%@page import="com.semi.jdgr.page.vo.AdminBlamePageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	List<AdminPostBlameVo> blameVoList = (List<AdminPostBlameVo>) request.getAttribute("blameVoList");
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
                            <input type="text" id="blamer" name="blamer" value="<%= (searchMap != null) ? searchMap.get("blamer") : "" %>">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">작성자</label>
                        <div class="form_box">
                            <input type="text" id="writer" name="writer" value="<%= (searchMap != null) ? searchMap.get("writer") : "" %>">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">포스트 제목</label>
                        <div class="form_box">
                            <input type="text" id="content"  name="content" value="<%= (searchMap != null) ? searchMap.get("content") : "" %>">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">신고 일자</label>
                        <div class="form_box">
                            <input type="text" id="blameDate"   name="blameDate" value="<%= (searchMap != null) ? searchMap.get("blameDate") : "" %>">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">신고 구분</label>
                        <div class="form_box">
                            <select class="sel_box">
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                                <option value="">4</option>
                                <option value="">5</option>
                                <option value="">6</option>
                                <option value="">7</option>
                            </select>
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">제재 여부</label>
                        <div class="form_box">
                            <select class="sel_box">
                                <option value="">어떻게 구현하지X</option>
                                <option value="">로그인 3일 정지</option>
                                <option value="">로그인 7일 정지</option>
                            </select>
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">답변 일자</label>
                        <div class="form_box">
                                <input type="text" id="answerDate"   name="answerDate" value="<%= (searchMap != null) ? searchMap.get("answerDate") : "" %>">
                        </div>
                    </div>
                    <div class="search_item">
                        <label for="sel_01">처리 일자</label>
                        <div class="form_box">
                                <input type="text" id="delDate"   name="delDate" value="<%= (searchMap != null) ? searchMap.get("delDate") : "" %>">
                        </div>
                    </div>
                </div>
                
                <!-- 버튼 -->
                <div class="btn_box_group right">
                    <div class="btn_box">
                        <button class="btn_gray" onclick="resetSearch()">초기화</button>
                    </div>
                    <div class="btn_box">
                        <button class="btn_black" onclick="search()">검색</button>
                    </div>
                </div>

				<script>
				    function resetSearch() {
				        // 초기화 로직 추가
				        document.getElementById('blamer').value = '';
				        document.getElementById('writer').value = '';
				        document.getElementById('content').value = '';
				        document.getElementById('blameDate').value = '';
				        document.getElementById('answerDate').value = '';
				        document.getElementById('delDate').value = '';
				        // 나머지 검색 조건에 대한 초기화 로직 추가
				        // ...
				    }
				
				    function search() {
				        // 검색 조건을 가져오기
				        var blamer = document.getElementById('inp_02_blamer').value;
				        var writer = document.getElementById('inp_02_writer').value;
				        var content = document.getElementById('inp_02_content').value;
				        var blameDate = document.getElementById('inp_02_blameDate').value;
				        var answerDate = document.getElementById('inp_02_answerDate').value;
				        var delDate = document.getElementById('inp_02_delDate').value;
// 				        var writer = document.getElementById('inp_02_writer').value;
				        // (다른 검색 조건들도 필요에 따라 추가)

				        // 검색 조건을 객체로 만들기
				        var searchParams = {
				            blamer: blamer,
// 				            writer: writer
				            // (다른 검색 조건들도 필요에 따라 추가)
				        };

				        // 서버로 전송할 URL 설정 (서버의 실제 URL에 맞게 수정해야 함)
				        var url = '/jdgr/admin/blame/p_blame_list/search';

				        // Ajax 요청
				        var xhr = new XMLHttpRequest();
				        xhr.open('POST', url, true);
				        xhr.setRequestHeader('Content-Type', 'application/json');

				        xhr.onload = function () {
				            if (xhr.status === 200) {
				                // 응답을 JSON으로 파싱
				                var response = JSON.parse(xhr.responseText);

				                // 테이블을 채우는 함수 호출
				                populateTable(response);
				            } else {
				                console.error('서버 에러:', xhr.status);
				            }
				        };

				        var requestBody = JSON.stringify(searchParams);
				        xhr.send(requestBody);
				    }

				    // 서버 응답을 기반으로 테이블을 채우는 함수
				    function populateTable(data) {
				        var table = document.getElementById('blameTable');
				        var tbody = document.createElement('tbody');

				        // 데이터를 반복하여 행을 추가
				        for (var i = 0; i < data.length; i++) {
				            var vo = data[i];
				            var row = document.createElement('tr');

				            // 각 열 데이터를 채워넣기
				            var columns = [
				                vo.rBlaNo,
				                vo.rBlamerNo,
				                vo.rWriterNo,
				                vo.rBlaCon,
				                vo.rBlaDate,
				                vo.rBlaList,
				                vo.rSancYn,
				                vo.rAnsDate,
				                vo.rDelYn
				            ];

				            for (var j = 0; j < columns.length; j++) {
				                var cell = document.createElement('td');
				                cell.textContent = columns[j];
				                row.appendChild(cell);
				            }

				            tbody.appendChild(row);
				        }

				        // 테이블의 기존 tbody 삭제 후 새로운 tbody 추가
				        table.removeChild(table.getElementsByTagName('tbody')[0]);
				        table.appendChild(tbody);
				    }


				</script>

                <!-- 테이블 -->
                <div class="tbl_box data mt40">
                    <table>
  
                        <thead>
                            <tr>
                                <th scope="col">번호</th>
                                <th scope="col">신고자</th>
                                <th scope="col">작성자</th>
                                <th scope="col">포스트 제목</th>
                                <th scope="col">신고 일자</th>
                                <th scope="col">신고 구분</th>
                                <th scope="col">제재 여부</th>
                                <th scope="col">답변 일자</th>
                                <th scope="col">처리 일자</th>
                            </tr>
                        </thead>
                        <tbody>
                       
                        <% for(AdminPostBlameVo vo : blameVoList){ %>
                            <tr>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpBlaNo() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpBlamerNo() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpWriterNo() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpBlaTit() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpBlaDate() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpBlaList() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpSancYn() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpAnsDate() %></td>
                                <td><a href="/jdgr/admin/blame/p_blame_detail?no=<%= vo.getpBlaNo() %>"><%= vo.getpDelYn() %></td>
                            </tr>
                        <%} %>
                            
                        </tbody>
                    </table>
                    
                </div>

                <div class="paging_box mt30">
                    <ul>
                        <%if(pvo.getStartPage() != 1) {%>
                        <li class="prev_all"><a href="/jdgr/admin/blame/p_blame_list/list?pno=1" title="최신페이지로 이동"></a></li>
                        <li class="prev"><a href="/jdgr/admin/blame/p_blame_list/list?pno=<%=pvo.getStartPage()-1 %>" title="이전페이지로 이동">이전</a></li>

						<%} %>
						
						<%for(int i = pvo.getStartPage(); i<=pvo.getEndPage(); i++) {%>
							<%if(i == pvo.getCurrentPage()) {%>
								<li class="on"><a href="/jdgr/admin/blame/p_blame_list/list?pno=<%=i%>"><%=i %></a></li>
							<%}else{ %>
								<li><a href="/jdgr/admin/blame/p_blame_list/list?pno=<%=i%>"><%=i %></a></li>
						<%} %>
							<% } %>
						<%if(pvo.getEndPage() != pvo.getMaxPage()) {%>
	                        <li class="next"><a href="/jdgr/admin/blame/p_blame_list/list?pno=<%=pvo.getEndPage()+1 %>" title="다음페이지로 이동">다음</a></li>
	                        <li class="next_all"><a href="/jdgr/admin/blame/p_blame_list/list?pno=<%=pvo.getMaxPage() %>" title="마지막페이지로 이동"></a></li>
						<%} %>			
                    </ul>
                </div>

            </div>
            <!-- //container -->
    <%@ include file="/WEB-INF/views/admin/common/footer.jsp" %>
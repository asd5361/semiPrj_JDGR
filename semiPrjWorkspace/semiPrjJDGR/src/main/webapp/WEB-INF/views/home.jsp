<%@page import="com.semi.jdgr.page.vo.PageVo"%>
<%@page import="com.semi.jdgr.post.vo.PostVo"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.jdgr.user.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
       List<PostVo> postVoList = (List<PostVo>)request.getAttribute("postVoList");
       PageVo pvo = (PageVo)request.getAttribute("pvo");
   
//        Map<String, String> searchMap = (Map<String,String>)request.getAttribute("searchMap");
    
    %>

<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <!-- 인기블로그 글 BEST10 -->
        <div class="best10_box">
            <h3 class="tit">인기블로그 글 BEST10</h3>

            <!-- swiper -->
            <div class="best10_content">
                <div class="swiper-container">
                    <ul class="swiper-wrapper">
                        <li class="swiper-slide">
                            <a href="">
                                <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="이미지"></div>
                                <div class="txt">
                                    <div class="info">
                                        <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></span>
                                        <strong>작성자 닉네임</strong>
                                    </div>
                                    <div class="content">
                                        <strong>키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라</strong>
                                        <span>국제전자센터를 가다 키덜트들의 성지 방문 드디어 엄청나게 가보고싶었던 국제전자센터를 가보았다 키덜트들의 성지라 불리는 어쩌구저쩌구 내용들...</span>
                                    </div>
                                    <div class="util">
                                        <span class="date">2023-11-12</span>
                                        <span class="like">2319</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="swiper-slide">
                            <a href="">
                                <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="이미지"></div>
                                <div class="txt">
                                    <div class="info">
                                        <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></span>
                                        <strong>작성자 닉네임</strong>
                                    </div>
                                    <div class="content">
                                        <strong>키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라</strong>
                                        <span>국제전자센터를 가다 키덜트들의 성지 방문 드디어 엄청나게 가보고싶었던 국제전자센터를 가보았다 키덜트들의 성지라 불리는 어쩌구저쩌구 내용들...</span>
                                    </div>
                                    <div class="util">
                                        <span class="date">2023-11-12</span>
                                        <span class="like">2319</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="swiper-slide">
                            <a href="">
                                <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="이미지"></div>
                                <div class="txt">
                                    <div class="info">
                                        <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></span>
                                        <strong>작성자 닉네임</strong>
                                    </div>
                                    <div class="content">
                                        <strong>키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라</strong>
                                        <span>국제전자센터를 가다 키덜트들의 성지 방문 드디어 엄청나게 가보고싶었던 국제전자센터를 가보았다 키덜트들의 성지라 불리는 어쩌구저쩌구 내용들...</span>
                                    </div>
                                    <div class="util">
                                        <span class="date">2023-11-12</span>
                                        <span class="like">2319</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="swiper-slide">
                            <a href="">
                                <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="이미지"></div>
                                <div class="txt">
                                    <div class="info">
                                        <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></span>
                                        <strong>작성자 닉네임</strong>
                                    </div>
                                    <div class="content">
                                        <strong>키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라</strong>
                                        <span>국제전자센터를 가다 키덜트들의 성지 방문 드디어 엄청나게 가보고싶었던 국제전자센터를 가보았다 키덜트들의 성지라 불리는 어쩌구저쩌구 내용들...</span>
                                    </div>
                                    <div class="util">
                                        <span class="date">2023-11-12</span>
                                        <span class="like">2319</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="swiper-slide">
                            <a href="">
                                <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="이미지"></div>
                                <div class="txt">
                                    <div class="info">
                                        <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></span>
                                        <strong>작성자 닉네임</strong>
                                    </div>
                                    <div class="content">
                                        <strong>키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라</strong>
                                        <span>국제전자센터를 가다 키덜트들의 성지 방문 드디어 엄청나게 가보고싶었던 국제전자센터를 가보았다 키덜트들의 성지라 불리는 어쩌구저쩌구 내용들...</span>
                                    </div>
                                    <div class="util">
                                        <span class="date">2023-11-12</span>
                                        <span class="like">2319</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="swiper-slide">
                            <a href="">
                                <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="이미지"></div>
                                <div class="txt">
                                    <div class="info">
                                        <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></span>
                                        <strong>작성자 닉네임</strong>
                                    </div>
                                    <div class="content">
                                        <strong>키덜트들의 성지, 국제 전자센터 방문하고싶은 사람들의 마음이 블라블라블라</strong>
                                        <span>국제전자센터를 가다 키덜트들의 성지 방문 드디어 엄청나게 가보고싶었던 국제전자센터를 가보았다 키덜트들의 성지라 불리는 어쩌구저쩌구 내용들...</span>
                                    </div>
                                    <div class="util">
                                        <span class="date">2023-11-12</span>
                                        <span class="like">2319</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
                <button class="swiper_btn ico_prev"></button>
                <button class="swiper_btn ico_next"></button>
            </div>

        </div>

        <!-- main 컨텐츠 -->
        <div class="main_layout">
            <!-- left -->
            <div class="main_left">
                <!-- 구독한 블로그 포스트 (없으면 안나와야함) -->
                <h3>구독블로그 새글</h3>
				
				<% if(loginMemberVo == null){ %>
					<!-- 포스트가 없을시/로그아웃상태 일시 -->
	                <div class="post_none">
	                    로그아웃 상태입니다.<br/>
	                    로그인하여 구독 블로그의 새 글을 확인해보세요.
	                </div>
				<% } else { %>
					<!-- 포스트가 없을시/로그아웃상태 일시 -->
	                <div class="post_none">
	                    구독된 블로그가 없습니다.<br/>
	                    다양한 관심사의 블로그를 구독해보세요.
	                </div>
				<% } %>
                

                <!-- 카테고리 버튼 -->
                <ul class="tab_btns">
                    <li class="on"><button>전체</button></li>
                    <li><button>미술·디자인</button></li>
                    <li><button>반려동물</button></li>
                    <li><button>사진</button></li>
                    <li><button>어학·외국어</button></li>
                    <li><button>게임</button></li>
                    <li><button>자동차</button></li>
                    <li><button>맛집</button></li>
                </ul>

                <!-- 카테고리별 블로그 포스트 -->
                <div class="postbox">
                        <div class="postImg"><%= vo.getPostImg() %></div>
                        <div class="postWrite"> 
                            <div class="postWriteNick">
                                <div class="postNickimg"><img src="../images/ico/ico_people.svg"></div>
                                <div class="postNickname"><%= vo.getUserNick() %></div>
                            </div>    
                            <div class="postWriteLink"><%= vo.getContent() %></div>
                            <div class="postWrite12">
                                <div class="postWrite1"><img src="../images/ico/ico_like.svg"><%= vo.getheartCnt() %></div>
                                <div class="postWrite2"><img src="../images/ico/ico_reply.svg"><%= vo.getreplyCnt() %></div>
                            </div>         
                        </div>
                    </div>
                    
      
                <!-- 페이징 -->
                <div class="paging_box">
                    <ul>
                    <%if(pvo.getCurrentPage() != 1) {%>
                        <li class="prev_all"><a href="/jdgr/home?pno=1" title="최신페이지로 이동"></a></li>
                        <li class="prev"><a href="/jdgr/home?pno=<%=pvo.getStartPage()-1 %>" title="이전페이지로 이동"></a></li>
                        <%} %>
                        
                        <%for(int i = pvo.getStartPage(); i<= pvo.getEndPage(); i++) {%>
                        	<%if(i == pvo.getCurrentPage()) {%>   
                        	<li class="on"><a href="/jdgr/home?pno=<%= i%>"><%= i%></a></li>
                        	<%}else{ %>  
                        	<li><a href="/jdgr/home?pno=<%= i%>"><%= i%></a></li>
                        <%} }%>
                        <li class="next"><a href="/jdgr/home?pno=<%=pvo.getCurrentPage()+1 %>" title="다음페이지로 이동"></a></li>
                        <li class="next_all"><a href="/jdgr/home?pno=<%=pvo.getMaxPage() %>" title="마지막페이지로 이동"></a></li>
                    </ul>
                </div>
            </div>

            <!-- right -->
            <div class="main_right">
                <!-- 로그인창 or 유저정보 -->
                <div class="user_content">

					<% if(loginMemberVo == null){ %>
						<!-- 로그인 전 -->
	                    <div class="before_login">
	                        <span>로그인 후 이용하실 수 있습니다.</span>
	                        <a href="/jdgr/member/login" class="login">로그인</a>
	                        <a href="/jdgr/member/join" class="join">회원가입</a>
	                    </div>
					<% } else { %>
						<!-- 로그인 후 -->
	                    <div class="after_login">
	
	                        <div class="user_info">
	                            <div class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt="유저이미지"></div>
	                            <div class="txt">
	                                <strong><%= loginMemberVo.getMemNick() %></strong>
	                                <span>오늘 <em><%= loginMemberBlogVo.getVisitCnt() %></em>명 방문</span>
	                            </div>
	                            <a href="/jdgr/member/logout" class="btn_logout">로그아웃</a>
	                        </div>
	
							<!-- 유저가 가지고있는 블로그가 있으면  -->
							<% if(loginMemberBlogVoList != null){ %>
								<div class="btn_util">
		                            <a href="/jdgr/blog/view/<%= loginMemberBlogVo.getBlogUrl() %>" class="my_blog">내 블로그</a>
		                            <a href="/jdgr/blog/write?url=<%= loginMemberBlogVo.getBlogUrl() %>" class="my_write">글쓰기</a>
		                        </div>
							<% } else { %>
							<!-- 유저가 가지고있는 블로그가 없으면  -->
								<div class="btn_util">
		                            <a href="/jdgr/userSet/newblog" class="my_blog">블로그 만들기</a>
		                        </div>
							<% } %>
	
	                        <div class="tab_group">
	                            <ul class="tab_btns">
	                                <li class="on"><button rel="tab_content_01">내소식</button></li>
	                                <li><button rel="tab_content_02">구독 목록</button></li>
	                                <li><button rel="tab_content_03">블로그 목록</button></li>
	                            </ul>
	                            <div class="tab_content">
	                                <div class="tab_content_01 on">
	
	                                    <div class="pop_alarm_box">
	                                        <ul>
	                                        
	                                        	<% for(AlarmVo alarmVo : alarmVoList){ %>
	                                            	<% if(alarmVo.getPostNo() != null) {%>
	                                            <li>
	                                            	<% if(alarmVo.getAlarmType().contains("댓글")) {%>
	                                                	<span class="ico_reply" ></span>
	                                            	<%} else if(alarmVo.getAlarmType().contains("공감")){%>
	                                            		<span class="ico_like" ></span>
	                                            	<%}else if(alarmVo.getAlarmType().contains("포스팅")){%>
	                                            		<span style ="background-image: url(/jdgr/resources/user/images/ico/ico_write_b.svg) "></span>
	                                            	<%}%>
	                                                <div class="txt" onclick="goPost()">
	                                                    <strong><%=alarmVo.getUserNick() %></strong>
	                                                   	님이 "<%=alarmVo.getPostTitle() %>" <%=alarmVo.getAlarmType() %>
	                                                </div>
	                                            
	                                                <a href="" class="delete">삭제</a>
	                                            </li>
	                                            	<%} else{%>
	                                            <li>
	                                                <span class="ico_subscribe"></span>
	                                            	
	                                                <div class="txt" onclick="goBlog()">
	                                                    <strong><%=alarmVo.getUserNick() %></strong>
	                                                    님이 <%=alarmVo.getAlarmType() %>
	                                                </div>
	                                            	
	                                                <a href="" class="delete">삭제</a>
	                                            </li>
	                                            	<%}%>
	                                            	
	                                            <%} %>
	                                        </ul>
	                                    </div>
	
	                                </div>
	                                <div class="tab_content_02">
	
	                                    <div class="subscription_list">
	                                        <div class="search_box">
	                                            <input type="text">
	                                            <button>검색</button>
	                                        </div>
	                                        <ul>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <a href="">
	                                                    <span class="img"><img src="/jdgr/resources/user/images/content/img_main01.png" alt=""></span>
	                                                    <strong>구독한닉네임</strong>
	                                                </a>
	                                            </li>
	                                        </ul>
	                                        <div class="btn_area">
	                                            <button class="prev"></button>
	                                            <button class="next"></button>
	                                        </div>
	                                    </div>   
	                                    
	                                </div>
	                                <div class="tab_content_03">
	                                    
	                                    <div class="user_blog">
	                                        <div class="tit_box">
	                                            <strong>운영중인 블로그</strong>
	                                            <a href="" class="ico_add">추가하기</a>
	                                        </div>
	                                        <ul>
	                                        	<% if(loginMemberBlogVoList != null){ %>
	                                        		<% for(BlogVo blogVo : loginMemberBlogVoList){ %>
	                                        			<li>
			                                                <a href="/jdgr/blog/view/<%= blogVo.getBlogUrl() %>" class="tit"><%= blogVo.getBlogTitle() %></a>
			                                                <a href="/jdgr/blog/write" class="ico_write"></a>
			                                                <a href="/jdgr/userSet/blog" class="ico_set">관리</a>
			                                            </li>
	                                        		<% } %>
	                                        	<% } %>
	                                        </ul>
	                                    </div>
	
	                                </div>
	                            </div>
	                        </div>
	
	                    </div>
					<% } %>

                </div>
            </div>
        </div>

    </div>
</main>
<!-- //main -->

<%@ include file="/WEB-INF/views/user/common/footer.jsp" %>

<script>
const swiper = new Swiper('.swiper-container', {
    direction: 'horizontal', // 수평 슬라이드
    slidesPerView: 4,
    spaceBetween: 30,
    loop: true, // 무한 루프
    navigation: {
        nextEl: '.ico_next',
        prevEl: '.ico_prev',
    },
});
function goPost() {
}
function goBlog() {
}
</script>
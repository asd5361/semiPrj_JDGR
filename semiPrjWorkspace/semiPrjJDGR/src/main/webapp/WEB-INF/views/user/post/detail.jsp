<%@page import="com.semi.jdgr.post.vo.PostVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	PostVo postDetailVo = (PostVo) request.getAttribute("postDetailVo");
    %>

    <div class="container01">
        <div class="header01">
            <div><%= postDetailVo.getCategoryName() %></div>
            
            <div><h1><%= postDetailVo.getTitle() %></h1></div>

            <div class="head01">
                <div class="left01">
                    <span><img class="user" src=<%= postDetailVo.getPostImg() %> alt="유저프로필사진"></span>
                    <span class="nick"><%= postDetailVo.getUserNick() %></span>
                    <span><%= postDetailVo.getEnrollDate() %></span>
                </div> 
                
                <div class="right01">
                    <div class="set">
                        <div class="reply_pop">
                            <a href=""></a>
                            <div class="pop_content">
                                <a href="" class="edit">수정하기</a>
                                <a href="" class="delete">삭제하기</a>
                            </div>
                        </div>
                    </div>
                    <!-- <button class="btn_option"><img class="img01" src="../images/ico/ico_option.svg"><span></span></button> -->
                </div>
            </div>
            <br>
        </div>
        
            <div class="text01"><%= postDetailVo.getContent() %></div>
        
            <div class="footer01">
                <div class="foot01">
                    <div class="left02">
                        <button id="like_btn" class="btn_k un_like" onclick="{clickEvent('like')}">공감<%= postDetailVo.getHeartCnt() %></button>
                        <button id="rep_btn" class="btn_k un_rep"  onclick="{clickEvent('rep')}">댓글<%= postDetailVo.getReplyCnt() %></button>
                    </div>
                    <div class="right02">
                        <button id="plus_btn" class="btn_k un_plus" onclick="{clickEvent('plus')}">구독하기</button>
                        <button class="btn_k" onclick="location=window.open('xxx.jsp', 'blamePage')"><img src="../images/ico/ico_declaration.svg" alt="신고">신고하기</button>
                    </div>    
                </div>
            </div>
    </div>

<script>
    let likeClick = true;
    let plusClick = true;
    let repClick = true;

    // function likeClickEvent() {
    //     const likeBtn = document.getElementById('like_btn');
    //     likeClick ? likeBtn.className = "btn_k like" : likeBtn.className = "btn_k un_like";
    //     likeClick = !likeClick;
    // }


    // function plusClickEvent() {
    //     const plusBtn = document.getElementById('plus_btn');

    //     if(plusClick){
    //         plusBtn.className = "btn_k plus";
    //     } else {c
    //         plusBtn.className = "btn_k";
    //     }
    //     plusClick = !plusClick;
    // }

    function clickEvent(mode) {
        switch (mode) {
            case 'like' :
                const likeBtn = document.getElementById('like_btn');
                likeClick ? likeBtn.className = "btn_k like" : likeBtn.className = "btn_k un_like";
                likeClick = !likeClick;
            break;
            case 'plus' :
                const plusBtn = document.getElementById('plus_btn');
                plusClick ? plusBtn.className = "btn_k plus" : plusBtn.className = "btn_k un_plus";
                plusClick = !plusClick;
            break;
            case 'rep' :
                const repBtn = document.getElementById('rep_btn');
                repClick ? repBtn.className = "btn_k rep" : repBtn.className = "btn_k un_rep";
                repClick = !repClick;
            break;
        }
        
    }
</script>



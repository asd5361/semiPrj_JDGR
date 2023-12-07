<%@page import="com.semi.jdgr.blog.vo.GroupVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/user/common/header.jsp" %>
<% 
	// 블로그 관리정보 vo
	List<GroupVo> blogUserGroupData = (List<GroupVo>) request.getAttribute("blogUserGroupData");
%>
<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <%@ include file="/WEB-INF/views/user/blogSet/side.jsp" %>

            <div class="right">
                <h2>카테고리 설정</h2>

                <div class="content">

                    <div class="category_box">

                        <form action="/jdgr/blogSet/category" method="post">
                            <div class="category_left">
                                <div class="btn_area">
                                    <div class="left">
                                        <button type="button" onclick="categoryAdd();">카테고리 추가</button>
                                        <button type="button" onclick="lineAdd();">라인 추가</button>
                                    </div>
                                    <div class="right">
                                        <button type="button" onclick="selectDelete();">선택삭제</button>
                                    </div>
                                </div>
                                <ul>
                                	<% for(int i = 1; i <= blogUserGroupData.size(); i++){ %>
                                	<li class="category">
                                        <input type="radio" id="category<%= i %>" name="userCategoryNum" value="<%= blogUserGroupData.get(i - 1).getNo() %>" >
                                        <input type="hidden" name="userCategoryValue" value="<%= blogUserGroupData.get(i - 1).getName() %>">
                                        <label for="category<%= i %>"><%= blogUserGroupData.get(i - 1).getName() %></label>
                                    </li>
                                	<% } %>
                                </ul>
                            </div>

                            <div class="category_right">
                                <dl>
                                    <dt>카테고리 명</dt>
                                    <dd><input type="text" name="groupName" name="editName"></dd>
                                </dl>
                                <div class="btn_area">
                                    <button>저장하기</button>
                                </div>
                                <input type="hidden" name="blogUrl" value="${blogUserData.blogUrl}">
                            </div>
                        </form>

                    </div>

                </div>

            </div>

        </div>

    </div>
</main>
<!-- //main -->
<script>

    function handleCategoryChange(e) {
        const categoryHiddenInput = e.target.closest('li').querySelector('input[name=userCategoryValue]');
    
        const categoryInp = document.querySelector('input[name=groupName]');
        categoryInp.value = categoryHiddenInput.value;
        categoryInp.focus();

        if(categoryInp.value == 'line'){
            categoryInp.disabled = true;
        } else {
            categoryInp.disabled = false;
        }
        
    }

    const categoryUl = document.querySelector('.category_box .category_left ul');

    
    // 이벤트 위임을 통해 부모 요소에 이벤트 리스너 추가
    categoryUl.addEventListener('change', function (e) {
        const targetInput = e.target.closest('input[name=userCategoryNum]');
        if (targetInput) {
            handleCategoryChange(e);
        }
    });

    function categoryAdd(){
    	const categoryLastLi = document.querySelector('.category_left ul li:last-child input[type=radio]');
        let nextValue = Number(categoryLastLi.value);
        nextValue++;

        const categoryLi = document.createElement('li');
        categoryLi.className = 'category';

        categoryLi.innerHTML = `
            <input type="radio" id="category` + nextValue + `" name="userCategoryNum" value="` + nextValue + `">
            <input type="hidden" name="userCategoryValue" value="카테고리">
            <label for="category` + nextValue + `">카테고리</label>
        `;
        categoryUl.appendChild(categoryLi);
    }

    function lineAdd(){
        const categoryLastLi = document.querySelector('.category_left ul li:last-child input[type=radio]');
        let nextValue = Number(categoryLastLi.value);
        nextValue++;

        const categoryLi = document.createElement('li');
        categoryLi.className = 'line';

        categoryLi.innerHTML = `
            <input type="radio" id="line` + nextValue + `" name="userCategoryNum" value="` + nextValue + `">
            <input type="hidden" name="userCategoryValue" value="line">
            <label for="line` + nextValue + `"></label>
        `;
        categoryUl.appendChild(categoryLi)
    }

    function selectDelete(){
        let selectCategoryInp = null;
        selectCategory = document.querySelectorAll('input[name=userCategoryNum]');
        for (const el of selectCategory) {
            if(el.checked){
                selectCategoryInp = el;
            }
        }
        console.log(selectCategoryInp.parentNode);
        selectCategoryInp.parentNode.remove();
    }
</script>
<%@ include file="/WEB-INF/views/user/common/footer.jsp" %>
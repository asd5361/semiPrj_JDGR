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
                                        <input type="radio" id="category<%= i %>" name="userCategoryNum" value="<%= blogUserGroupData.get(i - 1).getOrder() %>" >
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

        const userCategoryNum = categoryLi.querySelector('input[name=userCategoryNum]').value;
        const userCategoryValue = categoryLi.querySelector('input[name=userCategoryValue]').value;
        //const editCategoryName = document.querySelector('input[name=groupName]').value;
        const userUrl = document.querySelector('input[name=blogUrl]').value;

        addAjax(userCategoryNum, userCategoryValue, userUrl);
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

    function addAjax(userCategoryNum, userCategoryValue, userUrl){
		const dataToSend = {
            groupOrder: userCategoryNum,
			groupName: userCategoryValue,
			userUrl: userUrl
        }
		// 서버한테 요청보내기
        console.log(userCategoryNum);
        console.log(userCategoryValue);
        console.log(userUrl);
        console.log(JSON.stringify(dataToSend));
		fetch("/jdgr/blogSet/categoryAdd", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json', // JSON 데이터를 전송할 것이므로 Content-Type을 지정
            },
            body: JSON.stringify(dataToSend) // JSON 형태로 데이터 변환
        })
		.then( (resp) => { return resp.json() } ) // 데이터 가공
		.then( (x) => { // 가공된 데이터로 할수있는거 하기
			console.log(x);
			
		} );
		
	}
    // // 보낼 데이터를 정의
    // const dataToSend = {
    //     key1: 'value1',
    //     key2: 'value2'
    // };

    // // 서버 URL
    // const url = 'https://example.com/api';

    // // fetch를 사용하여 POST 요청 보내기
    // fetch(url, {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json', // 전송하는 데이터의 형식을 지정 (JSON인 경우)
    //         // 다른 필요한 헤더들도 추가 가능
    //     },
    //     body: JSON.stringify(dataToSend) // JSON 형태로 데이터 변환
    // })
    // .then(response => response.json()) // 서버로부터 응답 받기
    // .then(data => {
    //     console.log('서버로부터 받은 데이터:', data);
    //     // 데이터를 이용한 로직 추가
    // })
    // .catch(error => {
    //     console.error('오류 발생:', error);
    //     // 오류 처리 로직 추가
    // });
</script>
<%@ include file="/WEB-INF/views/user/common/footer.jsp" %>
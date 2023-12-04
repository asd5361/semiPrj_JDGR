<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <%@ include file="/WEB-INF/views/user/blogSet/side.jsp" %>

            <div class="right">
                <h2>카테고리 설정</h2>

                <div class="content">

                    <div class="category_box">

                        <form action="">
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
                                    <li class="category">
                                        <input type="radio" id="category1" name="userCategory" value="1번카테고리" >
                                        <label for="category1">유저가 추가한 카테고리</label>
                                    </li>
                                    <li class="category">
                                        <input type="radio" id="category2" name="userCategory" value="2번카테고리" checked>
                                        <label for="category2">유저가 추가한 카테고리</label>
                                    </li>
                                    <li class="line">
                                        <input type="radio" id="line1" name="userCategory" value="line" value="3번라인">
                                        <label for="line1"></label>
                                    </li>
                                    <li class="category">
                                        <input type="radio" id="category3" name="userCategory" value="4번카테고리">
                                        <label for="category3">유저가 추가한 카테고리</label>
                                    </li>
                                    <li class="category">
                                        <input type="radio" id="category4" name="userCategory" value="5번카테고리">
                                        <label for="category4">유저가 추가한 카테고리</label>
                                    </li>
                                </ul>
                            </div>

                            <div class="category_right">
                                <dl>
                                    <dt>카테고리 명</dt>
                                    <dd><input type="text" name="groupName"></dd>
                                </dl>
                                <div class="btn_area">
                                    <button>저장하기</button>
                                </div>
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
    
    let selectCategory = document.querySelectorAll('input[name=userCategory]');
    selectCategory.forEach(category => {
        category.addEventListener('change', (e) => {
            const categoryInp = document.querySelector('input[name=groupName]');
            categoryInp.value = e.target.value;
            categoryInp.focus();
        })
    });

    const categoryUl = document.querySelector('.category_box .category_left ul');

    function categoryAdd(){

        const categoryLi = document.createElement('li');
        categoryLi.className = 'category';

        categoryLi.innerHTML = `
            <input type="radio" id="category6" name="userCategory" value="6번카테고리">
            <label for="category6">유저가 추가한 카테고리</label>
        `;
        categoryUl.appendChild(categoryLi)
    }

    function lineAdd(){

        const categoryLi = document.createElement('li');
        categoryLi.className = 'line';

        categoryLi.innerHTML = `
            <li class="line">
                <input type="radio" id="line1" name="userCategory" value="line" value="3번라인">
                <label for="line1"></label>
            </li>
        `;
        categoryUl.appendChild(categoryLi)
    }

    function selectDelete(){
        let selectCategoryInp = null;
        selectCategory = document.querySelectorAll('input[name=userCategory]');
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/user/common/header.jsp" %>

<!-- main -->
<main>
    <div class="inner">

        <div class="blog_set_layout">

            <div class="left">
                <dl>
                    <dt>블로그 관리</dt>
                    <dd>
                        <ul>
                            <li><a href="">블로그 정보</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl>
                    <dt>계정 관리</dt>
                    <dd>
                        <ul>
                            <li><a href="">개인정보 수정</a></li>
                        </ul>
                    </dd>
                </dl>
            </div>

            <div class="right">
                <h2>새 블로그 만들기</h2>

                <div class="content">
					<form action="/jdgr/blog/create" method="post" enctype="multipart/form-data">
	                    <div class="data_dl">
	                        <dl>
	                            <dt>블로그명</dt>
	                            <dd>
	                                <div class="inp_box">
	                                    <input type="text" name="blogTitle">
	                                    <span>한글, 영문, 숫자 혼용가능 (한글기준 25자 이내)</span>
	                                </div>
	                            </dd>
	                        </dl>
	                        <dl>
	                            <dt>블로그 주소</dt>
	                            <dd>
	                                <div class="inp_box">
	                                    <span>http://jdgr/blog/</span>
	                                    <input type="text" name="blogUrl">
	                                    <span>최소 4자 ~ 최대 32자의 영문 소문자, 숫자로 입력</span>
	                                </div>
	                            </dd>
	                        </dl>
	                        <dl>
	                            <dt>블로그 프로필 이미지</dt>
	                            <dd>
	                                <div class="profile_box">
	                                    <div class="img"><img src="../images/ico/ico_profile.svg" alt=""></div>
	                                    <div class="profile_btn">
	                                        <input type="file" id="blogImg" name="blogImg" accept="image/*">
	                                        <label for="blogImg">등록</label>
	                                        <span class="txt">프로필 이미지는 가로 200px, 세로 200px로 생성됩니다.</span>
	                                    </div>
	                                </div>
	                            </dd>
	                        </dl>
	                    </div>
	
	                    <div class="blog_set_btn">
	                        <button>개설하기</button>
	                    </div>
	                </form>
					
                </div>

            </div>

        </div>

    </div>
</main>
<!-- //main -->
<script>
    const blogImgInp = document.querySelector('.blog_set_layout .right .data_dl dl dd .profile_box .profile_btn input');
    const blogImgDiv = document.querySelector('.blog_set_layout .right .data_dl dl dd .profile_box .img');

    blogImgInp.addEventListener('change', function () {
        // 파일이 선택되었는지 확인
        if (blogImgInp.files.length > 0) {
            const file = blogImgInp.files[0];

            // FileReader 객체를 사용하여 파일 읽기
            const reader = new FileReader();
            reader.onload = function (e) {
                // 이미지를 보여주는 div에 이미지 추가
                const imgElement = document.createElement('img');
                imgElement.src = e.target.result;
                blogImgDiv.innerHTML = ''; // 이전에 추가된 이미지 삭제
                blogImgDiv.appendChild(imgElement);
            };

            // 파일을 읽기
            reader.readAsDataURL(file);
        }
    });
</script>
<%@ include file="/WEB-INF/views/user/common/footer.jsp" %>
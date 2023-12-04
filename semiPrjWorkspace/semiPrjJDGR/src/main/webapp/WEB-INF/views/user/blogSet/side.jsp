<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String blogSideClassName = (String) request.getAttribute("blogSideClassName");
	if(blogSideClassName == null){
		blogSideClassName = "";
	}
%>

<div class="left">
    <dl>
        <dt>기본정보 관리</dt>
        <dd>
            <ul>
                <li class="<%= "blogInfo".equals(blogSideClassName) ? "on" : "" %>"><a href="/jdgr/blogSet/blogInfo">블로그 정보</a></li>
            </ul>
        </dd>
    </dl>
    <dl>
        <dt>구독 관리</dt>
        <dd>
            <ul>
                <li class="<%= "subscribe".equals(blogSideClassName) ? "on" : "" %>"><a href="/jdgr/blogSet/subscribe">구독한 블로그</a></li>
            </ul>
        </dd>
    </dl>
    <dl>
        <dt>꾸미기 설정</dt>
        <dd>
            <ul>
                <li class="<%= "category".equals(blogSideClassName) ? "on" : "" %>"><a href="/jdgr/blogSet/category">카테고리 설정</a></li>
                <li class="<%= "skin".equals(blogSideClassName) ? "on" : "" %>"><a href="/jdgr/blogSet/skin">스킨 선택</a></li>
                <li class="<%= "layout".equals(blogSideClassName) ? "on" : "" %>"><a href="/jdgr/blogSet/layout">레이아웃-위젯 설정</a></li>
            </ul>
        </dd>
    </dl>
</div>
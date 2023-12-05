package com.semi.jdgr.user.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/blogSet/blogInfo")
public class BlogInfoEditController extends HttpServlet {
	
	// 블로그 정보 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("blogClassName", "blog_set");
		req.setAttribute("blogSideClassName", "blogInfo");
		req.getRequestDispatcher("/WEB-INF/views/user/blogSet/blogInfo.jsp").forward(req, resp);
	}
	
	// 블로그 정보 수정 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}

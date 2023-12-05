package com.semi.jdgr.user.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/blogSet/category")
public class BlogCategoryEditController extends HttpServlet {
	
	// 카테고리 설정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("blogClassName", "blog_set");
		req.setAttribute("blogSideClassName", "category");
		req.getRequestDispatcher("/WEB-INF/views/user/blogSet/category.jsp").forward(req, resp);
	}
	
	// 카테고리 설정 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}

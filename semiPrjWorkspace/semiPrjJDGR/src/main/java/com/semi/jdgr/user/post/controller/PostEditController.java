package com.semi.jdgr.user.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.post.service.PostServiceHJY;
import com.semi.jdgr.post.vo.PostVo;

@WebServlet("/post/edit")
public class PostEditController extends HttpServlet {
	
	// 포스트 수정하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// data
			BlogVo blogVo = (BlogVo) req.getSession().getAttribute("blogUrlVo");
			
			// service
			PostServiceHJY ps = new PostServiceHJY();
			//PostVo postVo = ps.postEdit(); 상세보기 완성후 시작해야됨 1208
			
			// reuslt
			req.getRequestDispatcher("/WEB-INF/views/user/post/edit.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 포스트 수정하기 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

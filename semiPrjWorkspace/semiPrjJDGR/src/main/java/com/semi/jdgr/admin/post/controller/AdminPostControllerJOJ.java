package com.semi.jdgr.admin.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.post.service.PostServiceJOJ;
import com.semi.jdgr.post.vo.PostVo;

@WebServlet("/admin/post/detail")
public class AdminPostControllerJOJ extends HttpServlet{
	
	// 관리자 포스트 상세관리 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			// data
			String no = req.getParameter("no");
			
			// service
			PostServiceJOJ ps = new PostServiceJOJ();
			PostVo adminPostDetailVo = ps.AdminPostDetail(no);
			
			// result
			System.out.println(adminPostDetailVo);
			req.setAttribute("adminPostDetailVo", adminPostDetailVo);
			req.getRequestDispatcher("/WEB-INF/views/admin/post/detail.jsp").forward(req, resp);
			
		}catch (Exception e) {
			System.out.println("관리자 포스팅 관리 에러발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "관리자 포스팅 관리 실패");
			req.getRequestDispatcher("/WEB-INF/views/admin/common/error.jsp").forward(req, resp);
		}
				
	}
	
	// 관리자 포스트 상세관리 (로직)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// data
		
		// service
		
		// result
		
	}

}

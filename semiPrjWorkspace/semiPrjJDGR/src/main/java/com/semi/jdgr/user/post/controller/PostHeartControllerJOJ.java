package com.semi.jdgr.user.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.post.service.PostServiceJOJ;
import com.semi.jdgr.user.member.vo.MemberVo;

//@WebServlet("/post/detail")
public class PostHeartControllerJOJ extends HttpServlet{
	
	// 공감기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/user/post/detail.jsp").forward(req, resp);
		
		try {
			// data
			String no = req.getParameter("no");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				throw new Exception("로그인 먼저 진행하세요.");
			}
			String memberNo = loginMember.getMemNo();
			
			// service
			PostServiceJOJ ps = new PostServiceJOJ();
			int result = ps.AddHeart(no, memberNo);
			
			// result
			if(result != 1) {
				throw new Exception("공감 실행 중 에러발생");
			}
			
		}catch (Exception e) {
			
		}
		
		
	}// doGet

}// class

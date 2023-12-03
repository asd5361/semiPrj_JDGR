package com.semi.jdgr.user.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.user.member.vo.MemberVo;

// 나중에 지울 controller
@WebServlet("/blog/view")
public class BlogViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 로그인 유저정보
			MemberVo memberVo = (MemberVo) req.getSession().getAttribute("loginMember");
			
			// service
			BlogService bs = new BlogService();
			BlogVo blogVo = bs.getUserReqblog(memberVo); // 대표블로그 
			
			// result
			if(blogVo == null) {
				throw new Exception("blogVo가 null");
			}
			
			if(memberVo == null) {
				throw new Exception("memberVo가 null");
			}
			
			if(!memberVo.getMemNo().equals(blogVo.getMemNo())) {
				throw new Exception("로그인한 멤버 no가 blogVo의 멤버 no와 같지않음");
			}
			
			String redirectUrl = "/jdgr/blog/view/" + blogVo.getBlogUrl();
			resp.sendRedirect(redirectUrl);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "이 블로그는 없는 블로그입니다.");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}
		
		
	}
}

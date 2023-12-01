package com.semi.jdgr.user.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/blog/view/*")
public class BlogViewUrlController extends HttpServlet {
	
	// 로그인 유저가 설정한 url
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			System.out.println("확인1");
			// 로그인 유저정보 받아서 블로그 SELECT * FROM WHERE 대표블로그Y되어있는걸 받아오고 URL테이블 조인해서 URL가져오기
			//HttpSession session = req.getSession();
			//MemberVo memberVo = (MemberVo) session.getAttribute("loginMember");
			MemberVo memberVo = new MemberVo();
			memberVo.setMemNo("3");

			System.out.println("확인2");
			// service
			BlogService bs = new BlogService();
			BlogVo blogVo = bs.getUserblog(memberVo);

			System.out.println("확인3");
			// result
			if(blogVo == null) {
				throw new Exception("blogVo가 null");
			}

			req.setAttribute("blogVo", blogVo);
			req.setAttribute("blogClassName", "blog");
			System.out.println("확인4");
			req.getRequestDispatcher("/WEB-INF/views/user/blog/blogMain.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "이 블로그는 없는 블로그입니다.");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}
		
	}
}

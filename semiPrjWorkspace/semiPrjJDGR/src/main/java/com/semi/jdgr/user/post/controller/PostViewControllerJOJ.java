package com.semi.jdgr.user.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.post.service.PostServiceJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/post/view")
public class PostViewControllerJOJ extends HttpServlet {

	// 포스트 VO 준비 (포스트 넘버로 조회)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// data (포스트 넘버)
			String pNo = req.getParameter("pNo");

			System.out.println(pNo);

			// service
			PostServiceJOJ ps = new PostServiceJOJ();
			
			PostVo postInfoVo = ps.PostInfo(pNo); // 포스트 VO로 받아온 값으로 detail 쿼리문 실행

			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMember");

			// result
			System.out.println("PostViewControllerJOJ실행");
			System.out.println(postInfoVo);
			System.out.println(postInfoVo.getBlogUrl());
			System.out.println(postInfoVo.getGroupNo());
			System.out.println(postInfoVo.getPostNo());
//			HttpSession session = req.getSession();
//			session.setAttribute("postInfo", postInfo);

			req.getRequestDispatcher("/post/detail?url=" + postInfoVo.getBlogUrl() + "&&GroupNo=" + postInfoVo.getGroupNo()).forward(req, resp);

		} catch (Exception e) {
			System.out.println("포스트 상세보기 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "포스트 상세보기 실패");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}

	}// PostDetail
	
}// class

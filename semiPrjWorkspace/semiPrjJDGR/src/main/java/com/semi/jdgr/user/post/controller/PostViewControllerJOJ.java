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

	// 포스트 상세보기 화면 (포스트 넘버로 조회)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// data (포스트 넘버)
			String pNo = req.getParameter("postNo");

			System.out.println(pNo);

			// service
			PostServiceJOJ ps = new PostServiceJOJ();
//			PostVo postVo = ps.PostNoVo(postNo); // 포스트 VO 가져오기 (BLOG_URL , GROUP_NO , POST_NO)
			PostVo postListDetailVo = ps.PostListDetail(pNo); // 포스트 VO로 받아온 값으로 detail 쿼리문 실행
			PostVo postListDetailHeartCnt = ps.PostListDetailHeartCnt(pNo); // 포스트 VO안에 POST_NO 으로 공감수 가져오기
			PostVo postListDetailReplyCnt = ps.PostListDetailReplyCnt(pNo); // 포스트 VO안에 POST_NO 으로 댓글수 가져오기

			// service
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMember");

			// result
			System.out.println(postListDetailVo.getBlogUrl());
			System.out.println(postListDetailVo.getGroupNo());
			System.out.println(postListDetailVo.getPostNo());
			System.out.println(postListDetailHeartCnt.getPostNo());
			System.out.println(postListDetailReplyCnt.getPostNo());
			HttpSession session = req.getSession();
			session.setAttribute("postListDetailVo", postListDetailVo);

			req.setAttribute("postListDetailHeartCnt", postListDetailHeartCnt);
			req.setAttribute("postListDetailReplyCnt", postListDetailReplyCnt);
//			req.getRequestDispatcher("/WEB-INF/views/user/post/detail.jsp").forward(req, resp);
			req.getRequestDispatcher("/WEB-INF/views/user/blog/blogView.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println("포스트 상세보기 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "포스트 상세보기 실패");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}

	}// PostDetail
	
	// 포스트 상세보기 (로직)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// data

		// service

		// result

	}
}

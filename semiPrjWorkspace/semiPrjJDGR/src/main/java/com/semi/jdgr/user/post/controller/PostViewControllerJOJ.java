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

	// 포스트 목록에서 상세보기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// data (포스트 넘버)
			String no = req.getParameter("no");
			// data (블로그 URL)
			String BlogUrl = req.getParameter("url");


			// service
			PostServiceJOJ ps = new PostServiceJOJ();
			PostVo PostListDetailVo = ps.PostListDetail(no, BlogUrl);
			PostVo heartCnt = ps.heartListCnt(no);
			PostVo replyCnt = ps.ReplyListCnt(no);

			// service
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMember");


			// result
			System.out.println(PostListDetailVo);
			System.out.println(heartCnt.getPostNo());
			System.out.println(replyCnt.getPostNo());
			HttpSession session = req.getSession();
			session.setAttribute("PostListDetailVo", PostListDetailVo);
//			session.setAttribute("heartCnt", heartCnt);
//			session.setAttribute("replyCnt", replyCnt);

			req.setAttribute("blogClassName", "blog");

//			req.setAttribute("postDetailVo", postDetailVo);
			req.setAttribute("heartCnt", heartCnt);
			req.setAttribute("replyCnt", replyCnt);
			req.getRequestDispatcher("/WEB-INF/views/user/post/detail.jsp").forward(req, resp);
//			req.getRequestDispatcher("/WEB-INF/views/user/blog/blogView.jsp").forward(req, resp);

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

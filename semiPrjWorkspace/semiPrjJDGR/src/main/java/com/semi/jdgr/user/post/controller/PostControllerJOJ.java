package com.semi.jdgr.user.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.blog.vo.GroupVo;
import com.semi.jdgr.post.service.PostServiceJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/post/detail")
public class PostControllerJOJ extends HttpServlet{
	
	// 포스트 상세보기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		// url정보
		String BlogUrl = req.getParameter("url");
		// data (카테고리 넘버)
		String categoryNo = req.getParameter("categoryNo"); 
		// data (포스트 넘버)
//		String no = req.getParameter("no");
		
		System.out.println(BlogUrl);
		System.out.println(categoryNo);
		
		
		// service
		PostServiceJOJ ps = new PostServiceJOJ();
		PostVo postNoVo = ps.PostNo();
		PostVo postDetailVo = ps.PostDetail(categoryNo, BlogUrl);
		PostVo heartCnt = ps.heartCnt(postNoVo);
		PostVo replyCnt = ps.ReplyCnt(postNoVo);
//		System.out.println(postDetailVo);
		
		// service
		MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMember");
		
		BlogService bs = new BlogService();
		BlogVo blogUrlVo = bs.getUserblog(BlogUrl); // url에 맞는 블로그 가져오기
//		List<GroupVo> groupVoList = bs.getGroupList(blogUrlVo); // 카테고리그룹 가져오기
		
		
		// result
//		System.out.println(postDetailVo);
		System.out.println(heartCnt.getPostNo());
		System.out.println(replyCnt.getPostNo());
		HttpSession session = req.getSession();
		session.setAttribute("postDetailVo", postDetailVo);
//		session.setAttribute("heartCnt", heartCnt);
//		session.setAttribute("replyCnt", replyCnt);
		
		req.setAttribute("blogClassName", "blog");
//		req.setAttribute("groupVoList", groupVoList);
		req.getSession().setAttribute("blogUrlVo", blogUrlVo); // url 블로그 저장
		
//		req.setAttribute("postDetailVo", postDetailVo);
		req.setAttribute("heartCnt", heartCnt);
		req.setAttribute("replyCnt", replyCnt);
//		req.getRequestDispatcher("/WEB-INF/views/user/post/detail.jsp").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/views/user/blog/blogView.jsp").forward(req, resp);
		
		}catch(Exception e) {
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

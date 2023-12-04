package com.semi.jdgr.user.set.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/userSet/blog")
public class UserSetBlogController extends HttpServlet {
	
	// 대표블로그 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("blogClassName", "blog_set");
		req.getRequestDispatcher("/WEB-INF/views/user/userSet/userSetBlog.jsp").forward(req, resp);

	}
	
	// 대표블로그 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// data
			String blogUrl = req.getParameter("blog");
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMember");
			
			BlogVo blogVo = new BlogVo();
			blogVo.setBlogUrl(blogUrl);
			blogVo.setMemNo(loginMemberVo.getMemNo());
			
			System.out.println("라디오value에서 가져온 블로그 url : " + blogUrl);
			System.out.println("로그인유저 멤버번호 : " + loginMemberVo.getMemNo());
			
			// service
			BlogService bs = new BlogService();
			int result = bs.editBlogRep(blogVo);
			
			// result
			if(result < 1) {
				throw new Exception("수정결과가 0이면 오류");
			}
			
			// 세션에 업데이트 
			List<BlogVo> loginMemberBlogVoList = (List<BlogVo>) req.getSession().getAttribute("loginMemberBlogVoList");
			for(BlogVo vo : loginMemberBlogVoList) {
				if(vo.getBlogUrl().equals(blogUrl)) {
					vo.setRepYn("Y");
				} else {
					vo.setRepYn("N");
				}
			}
			
			req.setAttribute("blogClassName", "blog_set");
			req.getRequestDispatcher("/WEB-INF/views/user/userSet/userSetBlog.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

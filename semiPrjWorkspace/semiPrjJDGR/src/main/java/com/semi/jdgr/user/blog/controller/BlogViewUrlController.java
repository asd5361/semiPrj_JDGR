package com.semi.jdgr.user.blog.controller;

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
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/blog/view/*")
public class BlogViewUrlController extends HttpServlet {
	
	// 로그인 유저가 설정한 url
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// url정보 
			String pathInfo = req.getPathInfo();
			String getBlogUrl = pathInfo.substring(1);

			// service
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMember");
			
			BlogService bs = new BlogService();
			BlogVo blogUrlVo = bs.getUserblog(getBlogUrl); // url에 맞는 블로그 가져오기
			List<GroupVo> groupVoList = bs.getGroupList(blogUrlVo); // 카테고리그룹 가져오기
			
			// result

			req.setAttribute("blogClassName", "blog");
			req.setAttribute("groupVoList", groupVoList);
			req.getSession().setAttribute("blogUrlVo", blogUrlVo); // url 블로그 저장
			
			req.getRequestDispatcher("/WEB-INF/views/user/blog/blogMain.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "이 블로그는 없는 블로그입니다.");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}
		
	}
}

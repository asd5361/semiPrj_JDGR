package com.semi.jdgr.user.main;

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
import com.semi.jdgr.post.service.PostServiceLYJ;
import com.semi.jdgr.post.vo.CategoryVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/home")
public class HomeController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 로그인 세션 가져오기
			HttpSession session = req.getSession();
			MemberVo memberVo = (MemberVo) session.getAttribute("loginMember");

			PostServiceLYJ ps = new PostServiceLYJ();
			List<CategoryVo> categoryVoList = ps.selectCategory();
			
			if(categoryVoList == null) {
				throw new Exception();
				
			}
			 req.setAttribute("categoryVoList", categoryVoList);
			
			// 블로그 정보,리스트 세션에 저장하기
			BlogService bs = new BlogService();
			BlogVo blogVo = null;
			List<BlogVo> blogVoList = null;
			if(memberVo != null) {
				blogVo = bs.getUserReqblog(memberVo); // 대표 블로그 정보 가져오기
				blogVoList = bs.getBlogList(memberVo); // 블로그 리스트 가져오기
			}
			System.out.println(categoryVoList);
			session.setAttribute("loginMemberBlogVo", blogVo);
			session.setAttribute("loginMemberBlogVoList", blogVoList);
			
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

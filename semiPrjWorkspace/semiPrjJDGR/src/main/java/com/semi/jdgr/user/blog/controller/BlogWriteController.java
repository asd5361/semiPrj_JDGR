package com.semi.jdgr.user.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.blog.vo.GroupVo;
import com.semi.jdgr.post.vo.CategoryVo;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/blog/write")
public class BlogWriteController extends HttpServlet {
	
	// 블로그 글쓰기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			MemberVo memberVo = (MemberVo) req.getSession().getAttribute("loginMember");
			if(memberVo == null) {
				throw new Exception("로그인이 필요한 서비스입니다.");
			}
			
			// data
			BlogVo blogVo = (BlogVo) req.getSession().getAttribute("blogUrlVo");
			
			// service
			BlogService bs = new BlogService();
			List<GroupVo> groupVoList = bs.getGroupList(blogVo); // 그룹 카테고리 가져오기
			List<CategoryVo> categoryVoList = bs.getCategoryList(); // 포스트 카테고리 가져오기
			
			// result
			
			req.setAttribute("groupVoList", groupVoList);
			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/blog/write.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			// 팝업메세지 전달
			
			// 에러 메시지 가져오기
		    String errorMessage = e.getMessage();
		    
			Map<String, String> popText = new HashMap<String, String>();
			popText.put("warningId", "display: flex;");
			popText.put("warningTitle", errorMessage);
			popText.put("warningContent", "다시 확인해주세요!");
			req.getSession().setAttribute("popText", popText);
			
			resp.sendRedirect("/jdgr/home");
		}
	}
	
	// 블로그 글쓰기 기능
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			// data
			String categoryNo = req.getParameter("categoryNo");
			String groupNo = req.getParameter("groupNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			PostVo postVo = new PostVo();
			postVo.setCategoryNo(categoryNo);
			postVo.setGroupNo(groupNo);
			postVo.setTitle(title);
			postVo.setContent(content);
			
			System.out.println(categoryNo);
			System.out.println(groupNo);
			System.out.println(title);
			System.out.println(content);
			
			// service
			BlogService bs = new BlogService();
			//int result = bs.postWrite(postVo);
			
			// result
//			if(result != 1) {
//				throw new Exception("result가 1이아님");
//			}
			//req.getSession().setAttribute("errorMsg", "게시글이 작성완료되었습니다.");
//			resp.sendRedirect("/jdgr/blog/list");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

package com.semi.jdgr.admin.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.post.service.PostServiceLYJ;
import com.semi.jdgr.post.vo.PostVo;

@WebServlet("/admin/post/list")
public class AdminPostControllerLYJ extends HttpServlet{
	
	PostServiceLYJ ps = new PostServiceLYJ();		
	
	//맨 처음에 보이는 전체 리스트 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PostVo postVo = new PostVo();
		try {
			
			//service
			List<PostVo> postVoList = ps.allSelectPostList(postVo);
			
			//result(==view)
			req.setAttribute("postVoList", postVoList);
//			req.setAttribute("pvo" , pvo);
//			resp.sendRedirect("/jdgr/admin/post/list");
			
			req.getRequestDispatcher("/WEB-INF/views/admin/post/list.jsp").forward(req, resp);	
			
		} catch (Exception e) {
			
			System.out.println("[ERROR-B001]포스트 관리 목록 조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "포스트 관리 목록 조회 에러");
			req.getRequestDispatcher("/WEB-INF/views/admin/common/error.jsp").forward(req, resp);
		}	
	}
	
	//관리자 포스트 목록 관리(조회하기)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//data
//			int listCount = ps.selectPostCount(null);		//전체 게시글 갯수
//			String currentPage_ = req.getParameter("pno");
//			if(currentPage_ == null) {
//				currentPage_ = "1";
//			}
//			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
//			int pageLimit = 5;
//			int boardLimit = 10;
//			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			String memNick = req.getParameter("memNick");
			//service
			List<PostVo> postVoList = ps.selectPostList(memNick);
			
			//result(==view)
			req.setAttribute("postVoList", postVoList);
//			req.setAttribute("pvo" , pvo);
			 req.getRequestDispatcher("/WEB-INF/views/admin/post/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-B001]포스트 관리 목록 조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "포스트 관리 목록 조회 에러");
			req.getRequestDispatcher("/WEB-INF/views/admin/common/error.jsp").forward(req, resp);
		}
			
	}
			
}//class

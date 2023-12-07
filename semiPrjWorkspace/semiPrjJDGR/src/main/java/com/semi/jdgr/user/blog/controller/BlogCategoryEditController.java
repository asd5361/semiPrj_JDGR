package com.semi.jdgr.user.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.blog.service.BlogService;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.blog.vo.GroupVo;

@WebServlet("/blogSet/category")
public class BlogCategoryEditController extends HttpServlet {
	
	// 카테고리 설정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// data
			String userUrl = req.getParameter("url");
			
			// service
			BlogService bs = new BlogService();
			List<GroupVo> groupVoList = bs.getEditGroupList(userUrl);
			
			// result
			BlogVo blogVo = new BlogVo();
			blogVo.setBlogUrl(userUrl);

			req.setAttribute("blogUserGroupData", groupVoList);
			req.setAttribute("blogUserData", blogVo);
			req.setAttribute("blogClassName", "blog_set");
			req.setAttribute("blogSideClassName", "category");
			req.getRequestDispatcher("/WEB-INF/views/user/blogSet/category.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/user/blogSet/category.jsp").forward(req, resp);
		}
		
		
	}
	
	// 카테고리 설정 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			String groupOrder = req.getParameter("userCategoryNum");
			String groupName = req.getParameter("userCategoryValue");
			String editName = req.getParameter("editName");
			String userUrl = req.getParameter("url"); // 하는중
			
			// service
			BlogService bs = new BlogService();
			//GroupVo groupVo = bs.editGroup();
			
			// result
			
			req.setAttribute("blogClassName", "blog_set");
			req.setAttribute("blogSideClassName", "category");
			req.getRequestDispatcher("/WEB-INF/views/user/blogSet/category.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/user/blogSet/category.jsp").forward(req, resp);
		}
		
	}
	
}

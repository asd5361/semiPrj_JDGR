package com.semi.jdgr.user.post.category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.jdgr.post.service.PostServiceLYJ;
import com.semi.jdgr.post.vo.PostVo;

@WebServlet("/post/category")
public class PostCategoryController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//ajax는 get으로 보낸다.
			String categoryNo = req.getParameter("categoryNo");
			//포스트리스트 불러오기
			PostServiceLYJ ps = new PostServiceLYJ();
			List<PostVo> postVoList = ps.separatedList(categoryNo);
			
			if(postVoList ==null) {
				throw new Exception("카테고리 분류에서오류");
			}
			
			Gson gson = new Gson();
			String str = gson.toJson(postVoList);
			
			PrintWriter out = resp.getWriter();
			out.write(str);
			
		} catch (Exception e) {
		}
	}

}

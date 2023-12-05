package com.semi.jdgr.admin.blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.admin.blame.service.AdminBlameService;
import com.semi.jdgr.admin.blame.vo.AdminBlameVo;

@WebServlet("/admin/blame/blame_detail")
public class AdminBlameDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			String no = req.getParameter("no");
			
			//service
			AdminBlameService abs = new AdminBlameService();
			AdminBlameVo vo = abs.selectBlameByNo(no);
			
			//result(==view)
			req.setAttribute("vo", vo);
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.getRequestDispatcher("/WEB-INF/views/admin/blame/blame_detail.jsp").forward(req, resp);

		}catch(Exception e) {
			System.out.println("신고 상세조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "신고 목록 상세조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
	
	}//doGet
	
	
}//class

package com.semi.jdgr.admin.blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/blame/r_blame_update")
public class AdminReplyBlameUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//data
		String pno = req.getParameter("pno");
		String currPage = req.getParameter("currPage");
		String sancYn = req.getParameter("sancYn");
		
		System.out.println(pno);
		System.out.println(currPage);
		System.out.println(sancYn);
		
		
		//service
//		AdminReplyBlameService ars = new AdminReplyBlameService();
		
//		AdminReplyBlameVo vo = ars.updateBlameSanc(sancYn);
//		resp.sendRedirect("/admin/blame/r_blame_detail");
	}
}

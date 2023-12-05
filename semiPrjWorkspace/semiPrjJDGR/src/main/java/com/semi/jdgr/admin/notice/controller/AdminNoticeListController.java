package com.semi.jdgr.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.csboard.service.NoticeService;
import com.semi.jdgr.page.vo.PageVo;

@WebServlet("/admin/notice/list")
public class AdminNoticeListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		NoticeService ns = new NoticeService();
		//data
		String pno = req.getParameter("pno");
		//service
		
		//view
		
		req.getRequestDispatcher("/WEB-INF/views/admin/notice/noticeList.jsp").forward(req, resp);
	}
}

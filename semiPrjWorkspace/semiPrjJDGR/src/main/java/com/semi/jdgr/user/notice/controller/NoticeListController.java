package com.semi.jdgr.user.notice.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.notice.vo.NoticeVo;
import com.semi.jdgr.user.csboard.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			NoticeService ns = new NoticeService();
			//data
			String currentPage__ = req.getParameter("pno");
			if(currentPage__ == null) {
				currentPage__ = "1";
			}
			
			//service
			List<NoticeVo> noticeVoList = ns.selectNoticeList();
			
			if(noticeVoList == null) {
				throw new Exception();
			}
			
			//view
			req.setAttribute("noticeVoList", noticeVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/notice/noticeList.jsp").forward(req, resp);
		
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 공지사항 목록 페이지 에러 발생");
		}
	}
}

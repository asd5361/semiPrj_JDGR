package com.semi.jdgr.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.csboard.service.NoticeService;
import com.semi.jdgr.notice.vo.NoticeVo;

@WebServlet("/admin/notice/write")
public class AdminNoticeWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("pno", req.getParameter("pno"));
		req.getRequestDispatcher("/WEB-INF/views/admin/notice/noticeCreateEdit.jsp").forward(req, resp);
					
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			NoticeVo vo = new NoticeVo();
			vo.setNoticeNo(req.getParameter("no"));
			vo.setDelYn(req.getParameter("del"));
			vo.setFixedYn(req.getParameter("fixed"));
			vo.setTitle(req.getParameter("title"));
			vo.setContent(req.getParameter("content").replace("\r\n", "<br>"));

			//service
			NoticeService ns = new NoticeService();
			/*여기는 작성만 신경쓰기*/
			//view
			resp.sendRedirect("/jdgr/admin/notice/list?pno=1");
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 관리자 공지사항 작성 페이지 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}	
	}
}

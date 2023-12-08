package com.semi.jdgr.admin.csboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.csboard.vo.CsboardVo;

@WebServlet("/csborad/search")
public class AdminCSboardSearchController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//data
			CsboardVo vo = new CsboardVo();
			vo.setqTit(req.getParameter(""));
			vo.setqCon(req.getParameter(""));
//			vo.set(req.getParameter(""));
//			vo.setqTit(req.getParameter(""));
//			vo.setqTit(req.getParameter(""));
//			vo.setqTit(req.getParameter(""));
			//service
			
			//result
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 관리자 1:1문의 검색 기능 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}
		
	}
}

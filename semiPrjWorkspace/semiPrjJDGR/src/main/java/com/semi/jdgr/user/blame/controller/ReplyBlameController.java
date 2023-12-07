package com.semi.jdgr.user.blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.user.blame.service.ReplyBlameService;
import com.semi.jdgr.user.blame.vo.ReplyBlameVo;

@WebServlet("/user/blame/r_blamepop")
public class ReplyBlameController extends HttpServlet{
	
	//유저가 신고한 신고구분 가져오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/blame/r_blamepop.jsp").forward(req, resp);
	
	}//doGet
	
	//신고 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			String rBlaNo = req.getParameter("rBlaNo");
			String rNo = req.getParameter("rNo");
			String rBlamerNo = req.getParameter("rBlamerNo");
			String rWriterNo = req.getParameter("rWriterNo");
			String rBlaCon = req.getParameter("rBlaCon");
			String rBlaDate = req.getParameter("rBlaDate");
			String rSancYn = req.getParameter("rSancYn");
			String rAnsDate = req.getParameter("rAnsDate");
			String rBlaDetail = req.getParameter("rBlaDetail");
			String rDelYn = req.getParameter("rDelYn");
			String[] rBlaList = req.getParameterValues("rBlaList");
			
			ReplyBlameVo vo = new ReplyBlameVo();
			vo.setrBlaNo(rBlaNo);
			vo.setrNo(rNo);
			vo.setrBlamerNo(rBlamerNo);
			vo.setrWriterNo(rWriterNo);
			vo.setrBlaCon(rBlaCon);
			vo.setrBlaDate(rBlaDate);
			vo.setrSancYn(rSancYn);
			vo.setrAnsDate(rAnsDate);
			vo.setrBlaDetail(rBlaDetail);
			vo.setrDelYn(rDelYn);
			vo.setrBlaList(rBlaList);
			
			
			//service
			ReplyBlameService rbs = new ReplyBlameService();
			int result = rbs.blame(vo);
			
			//result(==view)
			if(result == 1) {
				HttpSession session = req.getSession();
				session.setAttribute("alertMsg", "신고가 접수됐습니다.");
				resp.sendRedirect("/jdgr/home");
			}else {
				throw new Exception("result 값이 1이 아님");
			}
			
		}catch(Exception e) {
			System.out.println("신고 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "신고");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
		
		
	}//doPost


	
	
}//class
























package com.semi.jdgr.user.blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.user.blame.service.PostBlameService;
import com.semi.jdgr.user.blame.vo.PostBlameVo;

@WebServlet("/user/blame/p_blamepop")
public class PostBlameController extends HttpServlet{
	
	//신고하기 모달 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/blame/p_blamepop.jsp").forward(req, resp);
	
	}//doGet
	
	//신고 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			String pBlaNo = req.getParameter("pBlaNo");
			String pNo = req.getParameter("pNo");
			String pBlamerNo = req.getParameter("pBlamerNo");
			String pWriterNo = req.getParameter("pWriterNo");
			String pBlaTit = req.getParameter("pBlaTit");
			String pBlaDate = req.getParameter("pBlaDate");
			String pBlaList = req.getParameter("pBlaList");
			String pSancYn = req.getParameter("pSancYn");
			String pAnsDate = req.getParameter("pAnsDate");
			String pBlaDetail = req.getParameter("pBlaDetail");
			String pDelYn = req.getParameter("pDelYn");
			
			PostBlameVo vo = new PostBlameVo();
			vo.setpBlaNo(pBlaNo);
			vo.setpNo(pNo);
			vo.setpBlamerNo(pBlamerNo);
			vo.setpWriterNo(pWriterNo);
			vo.setpBlaTit(pBlaTit);
			vo.setpBlaDate(pBlaDate);
			vo.setpBlaList(pBlaList);
			vo.setpSancYn(pSancYn);
			vo.setpAnsDate(pAnsDate);
			vo.setpBlaDetail(pBlaDetail);
			vo.setpDelYn(pDelYn);
			
			
			//service
			PostBlameService pbs = new PostBlameService();
			int result = pbs.blame(vo);
			
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
























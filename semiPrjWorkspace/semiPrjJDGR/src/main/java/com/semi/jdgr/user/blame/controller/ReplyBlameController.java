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
	

	
	//신고하기 모달 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/blame/r_blamepop.jsp").forward(req, resp);
		try {
			//data
			String replyNo = req.getParameter("replyNo");
			String postNo = req.getParameter("postNo");
			String replyMem = req.getParameter("replyMem");
			String parentsNo = req.getParameter("parentsNo");
			String con = req.getParameter("con");
			
			ReplyBlameVo vo = new ReplyBlameVo();
			vo.setReplyNo(replyNo);
			vo.setPostNo(postNo);
			vo.setReplyMem(replyMem);
			vo.setParentsNo(parentsNo);
			vo.setCon(con);
			
			//service
			ReplyBlameService rbs = new ReplyBlameService();
			ReplyBlameVo rvo = rbs.getReplyInfo(vo);
			
			HttpSession session = req.getSession();
					
			//result(==view)
			if(rvo == null) {
				session.setAttribute("alertMsg", "댓글 정보 불러오기 실패");
				throw new Exception("댓글 신고 실패");
			}
			session.setAttribute("rvo", rvo);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "신고");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	
		
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
			String rBlaList = req.getParameter("rBlaList");
			String rSancYn = req.getParameter("rSancYn");
			String rAnsDate = req.getParameter("rAnsDate");
			String rBlaDetail = req.getParameter("rBlaDetail");
			String rDelYn = req.getParameter("rDelYn");
			
			ReplyBlameVo vo = new ReplyBlameVo();
			vo.setrBlaNo(rBlaNo);
			vo.setrNo(rNo);
			vo.setrBlamerNo(rBlamerNo);
			vo.setrWriterNo(rWriterNo);
			vo.setrBlaCon(rBlaCon);
			vo.setrBlaDate(rBlaDate);
			vo.setrBlaList(rBlaList);
			vo.setrSancYn(rSancYn);
			vo.setrAnsDate(rAnsDate);
			vo.setrBlaDetail(rBlaDetail);
			vo.setrDelYn(rDelYn);
			
			
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
























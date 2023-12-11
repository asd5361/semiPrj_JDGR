package com.semi.jdgr.user.blame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.user.blame.service.ReplyBlameService;
import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.user.reply.vo.ReplyVo;

@WebServlet("/user/blame/r_blamepop")
public class ReplyBlameController extends HttpServlet{
	

	
	//신고하기 모달 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			ReplyVo vo = new ReplyVo();
			
			vo.setReplyNo("3");	
			vo.setReplyMem("2");
			vo.setCon("내용");

//			String replyNo = req.getParameter("replyNo");
//			String postNo = req.getParameter("postNo");
//			String replyMem = req.getParameter("replyMem");
//			String parentsNo = req.getParameter("parentsNo");
//			String con = req.getParameter("con");
//			
//			ReplyBlameVo vo = new ReplyBlameVo();
//			vo.setReplyNo(replyNo);
//			vo.setPostNo(postNo);
//			vo.setReplyMem(replyMem);
//			vo.setParentsNo(parentsNo);
//			vo.setCon(con);
			
			//service
			ReplyBlameService rbs = new ReplyBlameService();
			List<ReplyBlameVo> rvo = rbs.blameList();
					
			
			//result(==view)
			if(rvo == null) {
				req.setAttribute("alertMsg", "댓글 정보 불러오기 실패");
				throw new Exception("댓글 신고 실패");
			}
			req.setAttribute("rvo", rvo);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/user/blame/r_blamepop.jsp").forward(req, resp);
			
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

			
			String rBlaList = req.getParameter("rBlaList");
			String rBlaDetail = req.getParameter("rBlaDetail");
			String rWriterNo = req.getParameter("rWriterNo");
			String rBlaCon = req.getParameter("rBlaCon");
			String rBlaNo = req.getParameter("rBlaNo");
			
			ReplyBlameVo vo = new ReplyBlameVo();
			vo.setrBlaList(rBlaList);
			vo.setrBlaDetail(rBlaDetail);
			vo.setrWriterNo(rWriterNo);
			vo.setrBlaCon(rBlaCon);
			vo.setrBlaNo(rBlaNo);
			
			
			//service
			ReplyBlameService rbs = new ReplyBlameService();
			int result = rbs.blame(vo);
			
			//result(==view)
			if(result != 1) {
				throw new Exception("result 값이 1이 아님");
			}
			resp.sendRedirect("/jdgr/home");
			
		}catch(Exception e) {
			System.out.println("신고 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "신고");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
		
		
	}//doPost


	
	
}//class
























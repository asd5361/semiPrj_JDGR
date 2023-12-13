package com.semi.jdgr.user.blame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.blame.service.PostBlameService;
import com.semi.jdgr.user.blame.vo.PostBlameVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/user/blame/p_blamepop")
public class PostBlameController extends HttpServlet{
	
	//신고하기 모달 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
//			MemberVo memberVo = (MemberVo) req.getSession().getAttribute("loginMember");
//			if(memberVo == null) {
//				throw new Exception("로그인이 필요한 서비스입니다.");
//			}
			
			
			//data
			PostVo vo = new PostVo();
			vo.setPostNo(req.getParameter("postNo"));	
			vo.setUserNick(req.getParameter("userNick"));
			vo.setPostTitle(req.getParameter("postTitle"));

			// 댓글 정보를 모달에 전달
			req.setAttribute("vo", vo);

			 
			//service
			PostBlameService pbs = new PostBlameService();	
			List<PostBlameVo> pvo = pbs.blameList();			//신고 구분 목록 가져오기
			
			//result(==view)
			if(pvo == null) {
				req.setAttribute("alertMsg", "댓글 정보 불러오기 실패");
				throw new Exception("댓글 신고 실패");
			}
			req.setAttribute("pvo", pvo);
//			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/user/blame/p_blamepop.jsp").forward(req, resp);
			
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
			HttpSession session = req.getSession(false);
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");

			String loginMem = "1";
			String pWriterNo = req.getParameter("pWriterNo");
			String pBlaTit = req.getParameter("pBlaTit");
			String pBlaList = req.getParameter("pBlaList");
			String pBlaDetail = req.getParameter("pBlaDetail");
			String postNo = req.getParameter("postNo");
			
			PostBlameVo vo = new PostBlameVo();
			vo.setpBlamerNo(loginMem);
			vo.setpWriterNo(pWriterNo);
			vo.setpBlaTit(pBlaTit);
			vo.setpBlaList(pBlaList);
			vo.setpBlaDetail(pBlaDetail);
			vo.setpNo(postNo);
			
			
			//service
			PostBlameService pbs = new PostBlameService();
			int result = pbs.blame(vo);
			
			//result(==view)
			if(result != 1) {
		
				throw new Exception("result 값이 1이 아님");
			}
			
			//나중에 포스트 합치면 필요한 값 넣어서 화면으로
			System.out.println("성공");
//			resp.sendRedirect("/jdgr/home");
			
		}catch(Exception e) {
			System.out.println("신고 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "신고");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
		
		
	}//doPost


	
	
}//class
























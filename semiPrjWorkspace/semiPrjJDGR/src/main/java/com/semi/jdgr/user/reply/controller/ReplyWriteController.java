package com.semi.jdgr.user.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.jdgr.user.reply.service.ReplyService;
import com.semi.jdgr.user.reply.vo.ReplyVo;

@WebServlet("/reply/write")
public class ReplyWriteController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			//data
			String postNo = req.getParameter("pNo");
			String replyMem = req.getParameter("replyMem");
			String con = req.getParameter("con");
			ReplyVo vo = new ReplyVo();
			vo.setPostNo(postNo);
			vo.setReplyMem(replyMem);
			vo.setCon(con);
			
			//service
			ReplyService rs = new ReplyService();
			int result = rs.write(vo);
			if(result != 1) {
				throw new Exception();
			}
			/********작성 끝난 후 댓글 조회가 실행되어야 함*********/
			// result (replyVoList 를 JSON 문자열로 바꿔서 내보내기 - GSON 활용 예정)
			Gson gson = new Gson();				// GSON 이 제공하는 메소드를 사용하기 위해 객체 생성
			String str = gson.toJson(result);	// 객체 -> JSON형식문자열 변환 함수 호출
			
			resp.setCharacterEncoding("UTF-8");	// 한글 처리
			PrintWriter out = resp.getWriter();	// 문자열 내보내기를 위한 통로 준비 (JSP 필요없음)
			out.write(str);						// JSON 으로 변환된 문자열을 내보냄
			
			//ajax 처리 예정
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 댓글 작성 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);			e.printStackTrace();
			
		}
		
	}
}

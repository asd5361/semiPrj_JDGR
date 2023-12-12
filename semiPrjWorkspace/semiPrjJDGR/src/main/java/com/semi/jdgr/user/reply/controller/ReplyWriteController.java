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
			String replyNo = req.getParameter("replyNo");
			
			System.out.println("포스트넘버" + postNo);
			System.out.println("댓글쓴멤버" + replyMem);
			System.out.println("포스트내용" + con);
			System.out.println("댓글넘버" + replyNo);
			
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
			
			// result
			req.getRequestDispatcher("/WEB-INF/views/user/blog/blogView.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 댓글 작성 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);			e.printStackTrace();
			
		}
		
	}
}

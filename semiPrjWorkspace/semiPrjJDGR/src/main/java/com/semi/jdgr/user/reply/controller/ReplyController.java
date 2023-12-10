package com.semi.jdgr.user.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.user.reply.service.ReplyService;
import com.semi.jdgr.user.reply.vo.ReplyVo;

@WebServlet("/reply")
public class ReplyController extends HttpServlet{

	// 댓글 목록 조회하여 JSON 형태로 문자열 내보내기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String no = req.getParameter("no");	//refNo 에 해당하는 게시글 번호를 가져옴
			
			// service
			ReplyService bs = new ReplyService();
			List<ReplyVo> voList = bs.getReplyListByNo(no);
			
			// result (replyVoList 를 JSON 문자열로 바꿔서 내보내기 - GSON 활용 예정)
			Gson gson = new Gson();				// GSON 이 제공하는 메소드를 사용하기 위해 객체 생성
			String str = gson.toJson(voList);	// 객체 -> JSON형식문자열 변환 함수 호출
			
			resp.setCharacterEncoding("UTF-8");	// 한글 처리
			PrintWriter out = resp.getWriter();	// 문자열 내보내기를 위한 통로 준비 (JSP 필요없음)
			out.write(str);						// JSON 으로 변환된 문자열을 내보냄
			
		}catch(Exception e) {
			System.out.println("댓글 불러오기 실패 ...");
			e.printStackTrace();
		}
	}//doGet
}//class

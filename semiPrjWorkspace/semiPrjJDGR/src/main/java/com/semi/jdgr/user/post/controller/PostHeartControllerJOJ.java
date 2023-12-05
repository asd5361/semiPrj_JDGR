package com.semi.jdgr.user.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.post.service.PostServiceJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/post/heart")
public class PostHeartControllerJOJ extends HttpServlet {

	// 공감기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// data
//			String no = req.getParameter("no");
			PostVo postDetailVo = (PostVo) req.getSession().getAttribute("POST_NO");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if (loginMember == null) {
				throw new Exception("로그인 먼저 진행하세요.");
			}
			String no = postDetailVo.getPostNo();
			String memberNo = loginMember.getMemNo();

			// service
			PostServiceJOJ ps = new PostServiceJOJ();
			boolean isOk = ps.checkHeart(no, memberNo);
//			HttpSession session = req.getSession();
			

			// result
			int result = 0;
			if (isOk) {
				result = ps.AddHeart(no, memberNo);
				if (result == 1) {
					req.setAttribute("alertMsg1", "공감 추가");
					resp.sendRedirect("/jdgr/post/detail.jsp");
//					session.setAttribute("alertMsg1", "공감 추가");
//					req.getSession().setAttribute("alertMsg1", "공감 추가");
				}
			} else {
				int del = ps.delHeart(no, memberNo);
				if (del == 1) {
					req.setAttribute("alertMsg2", "취소");
					resp.sendRedirect("/jdgr/post/detail.jsp");
//					session.setAttribute("alertMsg1", "공감 취소");
//					req.getSession().setAttribute("alertMsg2", "공감 취소");
				}
			}

			resp.sendRedirect("/jdgr/post/detail");

		} catch (Exception e) {
			System.out.println("공감 오류 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "공감 오류 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}

	}// doGet

}// class

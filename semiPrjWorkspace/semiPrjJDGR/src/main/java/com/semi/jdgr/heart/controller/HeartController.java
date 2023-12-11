package com.semi.jdgr.heart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.alarm.vo.AlarmVo;
import com.semi.jdgr.post.service.PostServiceJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/heart")
public class HeartController extends HttpServlet{

		// 공감기능
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				// data
				PostVo postDetailVo = (PostVo) req.getSession().getAttribute("postDetailVo");
				MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
				
				System.out.println("공감기능 실행");
				System.out.println(postDetailVo);
				System.out.println(postDetailVo.getPostNo());
//				MemberVo loginMember = new MemberVo();
				AlarmVo alarmVo = new AlarmVo();
				
				
//				loginMember.setMemNo("4");
				if (loginMember == null) {
					throw new Exception("로그인 먼저 진행하세요.");
				}
				String no = postDetailVo.getPostNo();
				String memberNo = loginMember.getMemNo();

				
				// service
				PostServiceJOJ ps = new PostServiceJOJ();
				boolean isOk = ps.checkHeart(no, memberNo);
				
				//알람에 인서트
				String userNo = ps.findUserNo(postDetailVo.getUserNick());
				
				alarmVo.setReceiverNo(userNo);
				alarmVo.setPostNo(postDetailVo.getPostNo());
				alarmVo.setSenderNo(loginMember.getMemNo());
				alarmVo.setAlarmType("HEART");
				int insert = ps.insertHeartAlarm(alarmVo);
				
				if(insert != 1) {
					throw new Exception("알람 인서트 실패");
				}
				
				HttpSession session = req.getSession();			

				// result
				int add = 0;
				if (isOk) {
					add = ps.AddHeart(no, memberNo);
					if (add == 1) {
//						req.setAttribute("add", add);
						session.setAttribute("add", add);
						req.getSession().setAttribute("add", add);
					}
				} else {
					int del = ps.delHeart(no, memberNo);
					if (del == 1) {
//						req.setAttribute("del", del);
						session.setAttribute("del", del);
						req.getSession().setAttribute("del", del);
				} else {
						throw new Exception("공감 기능 오류 발생");
					}
				}

//				resp.sendRedirect("/jdgr/post/detail?url=${blogUrlVo.blogUrl}&&categoryNo=groupVo.getNo() %>");
				resp.sendRedirect("/jdgr/post/detail?url=" + postDetailVo.getBlogUrl() + "&&categoryNo=" + postDetailVo.getGroupNo());

			} catch (Exception e) {
				System.out.println("공감 오류 발생");
				e.printStackTrace();
				req.setAttribute("errorMsg", "공감 오류 발생");
				req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
			}
		
	}
	
}

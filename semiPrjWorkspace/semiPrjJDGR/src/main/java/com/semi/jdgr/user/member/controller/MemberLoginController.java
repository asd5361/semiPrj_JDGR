package com.semi.jdgr.user.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.jdgr.user.member.service.MemberService;
import com.semi.jdgr.user.member.vo.MemberReplySanctionVo;
import com.semi.jdgr.user.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// data
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setMemId(memberId);
			vo.setMemPwd(memberPwd);

			MemberService ms = new MemberService();
			List<MemberReplySanctionVo> mrsVoList = ms.findMRSVoList();
			
			//현재 날짜 구하기
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
			Calendar c1 = Calendar.getInstance();
			String strToday = dateFormat.format(c1.getTime());
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        
	        //현재 날짜 
	        LocalDate today = LocalDate.parse(strToday, formatter);
	        
	        //디비 날짜 변경
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss.SSSSSSSSS");
	        LocalDateTime dateTime = LocalDateTime.parse("23/12/04 17:22:03.000000000", inputFormatter);
	        
	        // LocalDateTime을 다른 형식으로 포맷
	        String formattedDate = dateTime.format(formatter);
	        // 제재가 걸린 날짜
	        LocalDate date = LocalDate.parse(formattedDate, formatter);
	        
	        //날짜에 일 수 더 하기
//	        LocalDate endDate = date.plusDays(3);
//	        
//	        System.out.println(endDate);
	        
	       // 두 날짜 빼서 수 구하기
//	        long daysDifference = date.until(today, ChronoUnit.DAYS);
//
//	        System.out.println("두 날짜 사이의 일 수 차이: " + daysDifference + "일");
			boolean sanctionId = false;
			for(MemberReplySanctionVo mrsVo : mrsVoList) {
				if(memberId.equals(mrsVo.getMemId())) {
					
				}
					
			}
			
			// service
			MemberVo loginMember = ms.login(vo);
			
			
			HttpSession session = req.getSession();
			// result (==view)
			if(loginMember == null) {
				session.setAttribute("alertMsg", "아이디 또는 비밀번호가 틀렸습니다.");
				throw new Exception("로그인 실패 ...");
			}
			
			session.setAttribute("loginMember", loginMember);
			resp.sendRedirect("/jdgr/home"); 
			
		}catch(Exception e) {
			e.printStackTrace();
			
			resp.sendRedirect("/jdgr/member/login"); 
			
		}
		
	}
}

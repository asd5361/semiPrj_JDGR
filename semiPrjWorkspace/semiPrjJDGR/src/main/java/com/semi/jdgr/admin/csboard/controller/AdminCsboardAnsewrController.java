package com.semi.jdgr.admin.csboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.csboard.service.CsboardService;
import com.semi.jdgr.csboard.vo.CsboardVo;

@WebServlet("/admin/csboard/ansewr")
public class AdminCsboardAnsewrController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String adminNo = "1"; /*******로그인 임시로 넣음****************************/
			
			String pno = req.getParameter("pno");
			String ansewrDate = req.getParameter("ansDate");
			String DateColumn = "UPDATE_DATE";
			System.out.println(pno);
			/*pno가 null 임 + option selected 넣어줘야함 답변 조회해야함*/
			CsboardVo vo = new CsboardVo();
			vo.setAdminNo(adminNo);
			vo.setqNo(req.getParameter("no"));
			vo.setDelYn(req.getParameter("del"));
			vo.setAnsewr(req.getParameter("ansewr"));
			
			if(ansewrDate == null) {
				DateColumn = "ANSEWR_DATE";
			}
			//service
			CsboardService cs = new CsboardService();
			int result = cs.csboardAnsewr(vo,DateColumn);
			
			//result 
			if(result != 1) {
				throw new Exception();
			}
			
			resp.sendRedirect("/admin/csboard/list?pno="+pno);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 관리자 1:1문의 답변 기능 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);			
		}
		
	}
}

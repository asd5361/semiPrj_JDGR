package com.semi.jdgr.user.csboard.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jdgr.post.vo.PageVo;
import com.semi.jdgr.user.csboard.service.CsboardService;
import com.semi.jdgr.user.csboard.vo.CsboardVo;

@WebServlet("/csboard/list")
public class CsboardListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			CsboardService cs = new CsboardService();
			int listCount = cs.selectCsboardCount();	//전체 게시글 갯수 조회
			
			//data
			String currentPage__ = req.getParameter("pno");
			if(currentPage__ == null) {
				currentPage__ = "1";
			}
			int currentPage = Integer.parseInt(currentPage__); 	//현재 페이지
			int pageLimit = 10;									//화면에 보여줄 총 페이지 수 
			int boardLimit = 10;								// 한 페이지에 보여줄 글목록 수
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			//service
			List<CsboardVo> csboardVoList = cs.selectCsboardList(pvo);
			
			//view
			if(csboardVoList == null) {
				throw new Exception();
			}
			req.setAttribute("pvo", pvo);
			req.setAttribute("csboardVoList", csboardVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/csboard/csboardList.jsp").forward(req, resp);
			
		}catch(Exception e ) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR] 1:1문의 목록 페이지 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/user/common/error.jsp").forward(req, resp);
		}
	}
}

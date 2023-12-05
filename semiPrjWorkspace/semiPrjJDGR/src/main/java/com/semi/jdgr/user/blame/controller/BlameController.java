package com.semi.jdgr.user.blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/blame/blamepop")
public class BlameController extends HttpServlet{
	
	//유저가 신고한 신고구분 가져오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/blame/blamepop.jsp").forward(req, resp);
	
	}


	
	
	}
package com.semi.jdgr.user.blog.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/blogSet/categoryAdd")
public class BlogCategoryAddController extends HttpServlet {
	
	// 카테고리 그룹 추가하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// data
		// 클라이언트로부터 전송된 JSON 데이터 읽기
        BufferedReader reader = req.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        System.out.println(jsonBuilder.toString());
        Gson gson = new Gson();
        //String json = gson.fromJson(jsonBuilder.toString());
        //System.out.println(json);
		// service
		
		// result
        PrintWriter out = resp.getWriter();
        String str = "{\"title\":\"ttt\",\"content\":\"ccc\"}";
		
		out.write(str);
		
	}
	
}

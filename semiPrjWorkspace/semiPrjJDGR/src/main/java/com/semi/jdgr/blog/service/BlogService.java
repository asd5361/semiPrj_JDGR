package com.semi.jdgr.blog.service;

import java.sql.Connection;

import com.semi.jdgr.blog.dao.BlogDao;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class BlogService {

	// 블로그 정보 가져오기
	public BlogVo getUserblog(MemberVo memberVo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		BlogVo blogVo = dao.getUserBlog(conn, memberVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogVo;
	}
	
}

package com.semi.jdgr.post.service;

import java.sql.Connection;

import com.semi.jdgr.post.dao.PostDaoJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceJOJ {
	
	// conn
	
	// dao
	
	// close

	public PostVo PostDetail(PostVo postDetailVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postDetailVo = dao.PostDetail(conn, postDetailVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return postDetailVo;
		
	}
	


}

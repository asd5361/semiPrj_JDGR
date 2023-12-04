package com.semi.jdgr.post.service;

import java.sql.Connection;

import com.semi.jdgr.post.dao.PostDaoJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceJOJ {
	
	// conn
	
	// dao
	
	// tx
	
	// close

	// 포스트 상세보기 (화면) (+조회수 증가)
	public PostVo PostDetail(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		int result = dao.increaseHit(conn, no);
		
		
		PostVo postDetailVo = null;
		if (result == 1) {
			postDetailVo = dao.PostDetail(conn, no);
		}
		
		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return postDetailVo;
		
	}// PostDetail

	// 관리자 상세보기
	public PostVo AdminPostDetail(String no) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo adminPostDetailVo = dao.AdminPostDetail(conn, no);
		
		// close
		JDBCTemplate.close(conn);
		
		return adminPostDetailVo;
		
	}// AdminPostDetail


	



	


}

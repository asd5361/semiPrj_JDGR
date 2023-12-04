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

	// 포스트 상세보기 (화면) (+조회수 증가) (+공감수)
	public PostVo PostDetail(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		int result = dao.increaseHit(conn, no);
		PostVo heart = dao.heartNumber(conn, no);
		
		
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
		return heart;
		
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
	
	// 공감체크 기능
		public boolean checkHeartDup(String no, String memberNo) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			PostDaoJOJ dao = new PostDaoJOJ();
			boolean result = dao.checkHeartDup(conn, no, memberNo);
			
			// tx
			
			// close
			JDBCTemplate.close(conn);
			return result;
			
		}// checkHeartDup

	// 공감추가 기능
	public int AddHeart(String no, String memberNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		int result = dao.AddHeart(conn, no, memberNo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		return result;
		
	}// AddHeart

	//공감삭제 기능
	public int delHeart(String no, String memberNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		int del = dao.delHeart(conn, no, memberNo);

		// tx
		if (del == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return del;
		
	}
	
	

	



	



	


}// class

package com.semi.jdgr.post.service;

import java.sql.Connection;

import com.semi.jdgr.post.dao.PostDaoJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceJOJ2 {
	
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
	
	// 공감수
	public PostVo heartCnt(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo heartCnt = dao.heartCnt(conn, no);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return heartCnt;
		
	}// heartHit
	
	// 댓글수
	public PostVo ReplyCnt(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo replyCnt = dao.ReplyCnt(conn, no);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return replyCnt;
		
	}// ReplyCnt
	

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
	
	// 관리자 상세보기 (공개여부 , 삭제여부 수정)
	public int AdminPostEdit(PostVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		int result = dao.AdminPostEdit(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	// 공감체크 기능
		public boolean checkHeart(String no, String memberNo) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			PostDaoJOJ dao = new PostDaoJOJ();
			boolean heartCheck = dao.checkHeart(conn, no, memberNo);
			
			// tx
			
			// close
			JDBCTemplate.close(conn);
			return heartCheck;
			
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

	// 공감삭제 기능
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

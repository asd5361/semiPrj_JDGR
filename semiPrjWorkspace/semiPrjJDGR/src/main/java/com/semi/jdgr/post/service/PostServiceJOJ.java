package com.semi.jdgr.post.service;

import java.sql.Connection;

import com.semi.jdgr.alarm.vo.AlarmVo;
import com.semi.jdgr.post.dao.PostDaoJOJ;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceJOJ {

	// 포스트 상세보기 (블로그 카테고리 상세보기용) (+조회수 증가) (+공감수) (+댓글수)
	public PostVo PostDetail(String categoryNo, String BlogUrl) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postDetailVo = dao.PostDetail(conn, categoryNo, BlogUrl);
		int result = dao.PostDetailIncreaseHit(conn, postDetailVo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return postDetailVo;

	}// PostDetail
	
	

	// 공감수 (블로그 카테고리 상세보기용)
	public PostVo PostDetailHeartCnt(PostVo postDetailVo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postDetailHeartCnt = dao.PostDetailHeartCnt(conn, postDetailVo);

		// tx

		// close
		JDBCTemplate.close(conn);

		return postDetailHeartCnt;

	}// heartHit

	// 댓글수 (블로그 카테고리 상세보기용)
	public PostVo PostDetailReplyCnt(PostVo postDetailVo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo PostDetailReplyCnt = dao.PostDetailReplyCnt(conn, postDetailVo);

		// tx

		// close
		JDBCTemplate.close(conn);

		return PostDetailReplyCnt;

	}// ReplyCnt

//	---------------------------------------------------------------------

	// 포스트 VO 가져오기 (BLOG_URL , GROUP_NO , POST_NO)
	public PostVo PostNoVo(String postNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postVo = dao.PostNoVo(conn, postNo);

		// tx

		// close
		JDBCTemplate.close(conn);

		return postVo;
		
	}// PostNo

	// 포스트 상세보기 (목록보기용) (포스트넘버로 url , categoryNo 등등 꺼내오기) (+조회수 증가) (+공감수) (+댓글수)
	public PostVo PostListDetail(String pNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postListDetailVo = dao.PostListDetail(conn, pNo);
		int result = dao.PostListDetailIncreaseHit(conn, pNo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return postListDetailVo;

	}// PostDetail

	// 공감수 (목록보기용)
	public PostVo PostListDetailHeartCnt(String pNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postListDetailHeartCnt = dao.PostListDetailHeartCnt(conn, pNo);

		// tx

		// close
		JDBCTemplate.close(conn);

		return postListDetailHeartCnt;

	}// heartHit

	// 댓글수 (목록보기용)
	public PostVo PostListDetailReplyCnt(String pNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		PostVo postListDetailReplyCnt = dao.PostListDetailReplyCnt(conn, pNo);

		// tx

		// close
		JDBCTemplate.close(conn);

		return postListDetailReplyCnt;

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
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
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
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
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

	public int insertHeartAlarm(AlarmVo alarmVo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		PostDaoJOJ dao = new PostDaoJOJ();
		int result = dao.insertHeartAlarm(conn, alarmVo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return result;
	}

	public String findUserNo(String userNick) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		PostDaoJOJ dao = new PostDaoJOJ();
		String UserNo = dao.findUserNo(conn, userNick);

		if (UserNo != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		return UserNo;
	}

}// class

package com.semi.jdgr.post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostDaoJOJ {

	// sql

	// rs

	// close

	// 포스트 상세보기 (화면)
	public PostVo PostDetail(Connection conn, String no) throws Exception {

		// sql
		String sql = "SELECT C.CATEGORY_NAME ,P.TITLE ,P.POST_IMG ,M.MEM_NICK ,P.ENROLL_DATE ,P.CONTENT ,H.POST_NO ,R.POST_NO FROM POST P JOIN CATEGORY_LIST C ON P.POST_NO = C.CATEGORY_NO JOIN HEART H ON P.POST_NO = H.POST_NO JOIN REPLY R ON P.POST_NO = REPLY_NO JOIN BLOG B ON P.POST_NO = B.BLOG_NO JOIN MEMBER M ON B.BLOG_NO = M.MEM_NO WHERE P.POST_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		PostVo postDetailVo = null;
		if (rs.next()) {
			String postNo = rs.getString("POST_NO");
			String categoryName = rs.getString("CATEGORY_NAME");
			String postTitle = rs.getString("TITLE");
			String postImg = rs.getString("POST_IMG");
			String userNick = rs.getString("MEM_NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String content = rs.getString("CONTENT");
//			String heartCnt = rs.getString("POST_NO");
//			String replyCnt = rs.getString("POST_NO");

			postDetailVo = new PostVo();
			postDetailVo.setPostNo(postNo);
			postDetailVo.setCategoryName(categoryName);
			postDetailVo.setPostTitle(postTitle);
			postDetailVo.setPostImg(postImg);
			postDetailVo.setUserNick(userNick);
			postDetailVo.setEnrollDate(enrollDate);
			postDetailVo.setContent(content);
//			postDetailVo.setHeartCnt(heartCnt);
//			postDetailVo.setReplyCnt(replyCnt);

		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return postDetailVo;

	}// PostDetail

	// 조회수 증가
	public int increaseHit(Connection conn, String no) throws Exception {

		// sql
		String sql = "UPDATE POST SET INQUIRY = INQUIRY+1 WHERE POST_NO = ? AND OPEN = 'Y'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();

		// rs
		

		// close
		JDBCTemplate.close(pstmt);

		return result;

	}// increaseHit

	// 공감수
	public PostVo heartCnt(Connection conn, String no) throws Exception {

		// sql
		String sql = "SELECT COUNT(POST_NO) AS POST_NO FROM HEART WHERE POST_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		PostVo heart = null;
		if(rs.next()) {
			String postNo = rs.getString("POST_NO");
			
			heart = new PostVo();
			heart.setPostNo(postNo);
		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return heart;

	}// heartCnt
	
	// 댓글수
	public PostVo ReplyCnt(Connection conn, String no) throws Exception {
		
		// sql
		String sql = "SELECT COUNT(POST_NO) AS POST_NO FROM REPLY WHERE POST_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		PostVo replyCnt = null;
		if(rs.next()) {
			String postNo = rs.getString("POST_NO");
			
			replyCnt = new PostVo();
			replyCnt.setPostNo(postNo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return replyCnt;
		
	}// FollowCnt
	

	// 관리자 상세보기
	public PostVo AdminPostDetail(Connection conn, String no) throws Exception {

		// sql
		String sql = "SELECT P.POST_IMG ,P.BLOG_NO ,M.MEM_ID ,P.OPEN ,P.INQUIRY ,P.DEL_YN ,P.MODIFY_DATE ,H.POST_NO ,P.ENROLL_DATE ,R.POST_NO ,P.TITLE ,P.CONTENT FROM POST P JOIN CATEGORY_LIST C ON P.POST_NO = C.CATEGORY_NO JOIN HEART H ON P.POST_NO = H.POST_NO JOIN REPLY R ON P.POST_NO = REPLY_NO JOIN BLOG B ON P.POST_NO = B.BLOG_NO JOIN MEMBER M ON B.BLOG_NO = M.MEM_NO WHERE P.POST_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		PostVo adminPostDetailVo = null;
		if (rs.next()) {
			String postImg = rs.getString("POST_IMG");
			String blogNo = rs.getString("BLOG_NO");
			String userId = rs.getString("MEM_ID");
			String open = rs.getString("OPEN");
			String inquiry = rs.getString("INQUIRY");
			String postDelYn = rs.getString("DEL_YN");
			String modifyDate = rs.getString("MODIFY_DATE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String postTitle = rs.getString("TITLE");
			String content = rs.getString("CONTENT");

			adminPostDetailVo = new PostVo();
			adminPostDetailVo.setPostImg(postImg);
			adminPostDetailVo.setBlogNo(blogNo);
			adminPostDetailVo.setUserId(userId);
			adminPostDetailVo.setOpen(open);
			adminPostDetailVo.setInquiry(inquiry);
			adminPostDetailVo.setPostDelYn(postDelYn);
			adminPostDetailVo.setModifyDate(modifyDate);
			adminPostDetailVo.setEnrollDate(enrollDate);
			adminPostDetailVo.setPostTitle(postTitle);
			adminPostDetailVo.setContent(content);
		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return adminPostDetailVo;

	}// AdminPostDetail

	// 공감체크 기능
	public boolean checkHeart(Connection conn, String no, String memberNo) throws Exception {

		// sql
		String sql = "SELECT * FROM HEART WHERE POST_NO = ? AND MEM_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, memberNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		boolean heartCheck = true;
		if (rs.next()) {
			heartCheck = false;
		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return heartCheck;

	}// checkHeartDup

	// 공감추가 기능
	public int AddHeart(Connection conn, String no, String memberNo) throws Exception {

		// sql
		String sql = "INSERT INTO HEART (POST_NO, MEM_NO) VALUES (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, memberNo);
		int result = pstmt.executeUpdate();

		// rs

		// close
		JDBCTemplate.close(pstmt);

		return result;

	}// AddHeary

	// 공감삭제 기능
	public int delHeart(Connection conn, String no, String memberNo) throws Exception {

		// sql
		String sql = "DELETE FROM HEART WHERE POST_NO = ? AND MEM_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, memberNo);
		int del = pstmt.executeUpdate();

		// rs

		// close
		JDBCTemplate.close(pstmt);

		return del;

	}

}// class

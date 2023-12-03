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
	// 관리자 상세보기
	public PostVo PostDetail(Connection conn, String no) throws Exception {
		
		// sql
		String sql = "SELECT C.CATEGORY_NAME ,P.TITLE ,P.POST_IMG ,M.MEM_NICK ,P.ENROLL_DATE ,P.CONTENT ,H.POST_NO ,R.POST_NO FROM POST P JOIN CATEGORY_LIST C ON P.POST_NO = C.CATEGORY_NO JOIN HEART H ON P.POST_NO = H.POST_NO JOIN REPLY R ON P.POST_NO = REPLY_NO JOIN BLOG B ON P.POST_NO = B.BLOG_NO JOIN MEMBER M ON B.BLOG_NO = M.MEM_NO WHERE P.POST_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		PostVo postDetailVo = null;
		if(rs.next()) {
			String categoryName = rs.getString("CATEGORY_NAME");
			String postTitle = rs.getString("TITLE");
			String postImg = rs.getString("POST_IMG");
			String userNick = rs.getString("MEM_NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String content = rs.getString("CONTENT");
			String heartCnt = rs.getString("POST_NO");
			String replyCnt = rs.getString("POST_NO");
			
			postDetailVo = new PostVo();
			postDetailVo.setCategoryName(categoryName);
			postDetailVo.setPostTitle(postTitle);
			postDetailVo.setPostImg(postImg);
			postDetailVo.setUserNick(userNick);
			postDetailVo.setEnrollDate(enrollDate);
			postDetailVo.setContent(content);
			postDetailVo.setHeartCnt(heartCnt);
			postDetailVo.setReplyCnt(replyCnt);
			

		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return postDetailVo;
		
	}// PostDetail

	public PostVo AdminPostDetail(Connection conn, String no) throws Exception {
		
		// sql
		String sql = "";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		PostVo adminPostDetailVo = null;
		if(rs.next()) {
			String postImg = rs.getString("POST_IMG");
			String blogNo = rs.getString("BLOG_NO");
			String userId = rs.getString("MEM_ID");
			String open = rs.getString("OPEN");
			String inquiry = rs.getString("INQUIRY");
			String del = rs.getString("DEL_YN");
			String modifyDate = rs.getString("MODIFY_DATE");
			String heartCnt = rs.getString("POST_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String replyCnt = rs.getString("POST_NO");
			String postTitle = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			
			adminPostDetailVo = new PostVo();
			adminPostDetailVo.setPostImg(postImg);

		}
			
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return adminPostDetailVo;
	}
	


}// class

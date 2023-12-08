package com.semi.jdgr.post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostDaoHJY {

	// 포스트 작성
	public int postWrite(Connection conn, PostVo postVo, String blogNo) throws Exception {
		
		// sql
		String sql = "INSERT INTO POST (POST_NO, BLOG_NO, CATEGORY_NO, GROUP_NO, TITLE, CONTENT) VALUES (SEQ_POST_NO.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogNo);
		pstmt.setString(2, postVo.getCategoryNo());
		pstmt.setString(3, postVo.getGroupNo());
		pstmt.setString(4, postVo.getPostTitle());
		pstmt.setString(5, postVo.getContent());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}

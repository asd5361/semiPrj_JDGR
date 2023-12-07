package com.semi.jdgr.user.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.user.blame.vo.PostBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostBlameDao {

	public int blame(Connection conn, PostBlameVo vo) throws Exception {

		// sql
		String sql = "INSERT INTO POST_BLAME (P_BLA_NO, P_NO, P_BLAMER_NO, P_WRITER_NO, P_BLA_TIT, P_BLA_DATE, P_BLA_LIST, P_SANC_YN, P_ANS_DATE, P_BLA_DETAIL, P_DEL_YN) VALUES(?, ?, ?, ?, ?, TIMESTAMP '2023-11-29 15:01:00', ?, ?, TIMESTAMP '2023-11-29 15:01:00', ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getpBlaNo());
		pstmt.setString(2, vo.getpNo());
		pstmt.setString(3, vo.getpBlamerNo());
		pstmt.setString(4, vo.getpWriterNo());
		pstmt.setString(5, vo.getpBlaTit());
		pstmt.setString(6, vo.getpBlaDate());
		pstmt.setString(7, vo.getpBlaListStr());
		pstmt.setString(8, vo.getpSancYn());
		pstmt.setString(9, vo.getpAnsDate());
		pstmt.setString(10, vo.getpBlaDetail());
		pstmt.setString(11, vo.getpDelYn());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;		
		
		//rs
		
		//close
		
	}//blame
	


}//class

package com.semi.jdgr.user.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyBlameDao {

	public int blame(Connection conn, ReplyBlameVo vo) throws Exception {

		// sql
		String sql = "INSERT INTO REPLY_BLAME (R_BLA_NO, R_NO, R_BLAMER_NO, R_WRITER_NO, R_BLA_CON, R_BLA_DATE, R_BLA_LIST, R_SANC_YN, R_ANS_DATE, R_BLA_DETAIL, R_DEL_YN) VALUES(?, ?, ?, ?, ?, TIMESTAMP '2023-11-29 15:01:00', ?, ?, TIMESTAMP '2023-11-29 15:01:00', ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getrBlaNo());
		pstmt.setString(2, vo.getrNo());
		pstmt.setString(3, vo.getrBlamerNo());
		pstmt.setString(4, vo.getrWriterNo());
		pstmt.setString(5, vo.getrBlaCon());
		pstmt.setString(6, vo.getrBlaDate());
		pstmt.setString(7, vo.getrBlaList());
		pstmt.setString(8, vo.getrSancYn());
		pstmt.setString(9, vo.getrAnsDate());
		pstmt.setString(10, vo.getrBlaDetail());
		pstmt.setString(11, vo.getrDelYn());
		int result = pstmt.executeUpdate();

		// close
		JDBCTemplate.close(pstmt);
		
		return result;		
		
		//rs
		
		//close
		
	}//blame
	


}//class

package com.semi.jdgr.user.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.admin.blame.vo.AdminPostBlameVo;
import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyBlameDao {

	public int blame(Connection conn, ReplyBlameVo vo) throws Exception {

		// sql
		String sql = "INSERT INTO REPLY_BLAME (R_BLA_NO, R_NO, R_BLAMER_NO, R_WRITER_NO, R_BLA_CON, R_BLA_DATE, R_BLA_LIST, R_SANC_YN, R_ANS_DATE, R_BLA_DETAIL, R_DEL_YN) VALUES(SEQ_POST_BLAME.NEXTVAL, ?, ?, ?, ?, SYSTIMESTAMP, ?, ?, SYSTIMESTAMP, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getrBlaNo());
		pstmt.setString(1, vo.getrNo());
		pstmt.setString(2, vo.getrBlamerNo());
		pstmt.setString(3, vo.getrWriterNo());
		pstmt.setString(4, vo.getrBlaCon());
//		pstmt.setString(6, vo.getrBlaDate());
		pstmt.setString(5, vo.getrBlaList());
		pstmt.setString(6, vo.getrSancYn());
//		pstmt.setString(9, vo.getrAnsDate());
		pstmt.setString(7, vo.getrBlaDetail());
		pstmt.setString(8, vo.getrDelYn());
		int result = pstmt.executeUpdate();

		// close
		JDBCTemplate.close(pstmt);
		
		return result;		

	}


	//BLA_LIST 불러와서 모달창 띄우기
	public List<String> blameList(Connection conn) throws Exception {
		   //SQL
		   String sql = "SELECT BLA_REASON FROM BLAME_REASON";
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   ResultSet rs = pstmt.executeQuery();
		   //rs
		   List<String> reasonList = new ArrayList<>();
		   while(rs.next()) {
			   String rBlaList = rs.getString("BLA_REASON");
			   
			   ReplyBlameVo vo = new ReplyBlameVo();
			   vo.setrBlaList(rBlaList);
		   }
		   
		   //close
		   JDBCTemplate.close(rs);
		   JDBCTemplate.close(pstmt);
		   
		   return reasonList;
	}
	
}//class
   

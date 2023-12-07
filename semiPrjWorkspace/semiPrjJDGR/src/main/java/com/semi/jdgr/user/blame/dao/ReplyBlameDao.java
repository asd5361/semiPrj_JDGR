package com.semi.jdgr.user.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyBlameDao {

	public int blame(Connection conn, ReplyBlameVo vo) {

		// sql
		String sql = "INSERT INTO MEMBER ( NO ,ID ,PWD ,NICK ,PHONE ,EMAIL ,ADDRESS ,HOBBYS ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getrBlaNo());
		pstmt.setString(2, vo.getrNo());
		pstmt.setString(3, vo.getrBlamerNo());
		pstmt.setString(4, vo.getrWriterNo());
		pstmt.setString(5, vo.getrBlaCon());
		pstmt.setString(6, vo.getrBlaDate());
		pstmt.setString(7, vo.getrBlaDetailReason());
		pstmt.setString(8, vo.getrSancYn());
		pstmt.setString(9, vo.getrAnsDate());
		pstmt.setString(10, vo.getrBlaDetail());
		pstmt.setString(11, vo.getrDelYn());
		pstmt.setString(12, vo.getrBlaListStr());
		int result = pstmt.executeUpdate();
		

		
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;		
		//rs
		
		//close
		
	}
	
	//유저가 제출한 신고구분 / 상세내용 가져오기
	


}

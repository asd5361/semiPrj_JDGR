package com.semi.jdgr.user.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.user.reply.vo.ReplyVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyDao {

	
	//댓글 작성하기
	public int write(Connection conn, ReplyVo vo) throws Exception {
	
		// SQL
		String sql = "INSERT INTO REPLY ( REPLY_NO ,POST_NO ,REPLY_MEM ,CON, WRITE_DATE, UPDATE_DATE, DEL_YN )"
				+ " VALUES ( SEQ_REPLY_NO.NEXTVAL , ? , ? , ?, SYSTIMESTAMP, 'N', 'N' )";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPostNo());
		pstmt.setString(2, vo.getReplyMem());
		pstmt.setString(3, vo.getCon());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}//write

	
	//댓글 목록 조회
	public List<ReplyVo> getReplyList(Connection conn, String replyNo) throws Exception{
		
		// SQL
		String sql = "SELECT REPLY_NO ,POST_NO ,REPLY_MEM ,CON ,WRITE_DATE ,UPDATE_DATE, DEL_YN FROM REPLY WHERE REPLY_NO = ? ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyNo);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<ReplyVo> voList = new ArrayList<ReplyVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String postNo = rs.getString("POST_NO");
			String replyMem = rs.getString("REPLY_MEM");
			String con = rs.getString("CON");
			String writeDate = rs.getString("WRITE_DATE");
			
			ReplyVo vo = new ReplyVo(no, replyNo, postNo, replyMem, con, writeDate);
			voList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}//getReplyList
}

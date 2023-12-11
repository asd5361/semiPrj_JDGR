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
		String sql = "INSERT INTO REPLY ( REPLY_NO ,POST_NO ,REPLY_MEM ,CON) VALUES ( SEQ_REPLY_NO.NEXTVAL , ? , ? , ?)";

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
		String sql = "SELECT REPLY_NO ,POST_NO ,REPLY_MEM ,CON ,WRITE_DATE ,UPDATE_DATE, DEL_YN FROM REPLY WHERE REPLY_NO = ? ORDER BY REPLY_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyNo);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<ReplyVo> replyVoList = new ArrayList<ReplyVo>();
		while(rs.next()) {
			String no = rs.getString("REPLY_NO");
			String postNo = rs.getString("POST_NO");
			String replyMem = rs.getString("REPLY_MEM");
			String con = rs.getString("CON");
			String writeDate = rs.getString("WRITE_DATE");
			
			ReplyVo vo = new ReplyVo();
			vo.setReplyNo(no);
			vo.setPostNo(postNo);
			vo.setReplyMem(replyMem);
			vo.setCon(con);
			vo.setWriteDate(writeDate);
			
			replyVoList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return replyVoList;
	}//getReplyList
}

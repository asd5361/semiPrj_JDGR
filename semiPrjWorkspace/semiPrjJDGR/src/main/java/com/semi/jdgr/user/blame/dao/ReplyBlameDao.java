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

	
	public ReplyBlameVo getReplyInfo(Connection conn, ReplyBlameVo vo) throws Exception {
		
		//gpt
		String sql = "SELECT R_BLA_LIST, R_BLA_DETAIL FROM REPLY_BLAME WHERE R_NO = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, vo.getrNo());

	    ResultSet rs = pstmt.executeQuery();

	    // rs
	    ReplyBlameVo getReplyInfo = null;
	    while (rs.next()) {
	        String rBlaList = rs.getString("R_BLA_LIST");
	        String rBlaDetail = rs.getString("R_BLA_DETAIL");

	        getReplyInfo = new ReplyBlameVo();
	        getReplyInfo.setrBlaList(rBlaList);
	        getReplyInfo.setrBlaDetail(rBlaDetail);
	    }
	    
	    
	    //close
	    JDBCTemplate.close(pstmt);
	    JDBCTemplate.close(rs);
	    
	    return getReplyInfo;
	    


	}//getReplyInfo
	
	
	public int blame(Connection conn, ReplyBlameVo vo) throws Exception {
		
		// sql
	    String sql = "INSERT INTO REPLY_BLAME (R_BLA_NO, R_NO, R_BLAMER_NO, R_WRITER_NO, R_BLA_CON, R_BLA_LIST, R_BLA_DETAIL) VALUES(SEQ_REPLY_BLAME.NEXTVAL, 1, 2, 3, '신고댓글', ?, ?)";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    
//	    pstmt.setString(1, vo.getrNo());
//	    pstmt.setString(1, vo.getrBlamerNo());
//	    pstmt.setString(1, vo.getrWriterNo());
//	    pstmt.setString(2, vo.getrBlaCon());
	    pstmt.setString(1, vo.getrBlaList());
	    pstmt.setString(2, vo.getrBlaDetail());

//	    System.out.println(vo.getrNo());
//	    System.out.println(vo.getrBlamerNo());
//	    System.out.println(vo.getrWriterNo());
//	    System.out.println(vo.getrBlaCon());
	    System.out.println(vo.getrBlaList());
	    System.out.println(vo.getrBlaDetail());
	    
	    
	    
	    int result = pstmt.executeUpdate();

		// close
		JDBCTemplate.close(pstmt);
		
		return result;		

	}//blame


	//BLA_LIST 불러와서 모달창 띄우기
	public List<ReplyBlameVo> blameList(Connection conn) throws Exception {
		   //SQL
		   String sql = "SELECT * FROM BLAME_REASON";
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   ResultSet rs = pstmt.executeQuery();
		   //rs
		   List<ReplyBlameVo> reasonList = new ArrayList<>();
		   while(rs.next()) {
			   String blaList = rs.getString("BLA_LIST");
			   String blaReason = rs.getString("BLA_REASON");
			   
			   ReplyBlameVo vo = new ReplyBlameVo();
			   vo.setrBlaList(blaList);
			   vo.setrBlamerNo(blaReason);
			   reasonList.add(vo);
		   }
		   
		   //close
		   JDBCTemplate.close(rs);
		   JDBCTemplate.close(pstmt);
		   
		   return reasonList;
	}


	
}//class
   

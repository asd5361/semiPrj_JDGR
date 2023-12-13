package com.semi.jdgr.user.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.user.blame.vo.PostBlameVo;
import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostBlameDao {

	
	public PostBlameVo getPostInfo(Connection conn, PostBlameVo vo) throws Exception {
		
		//gpt
		String sql = "SELECT P_BLA_LIST, P_BLA_DETAIL FROM POST_BLAME WHERE P_NO = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, vo.getpNo());

	    ResultSet rs = pstmt.executeQuery();

	    // rs
	    PostBlameVo getPostInfo = null;
	    while (rs.next()) {
	        String pBlaList = rs.getString("P_BLA_LIST");
	        String pBlaDetail = rs.getString("P_BLA_DETAIL");

	        getPostInfo = new PostBlameVo();
	        getPostInfo.setpBlaList(pBlaList);
	        getPostInfo.setpBlaDetail(pBlaDetail);
	    }
	    
	    
	    //close
	    JDBCTemplate.close(pstmt);
	    JDBCTemplate.close(rs);
	    
	    return getPostInfo;
	    


	}//getPostInfo
	
	
	public int blame(Connection conn, PostBlameVo vo) throws Exception {

		// sql
		String sql = "INSERT INTO POST_BLAME (P_BLA_NO, P_NO, P_BLAMER_NO, P_WRITER_NO, P_BLA_TIT, P_BLA_LIST, P_BLA_DETAIL) VALUES(SEQ_POST_BLAME.NEXTVAL, 1, 1, 1, '제목테스트', ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getpNo());
//		pstmt.setString(2, vo.getpBlamerNo());
//		pstmt.setString(3, vo.getpWriterNo());
//		pstmt.setString(4, vo.getpBlaTit());
		pstmt.setString(1, vo.getpBlaList());
		pstmt.setString(2, vo.getpBlaDetail());
		
	    System.out.println(vo.getpNo());
	    System.out.println(vo.getpBlamerNo());
	    System.out.println(vo.getpWriterNo());
	    System.out.println(vo.getpBlaTit());
	    System.out.println(vo.getpBlaList());
	    System.out.println(vo.getpBlaDetail());
	    
	    
		int result = pstmt.executeUpdate();
		
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;		
		
		
	}//blame
	

	

	//BLA_LIST 불러와서 모달창 띄우기
	public List<PostBlameVo> blameList(Connection conn) throws Exception {
		   //SQL
		   String sql = "SELECT * FROM BLAME_REASON";
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   ResultSet rs = pstmt.executeQuery();
		   //rs
		   List<PostBlameVo> reasonList = new ArrayList<>();
		   while(rs.next()) {
			   String blaList = rs.getString("BLA_LIST");
			   String blaReason = rs.getString("BLA_REASON");
			   
			   PostBlameVo vo = new PostBlameVo();
			   vo.setpBlaList(blaList);
			   vo.setpBlamerNo(blaReason);
			   reasonList.add(vo);
		   }
		   
		   //close
		   JDBCTemplate.close(rs);
		   JDBCTemplate.close(pstmt);
		   
		   return reasonList;
	}

}//class

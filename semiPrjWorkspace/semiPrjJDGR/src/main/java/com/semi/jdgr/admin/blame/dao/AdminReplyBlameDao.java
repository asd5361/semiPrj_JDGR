package com.semi.jdgr.admin.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.admin.blame.vo.AdminBlameCategoryVo;
import com.semi.jdgr.admin.blame.vo.AdminReplyBlameVo;
import com.semi.jdgr.page.vo.AdminBlamePageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminReplyBlameDao {

	   //게시글 목록 조회
	   public List<AdminReplyBlameVo> selectBlameList(Connection conn, AdminBlamePageVo pvo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT RB.R_BLA_NO , RB.R_NO , RB.R_BLAMER_NO , RB.R_WRITER_NO , RB.R_BLA_CON , RB.R_BLA_DATE , RB.R_BLA_LIST , RB.R_SANC_YN , RB.R_ANS_DATE , RB.R_BLA_DETAIL , RB.R_DEL_YN , R.CON , M.MEM_NO AS BLAMER_NO , M.MEM_NO AS WRITER_NO FROM REPLY_BLAME RB JOIN REPLY R ON RB.R_NO = R.REPLY_NO JOIN MEMBER M ON RB.R_BLAMER_NO = M.MEM_NO JOIN MEMBER M ON RB.R_WRITER_NO = M.MEM_NO ORDER BY RB.R_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, pvo.getStartRow());
	      pstmt.setInt(2, pvo.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      
	      //rs
	      List<AdminReplyBlameVo> blameVoList = new ArrayList<AdminReplyBlameVo>();
	      while(rs.next()) {

	    	 String rBlaNo = rs.getString("R_BLA_NO");
	         String rNo = rs.getString("R_NO");
	         String rBlamerNo = rs.getString("R_BLAMER_NO");
	         String rWriterNo = rs.getString("R_WRITER_NO");
	         String rBlaCon = rs.getString("R_BLA_CON");
	         String rBlaDate = rs.getString("R_BLA_DATE");
	         String rBlaList = rs.getString("R_BLA_LIST");
	         String rSancYn = rs.getString("R_SANC_YN");
	         String rAnsDate = rs.getString("R_ANS_DATE");
	         String rBlaDetail = rs.getString("R_BLA_DETAIL");
	         String rDelYn = rs.getString("R_DEL_YN");
	         
	         AdminReplyBlameVo vo = new AdminReplyBlameVo();
	         	vo.setrBlaNo(rBlaNo);
	         	vo.setrNo(rNo);
	         	vo.setrBlamerNo(rBlamerNo);
	         	vo.setrWriterNo(rWriterNo);
	         	vo.setrBlaCon(rBlaCon);
	         	vo.setrBlaDate(rBlaDate);
	         	vo.setrBlaList(rBlaList);
	         	vo.setrSancYn(rSancYn);
	         	vo.setrAnsDate(rAnsDate);
	         	vo.setrBlaDetail(rBlaDetail);
	         	vo.setrDelYn(rDelYn);
	         
	         blameVoList.add(vo);
	         
	      }
	      
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      JDBCTemplate.close(rs);
	      
	      return blameVoList;
	   }//selectBoardList
	   
	   
	   //전체 신고 갯수 조회
	   public int selectBlameCount(Connection conn) throws Exception{
		      
		      //SQL
		      String sql = "SELECT COUNT(*) as cnt FROM REPLY_BLAME";
		      PreparedStatement pstmt = conn.prepareStatement(sql);
		      
		      ResultSet rs = pstmt.executeQuery();
		      
		      //rs
		      int cnt = 0;
		      if(rs.next()) {
//		         int cnt = rs.getInt("cnt");
		         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
		      }
		      
		      //close
		      JDBCTemplate.close(rs);
		      JDBCTemplate.close(pstmt);
		      
		      return cnt;
		         
		   }
	   
	   
	   //신고 항목 리스트 조회
	   public List<AdminBlameCategoryVo> getCategoryList(Connection conn) throws Exception {
		   //SQL
		   String sql = "SELECT * FROM BLAME_REASON ORDER BY BLA_REASON";
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   ResultSet rs = pstmt.executeQuery();
		   //rs
		   List<AdminBlameCategoryVo> voList = new ArrayList<AdminBlameCategoryVo>();
		   while(rs.next()) {
			   String no = rs.getString("NO");
			   String name = rs.getString("NAME");
			   
			   AdminBlameCategoryVo vo = new AdminBlameCategoryVo();
			   vo.setNo(no);
			   vo.setName(name);
			   voList.add(vo);
		   }
		   //close
		   JDBCTemplate.close(rs);
		   JDBCTemplate.close(pstmt);
		   
		   return voList;
	   }//getCategoryList
	   

	 //신고 목록 상세 조회(번호로)
	   public AdminReplyBlameVo selectBlameByNo(Connection conn, String rBlaNo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT RB.R_BLA_NO , RB.R_NO , RB.R_BLA_LIST , RB.R_BLAMER_NO , RB.R_WRITER_NO , RB.R_BLA_CON , RB.R_BLA_DATE , RB.R_SANC_YN , RB.R_ANS_DATE , RB.R_DEL_YN , RB.R_BLA_DETAIL_REASON , R.CON AS BLA_CON , M.MEM_NO AS BLAMER_NO , M.MEM_NO AS WRITER_NO FROM REPLY_BLAME RB JOIN REPLY R ON RB.R_NO = R.REPLY_NO JOIN BLAME_REASON BR ON RB.R_BLA_LIST = BR.BLA_REASON JOIN MEMBER M ON RB.R_BLAMER_NO = M.MEM_NO JOIN MEMBER M ON RB.R_WRITER_NO = M.MEM_NO WHERE RB.R_BLA_NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, rBlaNo);
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      AdminReplyBlameVo vo = null;
	      if(rs.next()) {
	         String rNo = rs.getString("R_NO");
	         String rBlamerNo = rs.getString("R_BLAMER_NO");
	         String rWriterNo = rs.getString("R_WRITER_NO");
	         String rBlaCon = rs.getString("R_BLA_CON");
	         String rBlaDate = rs.getString("R_BLA_DATE");
	         String rBlaList = rs.getString("R_BLA_LIST");
	         String rSancYn = rs.getString("R_SANC_YN");
	         String rAnsDate = rs.getString("R_ANS_DATE");
	         String rBlaDetail = rs.getString("R_BLA_DETAIL");
	         String rDelYn = rs.getString("R_DEL_YN");

     
         	vo.setrBlaNo(rBlaNo);
         	vo.setrNo(rNo);
         	vo.setrBlamerNo(rBlamerNo);
         	vo.setrWriterNo(rWriterNo);
         	vo.setrBlaCon(rBlaCon);
         	vo.setrBlaDate(rBlaDate);
         	vo.setrBlaList(rBlaList);
         	vo.setrSancYn(rSancYn);
         	vo.setrAnsDate(rAnsDate);
         	vo.setrBlaDetail(rBlaDetail);
         	vo.setrDelYn(rDelYn);
	         
	      }
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      return vo;
	   }//selectBlameByNo
	   
	   
	 //신고 검색
		public List<AdminReplyBlameVo> search(Connection conn, Map<String, String> m , AdminBlamePageVo pvo) throws Exception {
			
			String searchType = m.get("searchType");
			
			// SQL
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT RB.R_NO , RB.R_BLA_NO , RB.R_BLAMER_NO , RB.R_WRITER_NO , RB.R_BLA_CON , RB.R_BLA_DATE , RB.R_BLA_LIST , RB.R_SANC_YN , RB.R_ANS_DATE , RB.R_BLA_DETAIL , RB.R_DEL_YN , R.CON , M.MEM_NO AS BLAMER_NO , M.MEM.NO AS WRITER_NO FROM REPLY_BLAME RB JOIN REPLY R ON RB.R_NO = R.REPLY_NO JOIN MEMBER M ON RB.R_BLAMER_NO = M.MEM_NO JOIN MEMBER M ON RB.R_WRITER_NO = M.MEM_NO WHERE \\\" + searchType + \\\" LIKE '%' || ?|| '%' ORDER BY R_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.get("searchValue"));
			pstmt.setInt(2, pvo.getStartRow());
			pstmt.setInt(3, pvo.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			// rs
		      List<AdminReplyBlameVo> blameVoList = new ArrayList<AdminReplyBlameVo>();
		      while(rs.next()) {
		    	 String rBlaNo = rs.getString("R_BLA_NO");
		         String rNo = rs.getString("R_NO");
		         String rBlamerNo = rs.getString("R_BLAMER_NO");
		         String rWriterNo = rs.getString("R_WRITER_NO");
		         String rBlaCon = rs.getString("R_BLA_CON");
		         String rBlaDate = rs.getString("R_BLA_DATE");
		         String rBlaList = rs.getString("R_BLA_LIST");
		         String rSancYn = rs.getString("R_SANC_YN");
		         String rAnsDate = rs.getString("R_ANS_DATE");
		         String rBlaDetail = rs.getString("R_BLA_DETAIL");
		         String rDelYn = rs.getString("R_DEL_YN");
		         
		         AdminReplyBlameVo vo = new AdminReplyBlameVo();
	         	 vo.setrBlaNo(rBlaNo);
	         	 vo.setrNo(rWriterNo);
	         	 vo.setrBlamerNo(rBlamerNo);
	         	 vo.setrWriterNo(rWriterNo);
	         	 vo.setrBlaCon(rBlaCon);
	         	 vo.setrBlaDate(rBlaDate);
	         	 vo.setrBlaList(rBlaList);
	         	 vo.setrSancYn(rSancYn);
	         	 vo.setrAnsDate(rAnsDate);
	         	 vo.setrBlaDetail(rBlaDetail);
	         	 vo.setrDelYn(rDelYn);
		         
		         blameVoList.add(vo);
		      }
		
			// close
		    JDBCTemplate.close(rs);
		    JDBCTemplate.close(pstmt);
		      
		    return blameVoList;
		}//search
		
		
		// 신고 댓글 갯수 조회 (검색값에 따라)
		public int getBlameCountBySearch(Connection conn, Map<String, String> m) throws Exception {
			
			// SQL
			String sql = "SELECT COUNT(*) FROM REPLY_BLAME WHERE " + m.get("searchType") + " LIKE '%' || ? || '%'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.get("searchValue"));
			ResultSet rs = pstmt.executeQuery();
			
			// rs
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			// close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return cnt;
		}

	   
}//class

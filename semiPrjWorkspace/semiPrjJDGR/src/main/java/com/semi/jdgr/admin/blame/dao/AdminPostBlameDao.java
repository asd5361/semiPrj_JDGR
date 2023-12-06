package com.semi.jdgr.admin.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.admin.blame.vo.AdminBlameCategoryVo;
import com.semi.jdgr.admin.blame.vo.AdminPostBlameVo;
import com.semi.jdgr.page.vo.AdminBlamePageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminPostBlameDao {

	   //게시글 목록 조회
	   public List<AdminPostBlameVo> selectBlameList(Connection conn, AdminBlamePageVo pvo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT PB.P_NO , PB.P_BLA_NO , PB.P_BLAMER_NO , PB.P_WRITER_NO , PB.P_BLA_TIT , PB.P_BLA_DATE , PB.P_BLA_LIST , PB.P_SANC_YN , PB.P_ANS_DATE , PB.P_BLA_DETAIL , PB.P_DEL_YN , P.TITLE , M.MEM_NO AS BLAMER_NO , M.MEM_NO AS WRITER_NO FROM POST_BLAME PB JOIN POST P ON PB.P_NO = P.POST_NO JOIN MEMBER M ON PB.P_BLAMER_NO = M.MEM_NO JOIN MEMBER M ON PB.P_WRITER_NO = M.MEM_NO ORDER BY P_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, pvo.getStartRow());
	      pstmt.setInt(2, pvo.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      
	      //rs
	      List<AdminPostBlameVo> blameVoList = new ArrayList<AdminPostBlameVo>();
	      while(rs.next()) {

	    	 String pBlaNo = rs.getString("P_BLA_NO");
	         String pNo = rs.getString("P_NO");
	         String pBlamerNo = rs.getString("P_BLAMER_NO");
	         String pWriterNo = rs.getString("P_WRITER_NO");
	         String pBlaTit = rs.getString("P_BLA_TIT");
	         String pBlaDate = rs.getString("P_BLA_DATE");
	         String pBlaList = rs.getString("P_BLA_LIST");
	         String pSancYn = rs.getString("P_SANC_YN");
	         String pAnsDate = rs.getString("P_ANS_DATE");
	         String pBlaDetail = rs.getString("P_BLA_DETAIL");
	         String pDelYn = rs.getString("P_DEL_YN");
	         
	         AdminPostBlameVo vo = new AdminPostBlameVo();
	         	vo.setpBlaNo(pBlaNo);
	         	vo.setpNo(pNo);
	         	vo.setpBlamerNo(pBlamerNo);
	         	vo.setpWriterNo(pWriterNo);
	         	vo.setpBlaTit(pBlaTit);
	         	vo.setpBlaDate(pBlaDate);
	         	vo.setpBlaList(pBlaList);
	         	vo.setpSancYn(pSancYn);
	         	vo.setpAnsDate(pAnsDate);
	         	vo.setpBlaDetail(pBlaDetail);
	         	vo.setpDelYn(pDelYn);
	         
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
		      String sql = "SELECT COUNT(*) as cnt FROM POST_BLAME";
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
	   public AdminPostBlameVo selectBlameByNo(Connection conn, String pBlaNo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT PB.P_BLA_NO , PB.P_NO , PB.P_BLA_LIST , PB.P_BLAMER_NO , PB.P_WRITER_NO , PB.P_BLA_TIT , PB.P_BLA_DATE , PB.P_SANC_YN , PB.P_ANS_DATE , PB.P_DEL_YN , PB.P_BLA_DETAIL_REASON , P.TITLE AS BLA_TIT , M.MEM_NO AS BLAMER_NO , M.MEM_NO AS WRITER_NO FROM POST_BLAME PB JOIN POST P ON PB.P_NO = P.POST_NO JOIN BLAME_REASON BR ON PB.P_BLA_LIST = BR.BLA_REASON JOIN MEMBER M ON PB.P_BLAMER_NO = M.MEM_NO JOIN MEMBER M ON PB.P_WRITER_NO = M.MEM_NO WHERE PB.P_BLA_NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, pBlaNo);
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      AdminPostBlameVo vo = null;
	      if(rs.next()) {

	         String pNo = rs.getString("P_NO");
	         String pBlamerNo = rs.getString("P_BLAMER_NO");
	         String pWriterNo = rs.getString("P_WRITER_NO");
	         String pBlaTit = rs.getString("P_BLA_TIT");
	         String pBlaDate = rs.getString("P_BLA_DATE");
	         String pBlaList = rs.getString("P_BLA_LIST");
	         String pSancYn = rs.getString("P_SANC_YN");
	         String pAnsDate = rs.getString("P_ANS_DATE");
	         String pBlaDetail = rs.getString("P_BLA_DETAIL");
	         String pDelYn = rs.getString("P_DEL_YN");

	         
	         vo = new AdminPostBlameVo();
         	 vo.setpBlaNo(pBlaNo);
         	 vo.setpNo(pNo);
         	 vo.setpBlamerNo(pBlamerNo);
         	 vo.setpWriterNo(pWriterNo);
         	 vo.setpBlaTit(pBlaTit);
         	 vo.setpBlaDate(pBlaDate);
         	 vo.setpBlaList(pBlaList);
         	 vo.setpSancYn(pSancYn);
         	 vo.setpAnsDate(pAnsDate);
         	 vo.setpBlaDetail(pBlaDetail);
         	 vo.setpDelYn(pDelYn);
	         
	      }
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      return vo;
	   }//selectBlameByNo
	   
	   
	 //신고 검색
		public List<AdminPostBlameVo> search(Connection conn, Map<String, String> m , AdminBlamePageVo pvo) throws Exception {
			
			String searchType = m.get("searchType");
			
			// SQL
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT PB.P_NO , PB.P_BLA_NO , PB.P_BLAMER_NO , PB.P_WRITER_NO , PB.P_BLA_TIT , PB.P_BLA_DATE , PB.P_BLA_LIST , PB.P_SANC_YN , PB.P_ANS_DATE , PB.P_BLA_DETAIL , PB.P_DEL_YN , P.TITLE , M.MEM_NO AS BLAMER_NO , M.MEM.NO AS WRITER_NO FROM POST_BLAME PB JOIN POST P ON PB.P_NO = P.POST_NO JOIN MEMBER M ON PB.P_BLAMER_NO = M.MEM_NO JOIN MEMBER M ON PB.P_WRITER_NO = M.MEM_NO WHERE \\\" + searchType + \\\" LIKE '%' || ?|| '%' ORDER BY P_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.get("searchValue"));
			pstmt.setInt(2, pvo.getStartRow());
			pstmt.setInt(3, pvo.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			// rs
		      List<AdminPostBlameVo> blameVoList = new ArrayList<AdminPostBlameVo>();
		      while(rs.next()) {
		    	 String pBlaNo = rs.getString("P_BLA_NO");
		         String pNo = rs.getString("P_NO");
		         String pBlamerNo = rs.getString("P_BLAMER_NO");
		         String pWriterNo = rs.getString("P_WRITER_NO");
		         String pBlaTit = rs.getString("P_BLA_TIT");
		         String pBlaDate = rs.getString("P_BLA_DATE");
		         String pBlaList = rs.getString("P_BLA_LIST");
		         String pSancYn = rs.getString("P_SANC_YN");
		         String pAnsDate = rs.getString("P_ANS_DATE");
		         String pBlaDetail = rs.getString("P_BLA_DETAIL");
		         String pDelYn = rs.getString("P_DEL_YN");
		         
		         AdminPostBlameVo vo = new AdminPostBlameVo();
	         	 vo.setpBlaNo(pBlaNo);
	         	 vo.setpNo(pNo);
	         	 vo.setpBlamerNo(pBlamerNo);
	         	 vo.setpWriterNo(pWriterNo);
	         	 vo.setpBlaTit(pBlaTit);
	         	 vo.setpBlaDate(pBlaDate);
	         	 vo.setpBlaList(pBlaList);
	         	 vo.setpSancYn(pSancYn);
	         	 vo.setpAnsDate(pAnsDate);
	         	 vo.setpBlaDetail(pBlaDetail);
	         	 vo.setpDelYn(pDelYn);
		         
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
			String sql = "SELECT COUNT(*) FROM POST_BLAME WHERE " + m.get("searchType") + " LIKE '%' || ? || '%'";
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

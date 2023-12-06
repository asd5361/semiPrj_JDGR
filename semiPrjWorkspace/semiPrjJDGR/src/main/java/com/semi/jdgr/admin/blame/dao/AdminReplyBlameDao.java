package com.semi.jdgr.admin.blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.admin.blame.vo.AdminBlameCategoryVo;
import com.semi.jdgr.admin.blame.vo.AdminBlameVo;
import com.semi.jdgr.page.vo.AdminBlamePageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminReplyBlameDao {

	   //게시글 목록 조회
	   public List<AdminBlameVo> selectBlameList(Connection conn, AdminBlamePageVo pvo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO ,B.CATEGORY_NO ,B.TITLE ,B.CONTENT ,B.WRITER_NO ,B.HIT ,B.ENROLL_DATE ,B.MODIFY_DATE ,B.STATUS ,M.NICK AS WRITER_NICK ,C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, pvo.getStartRow());
	      pstmt.setInt(2, pvo.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      
	      //rs
	      List<AdminBlameVo> blameVoList = new ArrayList<AdminBlameVo>();
	      while(rs.next()) {
	         
	    	 String blameNo = rs.getString("BLAME_NO");
	         String replyNo = rs.getString("REPLY_NO");
	         String postNo = rs.getString("POST_NO");
	         String title = rs.getString("TITLE");
	         String con = rs.getString("CON");
	         String blameDate = rs.getString("BLAME_DATE");
	         String blaList = rs.getString("BLA_LIST");
	         String sancYn = rs.getString("SANC_YN");
	         String ansDate = rs.getString("ANS_DATE");
	         String delYn = rs.getString("DEL_YN");
	         String blamerNo = rs.getString("BLAMER_NO");
	         String blamerId = rs.getString("BLAMER_ID");
	         String memNo = rs.getString("MEM_NO");
	         String memId = rs.getString("MEM_ID");

	         
	         AdminBlameVo vo = new AdminBlameVo();
	         vo.setBlameNo(blameNo);
	         vo.setReplyNo(replyNo);
	         vo.setPostNo(postNo);
	         vo.setTitle(title);
	         vo.setCon(con);
	         vo.setBlameDate(blameDate);
	         vo.setBlaList(blaList);
	         vo.setSancYn(sancYn);
	         vo.setAnsDate(ansDate);
	         vo.setDelYn(delYn);
	         vo.setBlamerNo(blamerNo);
	         vo.setBlamerId(blamerId);
	         vo.setMemNo(memNo);
	         vo.setMemId(memId);
	         
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
		      String sql = "SELECT COUNT(*) as cnt FROM BLAME WHERE STATUS = 'O'";
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
		   String sql = "SELECT * FROM CATEGORY ORDER BY NO";
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
	   public AdminBlameVo selectBlameByNo(Connection conn, String no) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM CATEGORY ORDER BY NO";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      AdminBlameVo vo = null;
	      if(rs.next()) {
	    	 String blameNo = rs.getString("BLAME_NO");
	         String replyNo = rs.getString("REPLY_NO");
	         String postNo = rs.getString("POST_NO");
	         String title = rs.getString("TITLE");
	         String con = rs.getString("CON");
	         String blameDate = rs.getString("BLAME_DATE");
	         String blaList = rs.getString("BLA_LIST");
	         String sancYn = rs.getString("SANC_YN");
	         String ansDate = rs.getString("ANS_DATE");
	         String delYn = rs.getString("DEL_YN");
	         String blamerNo = rs.getString("BLAMER_NO");
	         String blamerId = rs.getString("BLAMER_ID");
	         String memNo = rs.getString("MEM_NO");
	         String memId = rs.getString("MEM_ID");

	         
	         vo = new AdminBlameVo();
	         vo.setBlameNo(blameNo);
	         vo.setReplyNo(replyNo);
	         vo.setPostNo(postNo);
	         vo.setTitle(title);
	         vo.setCon(con);
	         vo.setBlameDate(blameDate);
	         vo.setBlaList(blaList);
	         vo.setSancYn(sancYn);
	         vo.setAnsDate(ansDate);
	         vo.setDelYn(delYn);
	         vo.setBlamerNo(blamerNo);
	         vo.setBlamerId(blamerId);
	         vo.setMemNo(memNo);
	         vo.setMemId(memId);
	         
	      }
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      return vo;
	   }//selectBlameByNo
	   
	   
	 //신고 검색
		public List<AdminBlameVo> search(Connection conn, Map<String, String> m , AdminBlamePageVo pvo) throws Exception {
			
			String searchType = m.get("searchType");
			
			// SQL
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO , B.CATEGORY_NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.HIT , B.ENROLL_DATE , B.MODIFY_DATE , B.STATUS , M.NICK AS WRITER_NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' AND " + searchType + " LIKE '%' || ?|| '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.get("searchValue"));
			pstmt.setInt(2, pvo.getStartRow());
			pstmt.setInt(3, pvo.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			// rs
		      List<AdminBlameVo> blameVoList = new ArrayList<AdminBlameVo>();
		      while(rs.next()) {
		    	  String blameNo = rs.getString("BLAME_NO");
		         String replyNo = rs.getString("REPLY_NO");
		         String postNo = rs.getString("POST_NO");
		         String title = rs.getString("TITLE");
		         String con = rs.getString("CON");
		         String blameDate = rs.getString("BLAME_DATE");
		         String blaList = rs.getString("BLA_LIST");
		         String sancYn = rs.getString("SANC_YN");
		         String ansDate = rs.getString("ANS_DATE");
		         String delYn = rs.getString("DEL_YN");
		         String blamerNo = rs.getString("BLAMER_NO");
		         String blamerId = rs.getString("BLAMER_ID");
		         String memNo = rs.getString("MEM_NO");
		         String memId = rs.getString("MEM_ID");
		         
		         AdminBlameVo vo = new AdminBlameVo();
		         vo.setBlameNo(blameNo);
		         vo.setReplyNo(replyNo);
		         vo.setPostNo(postNo);
		         vo.setTitle(title);
		         vo.setCon(con);
		         vo.setBlameDate(blameDate);
		         vo.setBlaList(blaList);
		         vo.setSancYn(sancYn);
		         vo.setAnsDate(ansDate);
		         vo.setDelYn(delYn);
		         vo.setBlamerNo(blamerNo);
		         vo.setBlamerId(blamerId);
		         vo.setMemNo(memNo);
		         vo.setMemId(memId);
		         
		         blameVoList.add(vo);
		      }
		
			// close
		    JDBCTemplate.close(rs);
		    JDBCTemplate.close(pstmt);
		      
		    return blameVoList;
		}//search
		
		
		// 게시글 갯수 조회 (검색값에 따라)
		public int getBlameCountBySearch(Connection conn, Map<String, String> m) throws Exception {
			
			// SQL
			String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O' AND " + m.get("searchType") + " LIKE '%' || ? || '%'";
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

package com.semi.jdgr.post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostDaoLYJ {
   
   //맨 처음에 보이는 전체 리스트 조회
   public List<PostVo> allSelectPostList(Connection conn, PageVo pvo) throws Exception {
      
      //SQL
      String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM ( SELECT M.MEM_NAME ,  B.BLOG_NO , P.POST_NO , CL.CATEGORY_NAME, P.TITLE , P.INQUIRY  ,  P.ENROLL_DATE  , P.MODIFY_DATE  , P.DEL_YN FROM POST P JOIN BLOG  B ON  P .POST_NO = B .BLOG_NO JOIN CATEGORY_LIST CL ON CL.CATEGORY_NO = P.CATEGORY_NO JOIN MEMBER M ON M.MEM_NO = B.MEM_NO WHERE DEL_YN = 'N' ORDER BY B.BLOG_NO ASC ) T ) WHERE RNUM BETWEEN ? AND ? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1,pvo.getStartRow());
      pstmt.setInt(2,pvo.getLastRow());
      ResultSet rs = pstmt.executeQuery();
      
      //rs
      List<PostVo> postVoList = new ArrayList<PostVo>();
      while(rs.next()) {
         
         String memName = rs.getString("MEM_NAME");//작성자
         String blogNo = rs.getString("BLOG_NO");//블로그 번호
         String postNo = rs.getString("POST_NO");//포스트 번호
           String categoryName = rs.getString("CATEGORY_NAME");//카테고리명
           String title = rs.getString("TITLE");//제목
           String inquiry = rs.getString("INQUIRY");//조회수


           String enrollDate = rs.getString("ENROLL_DATE");//등록일자
           String modifyDate = rs.getString("MODIFY_DATE");//수정일자
           String delYn = rs.getString("DEL_YN");//공개여부
           
                                 
           PostVo postVo = new PostVo();
           postVo.setMemName(memName);
           postVo.setBlogNo(blogNo);
           postVo.setPostNo(postNo);
           postVo.setCategoryNo(categoryName);
           postVo.setTitle(title);
           postVo.setInquiry(inquiry);


           postVo.setEnrollDate(enrollDate);
           postVo.setModifyDate(modifyDate);
           postVo.setOpen(delYn);
           
           postVoList.add(postVo);
           
      }
           //close
           JDBCTemplate.close(pstmt);
           JDBCTemplate.close(rs);
           
           return postVoList;
      
   }//allSelectPostList
   
   
   public String getheartCnt(Connection conn, PostVo postVo) throws Exception {
      //SQL
       String sql3 = "SELECT COUNT(H.POST_NO) AS HEARTCNT FROM HEART H JOIN POST P ON P.POST_NO = H.POST_NO";
        PreparedStatement pstmt3 = conn.prepareStatement(sql3);        
        ResultSet rs3 = pstmt3.executeQuery();
        
      //rs
        String heartCnt = null;//공감수        
        if(rs3.next()) {
           heartCnt = rs3.getString("HEARTCNT");//공감수
        }
        PostVo vo = new PostVo();
        vo.setHeartCnt(heartCnt);
        
       //close
       JDBCTemplate.close(pstmt3);
       JDBCTemplate.close(rs3);
       return heartCnt;
    }
   
    public String getreplyCnt(Connection conn, PostVo postVo) throws Exception {
      //SQL
       String sql2 = "SELECT COUNT(R.REPLY_NO) AS REPLYCNT FROM REPLY R JOIN POST P ON P.POST_NO = R.POST_NO";
       PreparedStatement pstmt2 = conn.prepareStatement(sql2);
       ResultSet rs2 = pstmt2.executeQuery();
      
       //rs
       String replyCnt = null;//댓글수         
       if(rs2.next()) {
          replyCnt = rs2.getString("REPLYCNT");//댓글수
       }
       PostVo vo = new PostVo();
       vo.setReplyCnt(replyCnt);           
       
      //close
       JDBCTemplate.close(pstmt2);
       JDBCTemplate.close(rs2);
      return replyCnt;
    }
   

   
   
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //포스트 관리 목록 조회(관리자)
   public List<PostVo> selectPostList(Connection conn, String memName) throws Exception {
      
      //SQL
      String sql = "SELECT M.MEM_NAME ,  B.BLOG_NO , P.POST_NO , CL.CATEGORY_NAME, P.TITLE , P.INQUIRY  ,  P.ENROLL_DATE  , P.MODIFY_DATE  , P.DEL_YN  FROM POST P JOIN BLOG  B ON  P .POST_NO = B .BLOG_NO JOIN CATEGORY_LIST CL ON CL.CATEGORY_NO = P.CATEGORY_NO JOIN MEMBER M ON M.MEM_NO = B.MEM_NO WHERE MEM_NAME = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memName);
      ResultSet rs = pstmt.executeQuery();
      
      //rs
      List<PostVo> postVoList = new ArrayList<PostVo>();
      while(rs.next()) {
         
         String memName1 = rs.getString("MEM_NAME");//작성자
         String blogNo = rs.getString("BLOG_NO");//블로그 번호
         String postNo = rs.getString("POST_NO");//포스트 번호
           String categoryName = rs.getString("CATEGORY_NAME");//카테고리명
           String title = rs.getString("TITLE");//제목
           String inquiry = rs.getString("INQUIRY");//조회수


           String enrollDate = rs.getString("ENROLL_DATE");//등록일자
           String modifyDate = rs.getString("MODIFY_DATE");//수정일자
           String delYn = rs.getString("DEL_YN");//공개여부
           
                                 
           PostVo postVo = new PostVo();
           postVo.setMemName(memName1);
           postVo.setBlogNo(blogNo);
           postVo.setPostNo(postNo);
           postVo.setCategoryNo(categoryName);
           postVo.setTitle(title);
           postVo.setInquiry(inquiry);


           postVo.setEnrollDate(enrollDate);
           postVo.setModifyDate(modifyDate);
           postVo.setOpen(delYn);
           
           postVoList.add(postVo);
           
      }
           //close
           JDBCTemplate.close(pstmt);
           JDBCTemplate.close(rs);
           
           return postVoList;
           
      }
   
    
    public String getheartCnt(Connection conn, String postNo) throws Exception {
      //SQL
       String sql3 = "SELECT COUNT(H.POST_NO) AS HEARTCNT FROM HEART H JOIN POST P ON P.POST_NO = H.POST_NO WHERE P.POST_NO = ?";
        PreparedStatement pstmt3 = conn.prepareStatement(sql3);        
        pstmt3.setString(1,postNo);
        ResultSet rs3 = pstmt3.executeQuery();
        
      //rs
        String heartCnt = null;//공감수        
        if(rs3.next()) {
           heartCnt = rs3.getString("HEARTCNT");//공감수
        }
        PostVo vo = new PostVo();
        vo.setHeartCnt(heartCnt);
        
       //close
       JDBCTemplate.close(pstmt3);
       JDBCTemplate.close(rs3);
       return heartCnt;
    }
   
    public String getreplyCnt(Connection conn, String postNo) throws Exception {
      //SQL
       String sql2 = "SELECT COUNT(R.REPLY_NO) AS REPLYCNT FROM REPLY R JOIN POST P ON P.POST_NO = R.POST_NO WHERE P.POST_NO = ? ";
       PreparedStatement pstmt2 = conn.prepareStatement(sql2);
       pstmt2.setString(1,postNo);
       ResultSet rs2 = pstmt2.executeQuery();
      
       //rs
       String replyCnt = null;//댓글수         
       if(rs2.next()) {
          replyCnt = rs2.getString("REPLYCNT");//댓글수
       }
       PostVo vo = new PostVo();
       vo.setReplyCnt(replyCnt);           
       
      //close
       JDBCTemplate.close(pstmt2);
       JDBCTemplate.close(rs2);
      return replyCnt;
    }

    
   // 게시글 갯수 조회(맨 처음에 보이는 전체 리스트 조회)
   public int selectPostCount(Connection conn) throws Exception {
      // SQL
      String sql = "SELECT COUNT(*) FROM POST";
      PreparedStatement pstmt = conn.prepareStatement(sql);
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
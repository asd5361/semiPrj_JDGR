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

	//포스트 관리 목록 조회(관리자)
	public List<PostVo> selectPostList(Connection conn, PostVo postVo) throws Exception {
		
		//SQL
		String sql = "SELECT M.MEM_NAME ,  B.BLOG_NO , P.POST_NO , CL.CATEGORY_NAME, P.TITLE , P.INQUIRY  ,  P.ENROLL_DATE  , P.MODIFY_DATE  , P.DEL_YN  FROM POST P JOIN BLOG  B ON  P .POST_NO = B .BLOG_NO JOIN CATEGORY_LIST CL ON CL.CATEGORY_NO = P.CATEGORY_NO JOIN MEMBER M ON M.MEM_NO = B.MEM_NO WHERE MEM_NAME = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "박범렬");
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<PostVo> postVoList = new ArrayList<PostVo>();
		while(rs.next()) {
			
			String userNick = rs.getString("MEM_NAME");//작성자
			String blogNo = rs.getString("BLOG_NO");//블로그 번호
			String postNo = rs.getString("POST_NO");//포스트 번호
	        String categoryName = rs.getString("CATEGORY_NAME");//카테고리명
	        String title = rs.getString("TITLE");//제목
	        String inquiry = rs.getString("INQUIRY");//조회수
//	        String heartCnt = rs.getString("POST_NO");//공감수
//	        String replyCnt = rs.getString("POST_NO");//댓글수
	        String enrollDate = rs.getString("ENROLL_DATE");//등록일자
	        String modifyDate = rs.getString("MODIFY_DATE");//수정일자
	        String delYn = rs.getString("DEL_YN");//공개여부
	        
	        
	        
//	        String sql2 = "SELECT COUNT(REPLY_NO) AS REPLYCNT FROM REPLY R JOIN POST P ON P.POST_NO = R.POST_NO WHERE P.POST_NO = ? ";
//	        PreparedStatement pstmt2 = conn.prepareStatement(sql);
//			pstmt.setString(1,postNo);
//			
//	        ResultSet rs2 = pstmt.executeQuery();
//	        String replyCnt = null;
//	        if(rs2.next()) {
//	        	replyCnt = rs.getString("REPLYCNT");//블로그 번호
//	        }
	        
	        
//	        String sql3 = "SELECT COUNT(REPLY_NO) AS HEARTCNT FROM HEART H JOIN POST P ON P.POST_NO = H.POST_NO WHERE P.POST_NO = ?";
//	        PreparedStatement pstmt3 = conn.prepareStatement(sql);
//	        pstmt.setString(1,postNo);
//	        
//	        ResultSet rs3 = pstmt.executeQuery();
//	        String heartCnt = null;
//	        if(rs3.next()) {
//	        	heartCnt = rs.getString("HEARTCNT");//블로그 번호
//	        }
	        
	        	        
	        PostVo vo = new PostVo();
	        vo.setUserNick(userNick);
	        vo.setBlogNo(blogNo);
	        vo.setPostNo(postNo);
	        vo.setCategoryNo(categoryName);
	        vo.setTitle(title);
	        vo.setInquiry(inquiry);
//	        vo.setHeartCnt(heartCnt);
//	        vo.setReplyCnt(replyCnt);
	        vo.setEnrollDate(enrollDate);
	        vo.setModifyDate(modifyDate);
	        vo.setOpen(delYn);
	        
	        postVoList.add(vo);
	        
		}
	        //close
	        JDBCTemplate.close(pstmt);
	        JDBCTemplate.close(rs);
	        
	        return postVoList;
	        
		}

	
//	//전체 게시글 갯수 조회(관리자)
//	public int selectPostCount(Connection conn, Map<String, String> p) throws Exception{
//		
//			
//			// SQL
//			String sql = "SELECT COUNT(*) FROM POST WHERE OPEN = 'Y' AND " + p.get("searchType") + " LIKE '%' || ? || '%'";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, p.get("searchValue"));
//			ResultSet rs = pstmt.executeQuery();
//			
//			// rs
//			int cnt = 0;
//			if(rs.next()) {
//				cnt = rs.getInt(1);
//			}
//			
//			// close
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//			
//			return cnt;
//	}
	

}//class

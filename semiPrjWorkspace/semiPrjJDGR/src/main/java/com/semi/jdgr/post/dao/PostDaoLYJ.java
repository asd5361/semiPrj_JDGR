package com.semi.jdgr.post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostDaoLYJ {

	//포스트 관리 목록 조회(관리자)
	public List<PostVo> selectPostList(Connection conn, PageVo pvo) throws Exception {
		
		//SQL
		String sql = "SELECT M.MEM_NAME AS 작성자,  B.BLOG_NO AS 블로그번호, P.POST_NO AS 포스트번호, CL.CATEGORY_NAME AS 카테고리명, P.TITLE AS 제목, P.INQUIRY  AS 조회수, H.POST_NO AS 공감수, R.POST_NO  AS 댓글수,  P.ENROLL_DATE  AS 등록일자, P.MODIFY_DATE  AS 수정일자, P.DEL_YN  AS 공개여부 FROM POST P JOIN BLOG  B ON  P .POST_NO = B .BLOG_NO JOIN CATEGORY_LIST CL ON CL.CATEGORY_NO = P.CATEGORY_NO JOIN MEMBER M ON M.MEM_NO = B.MEM_NO JOIN HEART H ON H.POST_NO = P.POST_NO JOIN REPLY R ON R.POST_NO = P.POST_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<PostVo> postVoList = new ArrayList<PostVo>();
		while(rs.next()) {
			
			String userNick = rs.getString("MEM_NAME");//작성자
			String blogNo = rs.getString("BLOG_NO");//블로그 번호
			String postNo = rs.getString("POST_NO");//포스트 번호
	        String categoryNo = rs.getString("CATEGORY_NO");//카테고리명
	        String title = rs.getString("TITLE");//제목
	        String inquiry = rs.getString("INQUIRY");//조회수
//	        String heartCnt = rs.getString("");//공감수
//	        String replyCnt = rs.getString("");//댓글수
	        String enrollDate = rs.getString("ENROLL_DATE");//등록일자
	        String modifyDate = rs.getString("MODIFY_DATE");//수정일자
	        String open = rs.getString("OPEN");//공개여부
	        
	        PostVo vo = new PostVo();
	        vo.setUserNick(userNick);
	        vo.setBlogNo(blogNo);
	        vo.setPostNo(postNo);
	        vo.setCategoryNo(categoryNo);
	        vo.setTitle(title);
	        vo.setInquiry(inquiry);
	        vo.setEnrollDate(enrollDate);
	        vo.setModifyDate(modifyDate);
	        vo.setOpen(open);
	         
	        postVoList.add(vo);
	        
		}
	        //close
	        JDBCTemplate.close(pstmt);
	        JDBCTemplate.close(rs);
	        
	        return postVoList;
	        
		}

	
	//전체 게시글 갯수 조회(관리자)
	public int selectBoardCount(Connection conn) {
		public int getBoardCountBySearch(Connection conn, Map<String, String> m) throws Exception {
			
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


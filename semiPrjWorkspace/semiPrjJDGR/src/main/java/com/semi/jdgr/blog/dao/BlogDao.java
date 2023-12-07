package com.semi.jdgr.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.blog.vo.GroupVo;
import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class BlogDao {

	// 블로그 url 정보 가져오기
	public BlogVo getUserBlog(Connection conn, String getBlogUrl) throws Exception {

		// sql
		String sql = "SELECT * FROM BLOG B JOIN MEMBER M ON B.MEM_NO = M.MEM_NO WHERE B.BLOG_URL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, getBlogUrl);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		BlogVo blogUrlVo = null;
		if(rs.next()) {
			
			String blogNo = rs.getString("BLOG_NO");
			String memNo = rs.getString("MEM_NO");
			String blogTitle = rs.getString("BLOG_TITLE");
			String openYn = rs.getString("OPEN_YN");
			String layout = rs.getString("LAYOUT");
			String skin = rs.getString("SKIN");
			String clockYn = rs.getString("CLOCK_YN");
			String mapYn = rs.getString("MAP_YN");
			String rCommentsYn = rs.getString("R_COMMENTS_YN");
			String followBlogYn = rs.getString("FOLLOW_BLOG_YN");
			String visitorsCntYn = rs.getString("VISITORS_CNT_YN");
			String blogImg = rs.getString("BLOG_IMG");
			String rComments = rs.getString("R_COMMENTS");
			String visitCnt = rs.getString("VISIT_CNT");
			String blogMain = rs.getString("BLOG_MAIN");
			String repYn = rs.getString("REP_YN");
			String blogUrl = rs.getString("BLOG_URL");
			String memNick = rs.getString("MEM_NICK");
			String memId = rs.getString("MEM_ID");
			
			blogUrlVo = new BlogVo();
			blogUrlVo.setBlogNo(blogNo);
			blogUrlVo.setMemNo(memNo);
			blogUrlVo.setMemNick(memNick);
			blogUrlVo.setMemId(memId);
			blogUrlVo.setBlogTitle(blogTitle);
			blogUrlVo.setOpenYn(openYn);
			blogUrlVo.setLayout(layout);
			blogUrlVo.setSkin(skin);
			blogUrlVo.setClockYn(clockYn);
			blogUrlVo.setMapYn(mapYn);
			blogUrlVo.setrCommentsYn(rCommentsYn);
			blogUrlVo.setFollowBlogYn(followBlogYn);
			blogUrlVo.setVisitorsCntYn(visitorsCntYn);
			blogUrlVo.setBlogImg(blogImg);
			blogUrlVo.setrComments(rComments);
			blogUrlVo.setVisitCnt(visitCnt);
			blogUrlVo.setBlogMain(blogMain);
			blogUrlVo.setRepYn(repYn);
			blogUrlVo.setBlogUrl(blogUrl);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return blogUrlVo;
	}

	// 카테고리 그룹 가져오기
	public List<GroupVo> getGroupList(Connection conn, BlogVo blogVo) throws Exception {
		
		// sql
		String sql = "SELECT * FROM MYBLOG_CATEGORY MC JOIN BLOG B ON B.BLOG_NO = MC.BLOG_NO WHERE B.BLOG_NO = ? ORDER BY MC.GROUP_ORDER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getBlogNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<GroupVo> groupVoList = new ArrayList<GroupVo>();
		while(rs.next()) {
			String groupNo = rs.getString("GROUP_NO");
			String groupName = rs.getString("GROUP_NAME");
			
			GroupVo vo = new GroupVo();
			vo.setNo(groupNo);
			vo.setName(groupName);
			
			groupVoList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return groupVoList;
	}

	// 블로그 리스트 가져오기
	public List<BlogVo> getBlogList(Connection conn, MemberVo memberVo) throws Exception {
		
		// sql
		String sql = "SELECT * FROM BLOG B JOIN MEMBER M ON B.MEM_NO = M.MEM_NO WHERE M.MEM_NO = ? ORDER BY B.BLOG_NO ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberVo.getMemNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BlogVo> blogVoList = new ArrayList<BlogVo>();
		while(rs.next()) {
			String blogNo = rs.getString("BLOG_NO");
			String memNo = rs.getString("MEM_NO");
			String blogTitle = rs.getString("BLOG_TITLE");
			String openYn = rs.getString("OPEN_YN");
			String layout = rs.getString("LAYOUT");
			String skin = rs.getString("SKIN");
			String clockYn = rs.getString("CLOCK_YN");
			String mapYn = rs.getString("MAP_YN");
			String rCommentsYn = rs.getString("R_COMMENTS_YN");
			String followBlogYn = rs.getString("FOLLOW_BLOG_YN");
			String visitorsCntYn = rs.getString("VISITORS_CNT_YN");
			String blogImg = rs.getString("BLOG_IMG");
			String rComments = rs.getString("R_COMMENTS");
			String visitCnt = rs.getString("VISIT_CNT");
			String blogMain = rs.getString("BLOG_MAIN");
			String repYn = rs.getString("REP_YN");
			String blogUrl = rs.getString("BLOG_URL");
			
			BlogVo blogVo = new BlogVo();
			blogVo.setBlogNo(blogNo);
			blogVo.setMemNo(memNo);
			blogVo.setBlogTitle(blogTitle);
			blogVo.setOpenYn(openYn);
			blogVo.setLayout(layout);
			blogVo.setSkin(skin);
			blogVo.setClockYn(clockYn);
			blogVo.setMapYn(mapYn);
			blogVo.setrCommentsYn(rCommentsYn);
			blogVo.setFollowBlogYn(followBlogYn);
			blogVo.setVisitorsCntYn(visitorsCntYn);
			blogVo.setBlogImg(blogImg);
			blogVo.setrComments(rComments);
			blogVo.setVisitCnt(visitCnt);
			blogVo.setBlogMain(blogMain);
			blogVo.setRepYn(repYn);
			blogVo.setBlogUrl(blogUrl);
			
			blogVoList.add(blogVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return blogVoList;
	}

	// 대표블로그 가져오기
	public BlogVo getUserReqBlog(Connection conn, MemberVo memberVo) throws Exception {
		// sql
		String sql = "SELECT * FROM BLOG B JOIN MEMBER M ON B.MEM_NO = M.MEM_NO WHERE M.MEM_NO = ? AND B.REP_YN = 'Y'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberVo.getMemNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		BlogVo blogVo = null;
		if(rs.next()) {
			
			String blogNo = rs.getString("BLOG_NO");
			String memNo = rs.getString("MEM_NO");
			String blogTitle = rs.getString("BLOG_TITLE");
			String openYn = rs.getString("OPEN_YN");
			String layout = rs.getString("LAYOUT");
			String skin = rs.getString("SKIN");
			String clockYn = rs.getString("CLOCK_YN");
			String mapYn = rs.getString("MAP_YN");
			String rCommentsYn = rs.getString("R_COMMENTS_YN");
			String followBlogYn = rs.getString("FOLLOW_BLOG_YN");
			String visitorsCntYn = rs.getString("VISITORS_CNT_YN");
			String blogImg = rs.getString("BLOG_IMG");
			String rComments = rs.getString("R_COMMENTS");
			String visitCnt = rs.getString("VISIT_CNT");
			String blogMain = rs.getString("BLOG_MAIN");
			String repYn = rs.getString("REP_YN");
			String blogUrl = rs.getString("BLOG_URL");
			
			blogVo = new BlogVo();
			blogVo.setBlogNo(blogNo);
			blogVo.setMemNo(memNo);
			blogVo.setBlogTitle(blogTitle);
			blogVo.setOpenYn(openYn);
			blogVo.setLayout(layout);
			blogVo.setSkin(skin);
			blogVo.setClockYn(clockYn);
			blogVo.setMapYn(mapYn);
			blogVo.setrCommentsYn(rCommentsYn);
			blogVo.setFollowBlogYn(followBlogYn);
			blogVo.setVisitorsCntYn(visitorsCntYn);
			blogVo.setBlogImg(blogImg);
			blogVo.setrComments(rComments);
			blogVo.setVisitCnt(visitCnt);
			blogVo.setBlogMain(blogMain);
			blogVo.setRepYn(repYn);
			blogVo.setBlogUrl(blogUrl);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return blogVo;
	}

	// 대표블로그 수정하기
	public int editBlogRep(Connection conn, BlogVo blogVo) throws Exception {

		// sql
		String sql = "UPDATE BLOG SET REP_YN = CASE WHEN BLOG_URL = ? THEN 'Y' ELSE 'N' END WHERE MEM_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getBlogUrl());
		pstmt.setString(2, blogVo.getMemNo());
		
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 블로그 만들기
	public int createBlog(Connection conn, BlogVo blogVo) throws Exception {

		// sql
		String sql = "INSERT INTO BLOG ( BLOG_NO , MEM_NO , BLOG_IMG , BLOG_TITLE , BLOG_URL ) VALUES ( SEQ_BLOG_NO.NEXTVAL , ? , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getMemNo());
		pstmt.setString(2, blogVo.getBlogImg());
		pstmt.setString(3, blogVo.getBlogTitle());
		pstmt.setString(4, blogVo.getBlogUrl());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 모든 블로그 정보 리스트 가져오기
	public List<BlogVo> getBlogAllList(Connection conn) throws Exception {

		// sql
		String sql = "SELECT * FROM BLOG";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BlogVo> blogVoList = new ArrayList<BlogVo>();
		while(rs.next()) {
			String blogNo = rs.getString("BLOG_NO");
			String memNo = rs.getString("MEM_NO");
			String blogTitle = rs.getString("BLOG_TITLE");
			String openYn = rs.getString("OPEN_YN");
			String layout = rs.getString("LAYOUT");
			String skin = rs.getString("SKIN");
			String clockYn = rs.getString("CLOCK_YN");
			String mapYn = rs.getString("MAP_YN");
			String rCommentsYn = rs.getString("R_COMMENTS_YN");
			String followBlogYn = rs.getString("FOLLOW_BLOG_YN");
			String visitorsCntYn = rs.getString("VISITORS_CNT_YN");
			String blogImg = rs.getString("BLOG_IMG");
			String rComments = rs.getString("R_COMMENTS");
			String visitCnt = rs.getString("VISIT_CNT");
			String blogMain = rs.getString("BLOG_MAIN");
			String repYn = rs.getString("REP_YN");
			String blogUrl = rs.getString("BLOG_URL");
			
			BlogVo blogVo = new BlogVo();
			blogVo.setBlogNo(blogNo);
			blogVo.setMemNo(memNo);
			blogVo.setBlogTitle(blogTitle);
			blogVo.setOpenYn(openYn);
			blogVo.setLayout(layout);
			blogVo.setSkin(skin);
			blogVo.setClockYn(clockYn);
			blogVo.setMapYn(mapYn);
			blogVo.setrCommentsYn(rCommentsYn);
			blogVo.setFollowBlogYn(followBlogYn);
			blogVo.setVisitorsCntYn(visitorsCntYn);
			blogVo.setBlogImg(blogImg);
			blogVo.setrComments(rComments);
			blogVo.setVisitCnt(visitCnt);
			blogVo.setBlogMain(blogMain);
			blogVo.setRepYn(repYn);
			blogVo.setBlogUrl(blogUrl);
			
			blogVoList.add(blogVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return blogVoList;
	}

	// 블로그 정보 수정
	public int editInfo(Connection conn, BlogVo blogVo) throws Exception {

		// sql
		String sql = "UPDATE BLOG SET BLOG_TITLE = ? , BLOG_IMG = ? WHERE BLOG_URL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getBlogTitle());
		pstmt.setString(2, blogVo.getBlogImg());
		pstmt.setString(3, blogVo.getBlogUrl());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 이미지 업데이트 안하는 정보 수정
	public int editImgNoInfo(Connection conn, BlogVo blogVo) throws Exception {
		// sql
		String sql = "UPDATE BLOG SET BLOG_TITLE = ? WHERE BLOG_URL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getBlogTitle());
		pstmt.setString(2, blogVo.getBlogUrl());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 블로그 레이아웃 정보 수정
	public int editLayout(Connection conn, BlogVo blogVo) throws Exception {

		// sql
		String sql = "UPDATE BLOG SET LAYOUT = ? , CLOCK_YN = ? , MAP_YN = ? , R_COMMENTS_YN = ? , FOLLOW_BLOG_YN = ? , VISITORS_CNT_YN = ? WHERE BLOG_URL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getLayout());
		pstmt.setString(2, blogVo.getClockYn());
		pstmt.setString(3, blogVo.getMapYn());
		pstmt.setString(4, blogVo.getrCommentsYn());
		pstmt.setString(5, blogVo.getFollowBlogYn());
		pstmt.setString(6, blogVo.getVisitorsCntYn());
		pstmt.setString(7, blogVo.getBlogUrl());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 블로그 스킨 정보 수정
	public int editSkin(Connection conn, BlogVo blogVo) throws Exception {

		// sql
		String sql = "UPDATE BLOG SET SKIN = ? WHERE BLOG_URL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, blogVo.getSkin());
		pstmt.setString(2, blogVo.getBlogUrl());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}

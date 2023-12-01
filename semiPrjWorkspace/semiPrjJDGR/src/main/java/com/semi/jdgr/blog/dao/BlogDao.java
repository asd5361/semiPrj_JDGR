package com.semi.jdgr.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.user.member.vo.MemberVo;

public class BlogDao {

	// 블로그 정보 가져오기
	public BlogVo getUserBlog(Connection conn, MemberVo memberVo) throws Exception {

		// sql 1130 블로그테이블,유저테이블,url테이블만 join함 
		// 나중에 카테고리, 포스트, 댓글 가져와야됨
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
		
		return blogVo;
	}

}

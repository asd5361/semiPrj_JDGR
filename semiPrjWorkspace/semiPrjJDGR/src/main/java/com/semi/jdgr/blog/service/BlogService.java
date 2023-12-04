package com.semi.jdgr.blog.service;

import java.sql.Connection;
import java.util.List;

import com.semi.jdgr.blog.dao.BlogDao;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.blog.vo.GroupVo;
import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class BlogService {

	// url에 맞는 블로그 정보 가져오기
	public BlogVo getUserblog(MemberVo loginMemberVo, String getBlogUrl) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		//if(대표블로그면..url ) {} else {대표블로그 아니면}
		BlogVo blogUrlVo = dao.getUserBlog(conn, loginMemberVo, getBlogUrl);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogUrlVo;
	}
	
	// 대표블로그 정보 가져오기
	public BlogVo getUserReqblog(MemberVo memberVo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		BlogVo blogVo = dao.getUserReqBlog(conn, memberVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogVo;
	}
	
	// 카테고리 그룹정보 가져오기
	public List<GroupVo> getGroupList(BlogVo blogVo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		List<GroupVo> groupVoList = dao.getGroupList(conn, blogVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return groupVoList;
	}

	// 블로그 리스트 가져오기
	public List<BlogVo> getBlogList(MemberVo memberVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		List<BlogVo> blogVoList = dao.getBlogList(conn, memberVo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blogVoList;
	}

	// 대표 블로그 수정하기
	public int editBlogRep(BlogVo blogVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BlogDao dao = new BlogDao();
		int result = dao.editBlogRep(conn, blogVo);
		
		// tx
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 블로그 만들기
	public int createBlog(BlogVo blogVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// 비즈니스 로직 (검증로직 해야됨!!!!!!!!!!!!!)
		
		// dao
		BlogDao dao = new BlogDao();
		int result = dao.createBlog(conn, blogVo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}

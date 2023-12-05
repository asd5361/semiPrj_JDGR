package com.semi.jdgr.post.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.post.dao.PostDaoLYJ;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceLYJ {

	//포스트 관리 목록 조회(관리자)
	public List<PostVo> selectPostList(PageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoLYJ dao = new PostDaoLYJ();
		List<PostVo> postVoList = dao.selectPostList(conn, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return postVoList;
	
	}//selectPostList
	
	
	//전체 게시글 갯수 조회(관리자)
	public int selectPostCount(Map<String, String> p) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		PostDaoLYJ dao = new PostDaoLYJ();
		int cnt = dao.selectPostCount(conn, p);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}//selectPostCount
	
	
	

}//class

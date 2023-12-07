package com.semi.jdgr.admin.blame.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.admin.blame.dao.AdminPostBlameDao;
import com.semi.jdgr.admin.blame.vo.AdminBlameCategoryVo;
import com.semi.jdgr.admin.blame.vo.AdminPostBlameVo;
import com.semi.jdgr.page.vo.AdminBlamePageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminPostBlameService {

	// 신고 목록 조회
	public List<AdminPostBlameVo> selectBlameList(AdminBlamePageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminPostBlameDao dao = new AdminPostBlameDao();
		List<AdminPostBlameVo> blameVoList = dao.selectBlameList(conn, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blameVoList;
		
	}//selectBlameList
	
	
	// 전체 신고 갯수 조회
	public int selectBlameCount() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminPostBlameDao dao = new AdminPostBlameDao();
		int cnt = dao.selectBlameCount(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}//selectBlameCount
	
	
	//신고 항목 리스트 조회(카테고리)
	public List<AdminBlameCategoryVo> getCategoryList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminPostBlameDao dao = new AdminPostBlameDao();
		List<AdminBlameCategoryVo> voList = dao.getCategoryList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}//getCategoryList
	
	
	//신고 목록 상세조회
	public AdminPostBlameVo selectBlameByNo(String pBlaNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminPostBlameDao dao = new AdminPostBlameDao();
		AdminPostBlameVo vo = dao.selectBlameByNo(conn, pBlaNo);

		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}//selectBlameByNo
	
	
	// 신고 목록 검색
	public List<AdminPostBlameVo> search(Map<String, String> m , AdminBlamePageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		AdminPostBlameDao dao = new AdminPostBlameDao();
		List<AdminPostBlameVo> blameVoList = dao.search(conn , m, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return blameVoList;
	}//search
	
	
	// 게시글 갯수 조회 (검색값에 따라)
	public int selectSearchBlameCount(Map<String, String> m) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		AdminPostBlameDao dao = new AdminPostBlameDao();
		int cnt = dao.getBlameCountBySearch(conn , m);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	
	
	
}//class

//상세조회 해서 답변 작성하고 저장하는 것....

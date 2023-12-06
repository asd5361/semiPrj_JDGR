package com.semi.jdgr.admin.blame.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.admin.blame.dao.AdminReplyBlameDao;
import com.semi.jdgr.admin.blame.vo.AdminBlameCategoryVo;
import com.semi.jdgr.admin.blame.vo.AdminBlameVo;
import com.semi.jdgr.page.vo.AdminBlamePageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminReplyBlameService {

	// 신고 목록 조회
	public List<AdminBlameVo> selectBlameList(AdminBlamePageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminReplyBlameDao dao = new AdminReplyBlameDao();
		List<AdminBlameVo> blameVoList = dao.selectBlameList(conn, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return blameVoList;
		
	}//selectBoardList
	
	
	// 전체 신고 갯수 조회
	public int selectBlameCount() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminReplyBlameDao dao = new AdminReplyBlameDao();
		int cnt = dao.selectBlameCount(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}//selectBoardCount
	
	
	//신고 항목 리스트 조회(카테고리)
	public List<AdminBlameCategoryVo> getCategoryList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminReplyBlameDao dao = new AdminReplyBlameDao();
		List<AdminBlameCategoryVo> voList = dao.getCategoryList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}//getCategoryList
	
	
	//신고 목록 상세조회
	public AdminBlameVo selectBlameByNo(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminReplyBlameDao dao = new AdminReplyBlameDao();
		AdminBlameVo vo = dao.selectBlameByNo(conn, no);

		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}//selectBlameByNo
	
	
	// 신고 목록 검색
	public List<AdminBlameVo> search(Map<String, String> m , AdminBlamePageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		AdminReplyBlameDao dao = new AdminReplyBlameDao();
		List<AdminBlameVo> blameVoList = dao.search(conn , m, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return blameVoList;
	}//search
	
	
	// 게시글 갯수 조회 (검색값에 따라)
	public int selectSearchBlameCount(Map<String, String> m) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		AdminReplyBlameDao dao = new AdminReplyBlameDao();
		int cnt = dao.getBlameCountBySearch(conn , m);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	
	
	
}//class

//상세조회 해서 답변 작성하고 저장하는 것....

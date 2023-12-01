package com.semi.jdgr.admin.reply.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.admin.reply.dao.AdminReplyDao;
import com.semi.jdgr.admin.reply.vo.AdminReplyVo;
import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminReplyService {



	// 댓글글 목록 조회
	public List<AdminReplyVo> selectReplyList(PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		AdminReplyDao dao = new AdminReplyDao();
		List<AdminReplyVo> adminReplyVoList = dao.selectReplyList(conn, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return adminReplyVoList;
		
	}
	
//	//댓글 삭제
//	public int delete(String no, String memberNo) throws Exception {
//		//conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		//dao
//		AdminReplyDao dao = new AdminReplyDao();
//		int result = dao.delete(conn , no , memberNo);
//		
//		//tx
//		if(result == 1) {
//			JDBCTemplate.commit(conn);
//		}else {
//			JDBCTemplate.rollback(conn);
//		}
//		
//		//close
//		JDBCTemplate.close(conn);
//
//		return result;
//	}//delete
//	
//	
//	// 댓글 검색
//	public List<AdminReplyVo> search(Map<String, String> m , PageVo pvo) throws Exception {
//		// conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		// DAO
//		AdminReplyDao dao = new AdminReplyDao();
//		List<AdminReplyVo> boardVoList = dao.search(conn , m, pvo);
//		
//		//close
//		JDBCTemplate.close(conn);
//		
//		return boardVoList;
//	}
}

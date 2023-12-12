package com.semi.jdgr.user.reply.service;

import java.sql.Connection;
import java.util.List;

import com.semi.jdgr.user.reply.dao.ReplyDao;
import com.semi.jdgr.user.reply.vo.ReplyVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyService {
	//댓글 작성
	public int write(ReplyVo vo) throws Exception {
	
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ReplyDao dao = new ReplyDao();
		int result = dao.write(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	// 댓글 목록 조회
	public List<ReplyVo> getReplyListByNo(String postNo) throws Exception {
	
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		ReplyDao dao = new ReplyDao();
		List<ReplyVo> replyVoList = dao.getReplyList(conn, postNo);
		
		// close
		JDBCTemplate.close(conn);
		
		return replyVoList;
	}
	
}

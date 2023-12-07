package com.semi.jdgr.user.blame.service;

import java.sql.Connection;

import com.semi.jdgr.user.blame.dao.ReplyBlameDao;
import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyBlameService {

	public int blame(ReplyBlameVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		//dao
		ReplyBlameDao dao =  new ReplyBlameDao();
		int result = dao.blame(conn, vo);
		
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

}

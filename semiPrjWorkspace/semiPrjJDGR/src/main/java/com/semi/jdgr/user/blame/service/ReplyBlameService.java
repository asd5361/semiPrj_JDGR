package com.semi.jdgr.user.blame.service;

import java.sql.Connection;

import com.semi.jdgr.user.blame.dao.ReplyBlameDao;
import com.semi.jdgr.user.blame.vo.ReplyBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class ReplyBlameService {

	public int blame(ReplyBlameVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//세부사유 작성
		String detailContent = vo.getrBlaDetail();
		boolean detailContentOk = detailContent.matches("[a-z0-9]{0,100}");
		if(!detailContentOk) {
			throw new Exception("세부 사유를 작성하세요");
		}
		
		
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

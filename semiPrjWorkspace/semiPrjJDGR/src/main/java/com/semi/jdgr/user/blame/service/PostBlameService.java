package com.semi.jdgr.user.blame.service;

import java.sql.Connection;

import com.semi.jdgr.user.blame.dao.PostBlameDao;
import com.semi.jdgr.user.blame.vo.PostBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostBlameService {

	public int blame(PostBlameVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//신고 리스트 버튼 클릭
		String blameReason = vo.getpBlaList();
		if(blameReason == null) {
			throw new Exception("포스트에 해당되는 신고 항목을 선택하세요.");
		}
		
		//세부사유 작성
		String detailContent = vo.getpBlaDetail();
		boolean detailContentOk = detailContent.matches("[a-z0-9]{0,100}");
		if(!detailContentOk) {
			throw new Exception("세부 사유를 작성하세요");
		}
		
		
		//dao
		PostBlameDao dao =  new PostBlameDao();
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

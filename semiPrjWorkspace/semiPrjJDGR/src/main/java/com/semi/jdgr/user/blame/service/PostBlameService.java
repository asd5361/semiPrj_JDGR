package com.semi.jdgr.user.blame.service;

import java.sql.Connection;
import java.util.List;

import com.semi.jdgr.user.blame.dao.PostBlameDao;
import com.semi.jdgr.user.blame.dao.ReplyBlameDao;
import com.semi.jdgr.user.blame.vo.PostBlameVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostBlameService {

	public int blame(PostBlameVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
//
//		//세부사유 작성
//		String detailContent = vo.getpBlaDetail();
//		boolean detailContentOk = detailContent.matches("[a-z0-9]{0,100}");
//		if(!detailContentOk) {
//			throw new Exception("세부 사유를 작성하세요");
//		}

		
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

	}//blame
	
	
	
	
	//bla_reason 리스트 불러와서 모달창에 띄우기
	public List<String> blameList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();

		
		//dao
		ReplyBlameDao dao =  new ReplyBlameDao();
		List<String> voList = dao.blameList(conn);		
		

		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
				
	}//blameList

}

package com.semi.jdgr.post.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.notice.dao.NoticeDao;
import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.post.dao.PostDaoLYJ;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceLYJ {
	
	//맨 처음에 보이는 전체 리스트 조회
	public List<PostVo> allSelectPostList(PostVo postVo ) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoLYJ dao = new PostDaoLYJ();
		List<PostVo> postVoList = dao.allSelectPostList(conn, postVo);
		
		
		// 공감수 조회하는 쿼리문 실행
		for (PostVo vo : postVoList) {
//					vo = postVoList.get(0)
 			String heartCnt = dao.getheartCnt(conn , vo.getPostNo());
			vo.setHeartCnt(heartCnt);
		}
		
		// 댓글수 조회하는 쿼리문 실행		
		for (PostVo vo : postVoList) {
			String replyCnt = dao.getreplyCnt(conn , vo.getPostNo());
			vo.setReplyCnt(replyCnt);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return postVoList;

	}//allSelectPostList
	
	

	//포스트 관리 목록 조회(관리자)
	public List<PostVo> selectPostList(String memNick) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoLYJ dao = new PostDaoLYJ();
		List<PostVo> postVoList = dao.selectPostList(conn, memNick);
		
		
		// 공감수 조회하는 쿼리문 실행
		for (PostVo vo : postVoList) {
//			vo = postVoList.get(0)
 			String heartCnt = dao.getheartCnt(conn , vo.getPostNo());
			vo.setHeartCnt(heartCnt);
		}
		
		// 댓글수 조회하는 쿼리문 실행		
		for (PostVo vo : postVoList) {
			String replyCnt = dao.getreplyCnt(conn , vo.getPostNo());
			vo.setReplyCnt(replyCnt);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return postVoList;
	
	}//selectPostList


	// 게시글 갯수 조회(맨 처음에 보이는 전체 리스트 조회)
	public int selectSearchBoardCount() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		PostDaoLYJ dao = new PostDaoLYJ();
		int cnt = dao.getBoardCountBySearch(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	

	
	
	
	
	

}//class

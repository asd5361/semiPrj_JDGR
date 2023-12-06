package com.semi.jdgr.csboard.service;

import java.sql.Connection;
import java.util.List;

import com.semi.jdgr.csboard.dao.CsboardDao;
import com.semi.jdgr.csboard.vo.CsboardVo;
import com.semi.jdgr.notice.vo.NoticeVo;
import com.semi.jdgr.page.vo.PageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class CsboardService {

	//문의글 상위 5개 불러오기
	public List<CsboardVo> selectCsboardTopList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		List<CsboardVo> csboardVoList = dao.selectCsboardTopList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return csboardVoList;
	}

	public int selectCsboardCount() throws Exception {

		//conn
		Connection conn =JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		int cnt = dao.selectCsboardCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<CsboardVo> selectCsboardList(PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		List<CsboardVo> csboardVo = dao.selectCsboardList(conn,pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return csboardVo;
	}

	public int selectSearchCsboardCount(String searchValue) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		int cnt = dao.selectSearchCsboardCount(conn,searchValue);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<CsboardVo> search(String searchValue, PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		List<CsboardVo> csboardVoList = dao.search(conn,searchValue,pvo);
		//close
		
		
		return csboardVoList;
	}

	public CsboardVo csboardDetail(String board) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		CsboardVo vo = dao.csboardDetail(conn,board);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int CsboardWrite(CsboardVo vo) throws Exception{
		
		//conn
		Connection conn =JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		int result = dao.CsboardWrite(conn,vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int selectAdminCsboardCount() throws Exception {
		
		//conn
		Connection conn =JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		int cnt = dao.selectAdminCsboardCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<CsboardVo> selectAdminNoticeList(PageVo pvo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		CsboardDao dao = new CsboardDao();
		List<CsboardVo> csboardVo = dao.selectAdminNoticeList(conn,pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return csboardVo;
	}




}

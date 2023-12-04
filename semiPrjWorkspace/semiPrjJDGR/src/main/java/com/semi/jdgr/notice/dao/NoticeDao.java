package com.semi.jdgr.notice.dao;

import java.sql.*;
import java.util.*;

import com.semi.jdgr.notice.vo.NoticeVo;
import com.semi.jdgr.post.vo.PageVo;
import com.semi.jdgr.util.JDBCTemplate;

public class NoticeDao {
	//공지사항 상위 5개 조회하기
	public List<NoticeVo> selectNoticeTopList(Connection conn) throws SQLException {
		
		//sql
		String sql="SELECT * FROM NOTICE WHERE ROWNUM <= 5 ORDER BY FIXED_YN DESC,NOTICE_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		
		//rs
		while(rs.next()) {
			NoticeVo vo = new NoticeVo();
			
			vo.setNoticeNo(rs.getString("NOTICE_NO"));
			vo.setAdminNo(rs.getString("ADMIN_NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setInquiry(rs.getString("INQUIRY"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			vo.setUpdateDate(rs.getString("UPDATE_DATE"));
			vo.setFixedYn(rs.getString("FIXED_YN"));
			vo.setDelYn(rs.getString("DEL_YN"));
			
			noticeVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return noticeVoList;
		
	}
	//게시글 전체 조회
	public List<NoticeVo> selectNoticeList(Connection conn, PageVo pvo) throws SQLException {
		//페이징 처리 까지 완료
		String sql="SELECT * FROM (SELECT ROWNUM RNUM, N.* FROM (SELECT * FROM NOTICE WHERE DEL_YN = 'Y' ORDER BY NOTICE_NO DESC)N )WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		
		//rs
		while(rs.next()) {
			NoticeVo vo = new NoticeVo();
			
			vo.setNoticeNo(rs.getString("NOTICE_NO"));
			vo.setAdminNo(rs.getString("ADMIN_NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setInquiry(rs.getString("INQUIRY"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			vo.setUpdateDate(rs.getString("UPDATE_DATE"));
			vo.setFixedYn(rs.getString("FIXED_YN"));
			vo.setDelYn(rs.getString("DEL_YN"));
			
			noticeVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return noticeVoList;
	}
	//게시글 전체 갯수 확인 
	public int selectNoticeCount(Connection conn) throws SQLException {
		
		//sql
		String sql = "SELECT COUNT(*) FROM NOTICE WHERE DEL_YN = 'Y'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int cnt = 0;
		
		//rs
		if(rs.next()) {
			cnt = rs.getInt(1);	//첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}
	
	//게시글 검색 조회
	public List<NoticeVo> search(Connection conn, String searchValue, PageVo pvo) throws Exception{
		
		//sql
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, N.* FROM (SELECT * FROM NOTICE WHERE TITLE LIKE '%'||?||'%' OR CONTENT LIKE '%'||?||'%'  AND DEL_YN = 'Y' ORDER BY NOTICE_NO DESC)N )WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setString(2, searchValue);
		pstmt.setInt(3, pvo.getStartRow());
		pstmt.setInt(4, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		
		//rs
		while(rs.next()) {
			NoticeVo vo = new NoticeVo();
			
			vo.setNoticeNo(rs.getString("NOTICE_NO"));
			vo.setAdminNo(rs.getString("ADMIN_NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setInquiry(rs.getString("INQUIRY"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			vo.setUpdateDate(rs.getString("UPDATE_DATE"));
			vo.setFixedYn(rs.getString("FIXED_YN"));
			vo.setDelYn(rs.getString("DEL_YN"));
			
			noticeVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return noticeVoList;
		
	}
	//전체 검색 게시글 갯수 확인
	public int selectSearchNoticeCount(Connection conn, String searchValue) throws SQLException {
		
		//sql
		String sql = "SELECT COUNT(*) FROM NOTICE WHERE TITLE LIKE '%'||?||'%' OR CONTENT LIKE '%'||?||'%'  AND DEL_YN = 'Y'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setString(2, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		int cnt = 0;
		while(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

}

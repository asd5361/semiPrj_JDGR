package com.semi.jdgr.notice.dao;

import java.sql.*;
import java.util.*;

import com.semi.jdgr.notice.vo.NoticeVo;
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

	public List<NoticeVo> selectNoticeList(Connection conn) throws SQLException {
		//sql 임시로 10개만
		String sql="SELECT * FROM NOTICE WHERE ROWNUM <= 10 ORDER BY FIXED_YN DESC,NOTICE_NO DESC";
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

}

package com.semi.jdgr.user.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		// sql
				String sql = "INSERT INTO MEMBER (MEM_NO,MEM_NAME,MEM_ID,MEM_PWD,MEM_NICK,MEM_PHONE_NUM,MEM_EMAIL) VALUES (SEQ_MEMBER.NEXTVAL, ?,?, ?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getMemName());
				pstmt.setString(2, vo.getMemId());
				pstmt.setString(3, vo.getMemPwd());
				pstmt.setString(4, vo.getMemNick());
				pstmt.setString(5, vo.getMemPhoneNum());
				pstmt.setString(6, "vkfkdjafuf2@naver.com");
				int result = pstmt.executeUpdate();
				
				// close
				JDBCTemplate.close(pstmt);
				
				return result;
				
	}

	public boolean checkIdDup(Connection conn, String memberId) throws Exception {
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		ResultSet rs = pstmt.executeQuery();
		
		boolean result = true;
		if(rs.next()) {
			result = false;
		}
		
		System.out.println(result);
		return result;
	}

}

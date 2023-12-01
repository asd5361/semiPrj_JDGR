package com.semi.jdgr.user.csboard.dao;

import java.sql.*;
import java.util.*;

import com.semi.jdgr.user.csboard.vo.CsboardVo;

public class CsboardDao {

	public List<CsboardVo> selectCsboardTopList(Connection conn) throws SQLException {
		
		//sql
		String sql = "SELECT * FROM CUSTOMER_CENTER WHERE ROWNUM <= 5 ORDER BY DEL_YN DESC,Q_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<CsboardVo> CsboardVoList = new ArrayList<CsboardVo>();
		//rs
		while(rs.next()) {
			CsboardVo vo = new CsboardVo();
			//rs 부분  수정하기
			vo.setqNo(rs.getString("Q_NO"));
			vo.setAdminNo(rs.getString("Q_NO"));
			vo.setMemNo(rs.getString("Q_NO"));
			vo.setqTit(rs.getString("Q_NO"));
			vo.setqCon((rs.getString("Q_NO")));
			vo.setqWriteDate(rs.getString("Q_NO"));
			vo.setAnsewr(rs.getString("Q_NO"));
			vo.setAnsewrDate(rs.getString("Q_NO"));
			vo.setUpdateDate(rs.getString("Q_NO"));
			vo.setDelYn(rs.getString("Q_NO"));
			vo.setQuestionCategory(rs.getString("Q_NO"));
			
			
			
			
			
			
			
			
			
			
		}
		
		
		//close
		
		
		return null;
	}

}

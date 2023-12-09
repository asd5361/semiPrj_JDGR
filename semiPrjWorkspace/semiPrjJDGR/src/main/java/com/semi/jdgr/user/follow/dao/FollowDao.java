package com.semi.jdgr.user.follow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.user.follow.vo.FollowVo;

public class FollowDao {
	
	// 유저 넘버로 구독자 리스트 가져오기
	public List<FollowVo> getFollowListByUserNo(Connection conn, String userNo) throws Exception{
		
		// sql
		String sql = "SELECT F.MEM_NO, B.MEM_NO AS FOLLOW_BLOG_MEM FROM FOLLOW F JOIN BLOG B ON B.BLOG_NO = F.BLOG_NO WHERE F.MEM_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<FollowVo> followVoList = new ArrayList<FollowVo>();
		while(rs.next()) {
			String followBlogMem = rs.getString("FOLLOW_BLOG_MEM");
			String MemNo = rs.getString("MEM_NO");
			
			FollowVo vo = new FollowVo();
			vo.setFollowMem(followBlogMem);
			vo.setMemNo(MemNo);
			
			followVoList.add(vo);
		}
		
		// close
		
		return followVoList;
	}
	
}

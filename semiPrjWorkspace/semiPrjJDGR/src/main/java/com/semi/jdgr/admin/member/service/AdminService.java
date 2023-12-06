package com.semi.jdgr.admin.member.service;

import java.sql.Connection;

import com.semi.jdgr.admin.member.dao.AdminDao;
import com.semi.jdgr.admin.member.vo.AdaminVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AdminService {

	public AdaminVo login(AdaminVo vo) throws Exception {
		//conn
				Connection conn = JDBCTemplate.getConnection();
				
				//dao
				AdminDao dao = new AdminDao();
				AdaminVo loginMember = dao.login(conn ,vo);
				
				//close
				JDBCTemplate.close(conn);
				
				return loginMember;	
			
	}

}

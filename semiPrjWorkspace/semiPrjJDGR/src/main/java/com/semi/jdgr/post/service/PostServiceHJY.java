package com.semi.jdgr.post.service;

import java.sql.Connection;

import com.semi.jdgr.alarm.dao.AlarmDaoHJY;
import com.semi.jdgr.blog.dao.BlogDao;
import com.semi.jdgr.blog.vo.BlogVo;
import com.semi.jdgr.post.dao.PostDaoHJY;
import com.semi.jdgr.post.vo.PostVo;
import com.semi.jdgr.util.JDBCTemplate;

public class PostServiceHJY {

	// 포스트 작성
	public int postWrite(PostVo postVo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		PostDaoHJY dao = new PostDaoHJY();
		BlogDao blogDao = new BlogDao();
		BlogVo blogVo = blogDao.getUserBlog(conn, postVo.getBlogUrl());
		int result = dao.postWrite(conn, postVo, blogVo.getBlogNo());
		
		// 비즈니스로직
		
		// 알람에 insert
		AlarmDaoHJY alarmDao = new AlarmDaoHJY();
		//int alarmResult = alarmDao.postCreateAlarm(); 여기서부터해야됨
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

}

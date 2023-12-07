package com.semi.jdgr.alarm.service;

import java.sql.Connection;

import com.semi.jdgr.alarm.dao.AlarmDao;
import com.semi.jdgr.alarm.vo.AlarmVo;
import com.semi.jdgr.user.member.vo.MemberVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AlarmService {

	public AlarmVo selectAlarm(String memNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		AlarmDao dao = new AlarmDao();
		AlarmVo alarmVo = dao.selectAlarm(conn, memNo);

		// close
		JDBCTemplate.close(conn);

		return alarmVo;
	}

}

package com.semi.jdgr.alarm.service;

import java.sql.Connection;
import java.util.List;

import com.semi.jdgr.alarm.dao.AlarmDao;
import com.semi.jdgr.alarm.vo.AlarmVo;
import com.semi.jdgr.util.JDBCTemplate;

public class AlarmService {

	

	public List<AlarmVo> selectAlarmList(String memNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		AlarmDao dao = new AlarmDao();
		List<AlarmVo> alarmVoList = dao.selectAlarmList(conn, memNo);

		// close
		JDBCTemplate.close(conn);

		return alarmVoList;
	}

}

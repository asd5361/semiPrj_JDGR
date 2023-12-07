package com.semi.jdgr.alarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.semi.jdgr.alarm.vo.AlarmVo;

public class AlarmDao {



	public List<AlarmVo> selectAlarmList(Connection conn, String memNo) throws Exception {
		String sql = "SELECT * FROM ALARM WHERE RECEIVER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<AlarmVo> alarmVoList = new ArrayList<AlarmVo>();
		
		while(rs.next()) {
			String alarmNo = rs.getString("ALARM_NO");
			String receiverNo = rs.getString("RECEIVER_NO");
			String postNo = rs.getString("POST_NO");
			String senderNo = rs.getString("SENDER_NO");
			String alarmType = rs.getString("ALARM_TYPE");
			String alarmDate = rs.getString("ALARM_DATE");
			String activeYn = rs.getString("ACTIVE_YN");
			
			AlarmVo alarmVo = new AlarmVo();
			
			alarmVo.setAlarmNo(alarmNo);
			alarmVo.setReceiverNo(receiverNo);
			alarmVo.setPostNo(postNo);
			alarmVo.setSenderNo(senderNo);
			alarmVo.setAlarmType(alarmType);
			alarmVo.setAlarmDate(alarmDate);
			alarmVo.setActiveYn(activeYn);
			
			alarmVoList.add(alarmVo);
		}
		return alarmVoList;
	}

	

}

package com.semi.jdgr.alarm.vo;

public class AlarmVo {
	
	
	private String alarmNo;
	private String receiverNo;
	private String postNo;
	private String senderNo;
	private String alarmType;
	private String alarmDate;
	private String activeYn;
	public AlarmVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlarmVo(String alarmNo, String receiverNo, String postNo, String senderNo, String alarmType,
			String alarmDate, String activeYn) {
		super();
		this.alarmNo = alarmNo;
		this.receiverNo = receiverNo;
		this.postNo = postNo;
		this.senderNo = senderNo;
		this.alarmType = alarmType;
		this.alarmDate = alarmDate;
		this.activeYn = activeYn;
	}
	@Override
	public String toString() {
		return "AlarmVo [alarmNo=" + alarmNo + ", receiverNo=" + receiverNo + ", postNo=" + postNo + ", senderNo="
				+ senderNo + ", alarmType=" + alarmType + ", alarmDate=" + alarmDate + ", activeYn=" + activeYn + "]";
	}
	public String getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(String alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getReceiverNo() {
		return receiverNo;
	}
	public void setReceiverNo(String receiverNo) {
		this.receiverNo = receiverNo;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getSenderNo() {
		return senderNo;
	}
	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(String alarmDate) {
		this.alarmDate = alarmDate;
	}
	public String getActiveYn() {
		return activeYn;
	}
	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}
	
	
}

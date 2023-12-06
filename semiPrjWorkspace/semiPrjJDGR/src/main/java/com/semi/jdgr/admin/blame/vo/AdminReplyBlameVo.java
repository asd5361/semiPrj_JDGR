package com.semi.jdgr.admin.blame.vo;

public class AdminReplyBlameVo {
	
	r_bla_no
	r_no
	r_blamer_no
	r_writer_no
	r_bla_con
	r_bla_date
	r_bla_list
	r_bla_detail_reason
	r_sanc_yn
	r_ans_date
	r_bla_detail
	r_del_yn

	
	private String rBlaNo;
	private String rNo;
	private String rBlamerNo;
	private String rWriterNo;
	private String rBlaCon;
	private String rBlaDate;
	private String r_bla_list;
	private String r_bla_detail_reason;
	private String r_sanc_yn;
	private String r_ans_date;
	private String r_bla_detail;
	private String r_del_yn;
	
	
	public String getBlameNo() {
		return blameNo;
	}
	public void setBlameNo(String blameNo) {
		this.blameNo = blameNo;
	}
	public String getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getBlameDate() {
		return blameDate;
	}
	public void setBlameDate(String blameDate) {
		this.blameDate = blameDate;
	}
	public String getBlaList() {
		return blaList;
	}
	public void setBlaList(String blaList) {
		this.blaList = blaList;
	}
	public String getSancYn() {
		return sancYn;
	}
	public void setSancYn(String sancYn) {
		this.sancYn = sancYn;
	}
	public String getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(String ansDate) {
		this.ansDate = ansDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getBlamerNo() {
		return blamerNo;
	}
	public void setBlamerNo(String blamerNo) {
		this.blamerNo = blamerNo;
	}
	public String getBlamerId() {
		return blamerId;
	}
	public void setBlamerId(String blamerId) {
		this.blamerId = blamerId;
	}
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	public AdminReplyBlameVo(String blameNo, String replyNo, String postNo, String title, String con, String blameDate,
			String blaList, String sancYn, String ansDate, String delYn, String blamerNo, String blamerId, String memNo,
			String memId) {
		super();
		this.blameNo = blameNo;
		this.replyNo = replyNo;
		this.postNo = postNo;
		this.title = title;
		this.con = con;
		this.blameDate = blameDate;
		this.blaList = blaList;
		this.sancYn = sancYn;
		this.ansDate = ansDate;
		this.delYn = delYn;
		this.blamerNo = blamerNo;
		this.blamerId = blamerId;
		this.memNo = memNo;
		this.memId = memId;
	}
	
	
	@Override
	public String toString() {
		return "AdminBlameVo [blameNo=" + blameNo + ", replyNo=" + replyNo + ", postNo=" + postNo + ", title=" + title
				+ ", con=" + con + ", blameDate=" + blameDate + ", blaList=" + blaList + ", sancYn=" + sancYn
				+ ", ansDate=" + ansDate + ", delYn=" + delYn + ", blamerNo=" + blamerNo + ", blamerId=" + blamerId
				+ ", memNo=" + memNo + ", memId=" + memId + "]";
	}
	
	
	public AdminReplyBlameVo() {
	}
	
	
	
	

}
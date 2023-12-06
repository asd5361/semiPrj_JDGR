package com.semi.jdgr.admin.blame.vo;

public class AdminBlameVo {
	
	private String blameNo;
	private String replyNo;		//댓글 번호
	private String postNo;		//포스트 번호
	private String title;		//포스트 제목
	private String con;			//댓글 내용
	private String blameDate;	//신고일자
	private String blaList;		//사유 항목(번호)
	private String sancYn;		//제재여부
	private String ansDate;		//답변일자
	private String delYn;
	private String blamerNo;	//신고자 번호
	private String blamerId;	//신고자 아이디 
	private String memNo;		//작성자 이름
	private String memId;		//작성자 아이디
	
	
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
	
	
	public AdminBlameVo(String blameNo, String replyNo, String postNo, String title, String con, String blameDate,
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
	
	
	public AdminBlameVo() {
	}
	
	
	
	

}
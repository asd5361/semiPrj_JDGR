package com.semi.jdgr.post.vo;

public class PostVo {

	private String postNo;
	private String blogNo;
	private String categoryNo;
	private String groupNo;
	private String title;
	private String content;
	private String open;
	private String inquiry;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	private String postImg;
	private String categoryName;
	private String groupName;
	private String heartCnt;
	private String replyCnt;

	public PostVo() {
	}

	public PostVo(String postNo, String blogNo, String categoryNo, String groupNo, String title, String content,
			String open, String inquiry, String enrollDate, String modifyDate, String delYn, String postImg,
			String categoryName, String groupName, String heartCnt, String replyCnt) {
		this.postNo = postNo;
		this.blogNo = blogNo;
		this.categoryNo = categoryNo;
		this.groupNo = groupNo;
		this.title = title;
		this.content = content;
		this.open = open;
		this.inquiry = inquiry;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
		this.postImg = postImg;
		this.categoryName = categoryName;
		this.groupName = groupName;
		this.heartCnt = heartCnt;
		this.replyCnt = replyCnt;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(String blogNo) {
		this.blogNo = blogNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getPostImg() {
		return postImg;
	}

	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getHeartCnt() {
		return heartCnt;
	}

	public void setHeartCnt(String heartCnt) {
		this.heartCnt = heartCnt;
	}

	public String getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(String replyCnt) {
		this.replyCnt = replyCnt;
	}

	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", blogNo=" + blogNo + ", categoryNo=" + categoryNo + ", groupNo=" + groupNo
				+ ", title=" + title + ", content=" + content + ", open=" + open + ", inquiry=" + inquiry
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn=" + delYn + ", postImg="
				+ postImg + ", categoryName=" + categoryName + ", groupName=" + groupName + ", heartCnt=" + heartCnt
				+ ", replyCnt=" + replyCnt + "]";
	}

}

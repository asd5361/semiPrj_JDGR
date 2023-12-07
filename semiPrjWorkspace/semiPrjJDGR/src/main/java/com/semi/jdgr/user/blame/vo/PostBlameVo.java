package com.semi.jdgr.user.blame.vo;

import java.util.Arrays;

public class PostBlameVo {
	
	
	private String pBlaNo;
	private String pNo;
	private String pBlamerNo;
	private String pWriterNo;
	private String pBlaTit;
	private String pBlaDate;
	private String[] pBlaList;
	private String pBlaListStr;
	private String pSancYn;
	private String pAnsDate;
	private String pBlaDetail;
	private String pDelYn;
	
	
	public String getpBlaNo() {
		return pBlaNo;
	}
	public void setpBlaNo(String pBlaNo) {
		this.pBlaNo = pBlaNo;
	}
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getpBlamerNo() {
		return pBlamerNo;
	}
	public void setpBlamerNo(String pBlamerNo) {
		this.pBlamerNo = pBlamerNo;
	}
	public String getpWriterNo() {
		return pWriterNo;
	}
	public void setpWriterNo(String pWriterNo) {
		this.pWriterNo = pWriterNo;
	}
	public String getpBlaTit() {
		return pBlaTit;
	}
	public void setpBlaTit(String pBlaTit) {
		this.pBlaTit = pBlaTit;
	}
	public String getpBlaDate() {
		return pBlaDate;
	}
	public void setpBlaDate(String pBlaDate) {
		this.pBlaDate = pBlaDate;
	}
	public String[] getpBlaList() {
		return pBlaList;
	}
	public void setpBlaList(String[] pBlaList) {
		if(pBlaList == null) {
			this.pBlaListStr = "";
			return;
		}
		this.pBlaList = pBlaList;
		this.pBlaListStr = String.join(",", pBlaList);
	}
	public String getpBlaListStr() {
		return pBlaListStr;
	}
	public void setpBlaListStr(String pBlaListStr) {
		this.pBlaListStr = pBlaListStr;
	}
	public String getpSancYn() {
		return pSancYn;
	}
	public void setpSancYn(String pSancYn) {
		this.pSancYn = pSancYn;
	}
	public String getpAnsDate() {
		return pAnsDate;
	}
	public void setpAnsDate(String pAnsDate) {
		this.pAnsDate = pAnsDate;
	}
	public String getpBlaDetail() {
		return pBlaDetail;
	}
	public void setpBlaDetail(String pBlaDetail) {
		this.pBlaDetail = pBlaDetail;
	}
	public String getpDelYn() {
		return pDelYn;
	}
	public void setpDelYn(String pDelYn) {
		this.pDelYn = pDelYn;
	}
	public PostBlameVo(String pBlaNo, String pNo, String pBlamerNo, String pWriterNo, String pBlaTit, String pBlaDate,
			String[] pBlaList, String pBlaListStr, String pSancYn, String pAnsDate, String pBlaDetail, String pDelYn) {
		super();
		this.pBlaNo = pBlaNo;
		this.pNo = pNo;
		this.pBlamerNo = pBlamerNo;
		this.pWriterNo = pWriterNo;
		this.pBlaTit = pBlaTit;
		this.pBlaDate = pBlaDate;
		this.pSancYn = pSancYn;
		this.pAnsDate = pAnsDate;
		this.pBlaDetail = pBlaDetail;
		this.pDelYn = pDelYn;
		this.pBlaList = pBlaList;
		this.pBlaListStr = pBlaListStr;
	}
	@Override
	public String toString() {
		return "PostBlameVo [pBlaNo=" + pBlaNo + ", pNo=" + pNo + ", pBlamerNo=" + pBlamerNo + ", pWriterNo="
				+ pWriterNo + ", pBlaTit=" + pBlaTit + ", pBlaDate=" + pBlaDate + ", pBlaList="
				+ Arrays.toString(pBlaList) + ", pBlaListStr=" + pBlaListStr + ", pSancYn=" + pSancYn + ", pAnsDate="
				+ pAnsDate + ", pBlaDetail=" + pBlaDetail + ", pDelYn=" + pDelYn + "]";
	}
	public PostBlameVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

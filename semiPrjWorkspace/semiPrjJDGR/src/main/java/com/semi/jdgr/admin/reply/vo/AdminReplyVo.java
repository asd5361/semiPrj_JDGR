package com.semi.jdgr.admin.reply.vo;

public class AdminReplyVo {

	private int listCount;		// 총 게시글 갯수
	private int currentPage;	// 현재페이지
	private int pageLimit;		// 페이징 영역 페이지갯수
	private int boardLimit;		// 한 페이지에 보여줄 게시글 갯수
	
	private int maxPage;		// 가장 마지막 페이지
	private int startPage;		// 페이징 영역 시작값
	private int endPage;		// 페이징 영역 마지막값
	
	private int startRow;		// 조회할 첫번째 행 번호 (ROWNUM)
	private int lastRow;		// 조회할 마지막 행 번호 (ROWNUM)
	
	
	//생성자
	public AdminReplyVo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage, int startRow, int lastRow) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.lastRow = lastRow;
	}


	public int getListCount() {
		return listCount;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageLimit() {
		return pageLimit;
	}


	public int getBoardLimit() {
		return boardLimit;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public int getStartRow() {
		return startRow;
	}


	public int getLastRow() {
		return lastRow;
	}
	
	
//------------------------------------------------------------------

	private String postNo;
	private String replyMem;
	private String parentsNo;
	private String con;
	private String writeDate;
	private String delYn;
	
	private String replyNo;
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


	public String getReplyMem() {
		return replyMem;
	}


	public void setReplyMem(String replyMem) {
		this.replyMem = replyMem;
	}


	public String getParentsNo() {
		return parentsNo;
	}


	public void setParentsNo(String parentsNo) {
		this.parentsNo = parentsNo;
	}


	public String getCon() {
		return con;
	}


	public void setCon(String con) {
		this.con = con;
	}


	public String getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}


	public String getDelYn() {
		return delYn;
	}


	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	@Override
	public String toString() {
		return "AdminReplyVo [replyMem=" + replyMem + ", parentsNo=" + parentsNo + ", con=" + con + ", writeDate="
				+ writeDate + ", delYn=" + delYn + ", replyNo=" + replyNo + "]";
	}


	public AdminReplyVo(String replyMem, String parentsNo, String con, String writeDate, String delYn, String replyNo) {
		super();
		this.replyMem = replyMem;
		this.parentsNo = parentsNo;
		this.con = con;
		this.writeDate = writeDate;
		this.delYn = delYn;
		this.replyNo = replyNo;
	}


	public AdminReplyVo() {
	}


	
	
}

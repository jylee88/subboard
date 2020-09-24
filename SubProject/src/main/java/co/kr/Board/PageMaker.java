package co.kr.Board;

public class PageMaker {
	private boolean prev;
	private boolean next;
	private int pageNum;	//전체 페이지 갯수
	private int pageCnt; 	//몇개씩 보여줄지
	private int startPage;
	private int endPage;
	private int total;
	private Criteria criteria;
	
	public PageMaker() {
		this.startPage = 1;
		this.pageCnt = 5;
		this.endPage = this.pageCnt;
		this.prev = false;
		this.next = false;
	}
	
	
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void makePageNum(int total) {
		double result = Math.ceil((double)total / criteria.getEnd());		
		this.pageNum = (int)result;
		
		
		if(endPage < pageNum) {
			next = true;
		}
		
		if(criteria.getPage() > endPage)
		{
			startPage += pageCnt;
			endPage += pageCnt;
			prev = true;
		}
		
		if(endPage > pageNum) {
			endPage = pageNum;
			next = false;
		}
		
	}

	@Override
	public String toString() {
		return "PageMaker [prev=" + prev + ", next=" + next + ", pageNum=" + pageNum + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", total=" + total + ", criteria=" + criteria + "]";
	}
	
	
	
	
	
	
	
	
	
}

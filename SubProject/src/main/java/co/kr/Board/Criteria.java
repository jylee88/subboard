package co.kr.Board;

public class Criteria {
	private int page;
	private int start;
	private int end;
	private String b_code;
	
	public Criteria() {
		this.end = 1;
		this.start = 0;
		this.end = 10;
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int getpage) {
		if(getpage <= 0)
		{
			return;
		}
		this.start = (getpage - 1) * 10;
					
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	public String getB_code() {
		return b_code;
	}

	public void setB_code(String b_code) {
		this.b_code = b_code;
	}
	
	
}

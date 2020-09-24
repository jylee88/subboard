package co.kr.Board;

public class BoardDTO {
	private int b_number;
	private String b_id;
	private String b_content;
	private String b_title;
	private int b_del;
	private int b_cnt;
	private String b_code;
	
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}	
	
	public int getB_del() {
		return b_del;
	}
	public void setB_del(int b_del) {
		this.b_del = b_del;
	}
	public int getB_cnt() {
		return b_cnt;
	}
	public void setB_cnt(int b_cnt) {
		this.b_cnt = b_cnt;
	}
	public String getB_code() {
		return b_code;
	}
	public void setB_code(String b_code) {
		this.b_code = b_code;
	}
	@Override
	public String toString() {
		return "BoardDTO [b_number=" + b_number + ", b_id=" + b_id + ", b_content=" + b_content + ", b_title=" + b_title
				+ "]";
	}
	
	
}

package co.kr.Board;

public class Reply {
	private int r_number;
	private int b_number;
	private String r_id;
	private String r_content;
	
	public int getR_number() {
		return r_number;
	}
	public void setR_number(int r_number) {
		this.r_number = r_number;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	
	@Override
	public String toString() {
		return "Reply [r_number=" + r_number + ", b_number=" + b_number + ", r_id=" + r_id + ", r_content=" + r_content
				+ "]";
	}

	
}

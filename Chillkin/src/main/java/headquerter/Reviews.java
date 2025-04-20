package headquerter;

public class Reviews {

	String r_Code;
	String id;
	String detail;
	String answer;
	String title;
	String r_Date;
	
	
	public Reviews(String r_Code, String id, String detail, String answer, String title, String r_Date) {
		super();
		this.r_Code = r_Code;
		this.id = id;
		this.detail = detail;
		this.answer = answer;
		this.title = title;
		this.r_Date = r_Date;
	}


	public String getR_code() {
		return r_Code;
	}


	public String getId() {
		return id;
	}


	public String getDetail() {
		return detail;
	}


	public String getAnswer() {
		return answer;
	}


	public String getTitle() {
		return title;
	}
	
	public String getR_date() {
		return r_Date;
	}


	@Override
	public String toString() {
		return "Reviews [r_Code=" + r_Code + ", id=" + id + ", detail=" + detail + ", answer=" + answer + ", title="
				+ title + ", r_Date=" + r_Date + "]";
	}


	

	
	
	
}

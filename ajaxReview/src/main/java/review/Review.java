package review;

public class Review {
	String id;
	String content;
	
	public Review(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + "]";
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	
}

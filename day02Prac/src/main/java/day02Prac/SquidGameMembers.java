package day02Prac;

import java.sql.Date;

public class SquidGameMembers {
	String id;
	String pw;
	String name;
	String phone;
	Date birth;
	String point;
	String grade;
	
	
	
	public SquidGameMembers(String id, String name, String phone, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.grade = grade;
	}

	public SquidGameMembers(String id, String pw, String name, String phone, Date birth, String point, String grade) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.point = point;
		this.grade = grade;
	}
	
	public SquidGameMembers() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Date getBirth() {
		return birth;
	}

	public String getPoint() {
		return point;
	}

	public String getGrade() {
		return grade;
	}
	
	
	
}

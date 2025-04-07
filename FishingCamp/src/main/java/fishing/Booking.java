package fishing;

public class Booking {
	String b_code; //예약코드
	int days; //몇일 예약했는지
	int f_num; //좌대번호
	String a_code; //예약한 낚시꾼 고유번호
	
	public Booking() {}

	public Booking(String b_code, int days, int f_num, String a_code) {
		this.b_code = b_code;
		this.days = days;
		this.f_num = f_num;
		this.a_code = a_code;
	}

	public String getB_code() {
		return b_code;
	}

	public int getDays() {
		return days;
	}

	public int getF_num() {
		return f_num;
	}

	public String getA_code() {
		return a_code;
	}

	@Override
	public String toString() {
		return "예약정보 [예약번호=" + b_code + ", 일수=" + days + ", 좌대번호=" + f_num + ", 낚시꾼 코드=" + a_code + "]";
	}
	
	
}

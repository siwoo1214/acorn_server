package headquerter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	private Connection dbCon() {		
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) { System.out.println("db ok");}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<Reviews> allReviews(){
		ArrayList<Reviews> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from Reviews";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String r_code = rs.getString(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String detail = rs.getString(5);
				String r_date = rs.getString(4);
				String answer = rs.getString(6);
				
				list.add(new Reviews(r_code,id,title,detail,r_date, answer)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//얘가 지금 하던거임 04/16버전
	public void writeAnswer(String r_code, String H_answer) {
		Reviews thatReview = null;
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews();
		for(Reviews b : list) {
			if(r_code.equals(b.getR_code())) {
				thatReview = b;
			}
		}
		
		Connection con = dbCon();
		String sql = "UPDATE Reviews\r\n"
				+ "SET ANSWER = ? \r\n"
				+ "WHERE R_CODE = ? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, H_answer);
			pst.setString(2, thatReview.getR_code());
			pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews();
		for(Reviews b : list) {
			System.out.println(b);
		}
//		a.writeAnswer(null, null);
//		String r_code = "R0001";
//		a.writeAnswer(r_code, "dkssudgktpdy rkatkgkqsl;ek");
	}
}

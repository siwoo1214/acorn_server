package fishing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver); //드라이버 설정
			con=DriverManager.getConnection(url, user, password); //이 정보들을 기준으로 DB에 엑세스하겠다
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;  //하고 엑세스한 정보 리턴하기
	}
	
	public ArrayList<Booking> selectAll(){
		ArrayList<Booking> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql = "select * from booking";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {
				String b_code = rs.getString(1);
				int days = rs.getInt(2);
				int f_num = rs.getInt(3);
				String a_code = rs.getString(4);
				
				Booking booking = new Booking(b_code,days,f_num,a_code);
				list.add(booking);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Booking selectOne(String s_B_code) {
		Connection con = getConnection();
		Booking booking = null;
		
		String sql = "select * from booking where B_CODE = ?";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s_B_code);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String new_B_code = rs.getString(1);
				int days = rs.getInt(2);
				int f_num = rs.getInt(3);
				String a_code = rs.getString(4);
				
				booking = new Booking(new_B_code,days,f_num,a_code);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;
	}
	
	public void insertBooking(Booking booking) {
		Connection con = getConnection();
		PreparedStatement pst = null;
		
		String sql = "insert into booking(b_code,days,f_num,a_code) values(?,?,?,?)";
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, booking.getB_code());
			pst.setInt(2, booking.getDays());
			pst.setInt(3, booking.getF_num());
			pst.setString(4, booking.getA_code());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BookingDAO b = new BookingDAO();
		
		ArrayList<Booking> list = new ArrayList<>();
		//전체조회 OK
//		list = b.selectAll();
//		for(Booking a : list) {
//			System.out.println(a);
//		}
		
		//하나 조회 OK
//		Booking booking = b.selectOne("B001");
//		System.out.println(booking);
		
		Booking newbook = new Booking("B003",4,1002,"A002");
		b.insertBooking(newbook);
		
		list = b.selectAll();
		for(Booking a : list) {
			System.out.println(a);
		}
	}
}
